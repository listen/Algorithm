#ifndef GEOMETRY__
#define GEOMETRY__

const int INF = 1000000000;

struct Point {
	int x;
	int y;

	Point(int _x = 0, int _y = 0) : x(_x), y(_y) {

	}

	string toStr() { 
		ostringstream oss;
		oss << "(" << x << ", " << y << ")";
		return oss.str();
	}
};

inline bool operator  < (const Point &A, const Point &B) { return A.y < B.y || A.y == B.y && A.x < B.x; }
inline bool operator == (const Point &A, const Point &B) { return A.x == B.x && A.y == B.y; }

inline Point operator + (const Point &A, const Point &B) { return Point(A.x + B.x, A.y + B.y); }
inline Point operator - (const Point &A, const Point &B) { return Point(A.x - B.x, A.y - B.y); }

inline Point operator * (         int c, const Point &P) { return Point(c * P.x, c * P.y); }
inline int   operator * (const Point &A, const Point &B) { return A.x * B.x + A.y * B.y; }
inline   int operator ^ (const Point &A, const Point &B) { return A.x * B.y - A.y * B.x; }


inline void swap(Point &A, Point &B) 
{
	swap(A.x, B.x);
	swap(A.y, B.y);
}

inline Point getIntersection(const Point &A, const Point &B, const Point &C, const Point &D) 
{
	return A + ((A - D) ^ (C - D)) / ((A - B) ^ (C - D)) * (B - A);
}

struct Segment {
	Point A;
	Point B;

	Segment(const Point &_A = Point(), const Point &_B = Point()) : A(_A), B(_B) {
		if (B < A) 
			swap(A, B);
	}

	string toStr() {
		ostringstream oss;
		oss << "(" << A.x << " " << A.y << ", " << B.x << " " << B.y << ")";
		return oss.str();
	}
};

inline bool onSegment(const Point &P, const Segment &s) 
{
	return ((P - s.A) ^ (s.B - s.A)) == 0 && !(P < s.A) && !(s.B < P);
}

inline int sign(int x) 
{
	return x == 0 ? 0 : (x < 0 ? -1 : 1);
}

bool intersect(const Segment &s1, const Segment &s2) 
{
	return 
		onSegment(s1.A, s2) || onSegment(s1.B, s2) || 
		onSegment(s2.A, s1) || onSegment(s2.B, s1) ||
		sign((s1.A - s2.A) ^ (s2.B - s2.A)) * sign((s1.B - s2.A) ^ (s2.B - s2.A)) < 0 &&
		sign((s2.A - s1.A) ^ (s1.B - s1.A)) * sign((s2.B - s1.A) ^ (s1.B - s1.A)) < 0;
}

/*
Jarvis's march, O(n*h), where h is the number of vertices of the convex hull 
return the convex hull in counterclockwise order
*/
vector<Point> convexHull(const vector<Point> &points) 
{
	assert(SZ(points) >= 3);
	vector<Point> res;
	int n = SZ(points);
	vector<bool> used(n);
	int at = 0;
	for (int i = 1; i < n; ++i) 
		if (points[i] < points[at]) 
			at = i;
	int s = at;
	do {
		res.push_back(points[at]);
		int nAt = -1;
		int bd = 0;
		for (int i = 0; i < n; ++i) 
			if (i != at && !used[i]) {
				if (nAt == -1) 
					nAt = i;
				int cp = (points[i] - points[at]) ^ (points[nAt] - points[at]);
				int cd = (points[i] - points[at]) * (points[i] - points[at]);
				if (cp > 0 || (cp == 0 && cd > bd)) {
					nAt = i;
					bd = cd;
				}	 
			}
			used[nAt] = true;
			at = nAt;
	} while (at != s);
	return res;
}

/*
Graham's scan, O(nlogn)
return the convex hull in counterclockwise order
*/
struct Less {
	Point A;

	Less(const Point &_A) : A(_A) {}

	bool operator () (const Point &B, const Point &C) const {
		int cp = (B - A) ^ (C - A);
		return cp > 0 || cp == 0 && (B - A) * (B - A) < (C - A) * (C - A);
	}
};

vector<Point> convexHull(vector<Point> points) 
{
	assert(SZ(points) >= 3);
	int s = -1;
	int n = SZ(points);
	for (int i = 0; i < n; ++i)
		if (s == -1 || points[i] < points[s])
			s = i;
	swap(points[s], points[0]);
	sort(points.begin() + 1, points.end(), Less(points[0]));
	vector<Point> res;
	res.push_back(points[0]);
	res.push_back(points[1]);
	for (int i = 2; i < n; ++i) {
		while (SZ(res) >= 2 && ((res[SZ(res) - 1] - res[SZ(res) - 2]) ^ (points[i] - res[SZ(res) - 2])) <= 0) 
			res.pop_back();
		res.push_back(points[i]);
	}
	return res;
}

int area(const vector<Point> &poly) 
{
	int res = 0;
	for (int i = 1; i < SZ(poly) - 1; ++i)
		res += (poly[i] - poly[0]) ^ (poly[i + 1] - poly[0]);
	return abs(res) / 2;
}

/*
In case of convex polygons, check if p is on the left side of 
the counterclockwise path formed by polygon.
*/
bool insideConvex(const Point &P, const vector<Point> &poly) 
{
	for (int j = SZ(poly) - 1, i = 0; i < SZ(poly); j = i++) 
		if (((poly[i] - poly[j]) ^ (P - poly[j])) <= 0) 
			return false;
	return true;
}

/*
To calculate if a Point is within a nonconvex polygon, 
make a ray from that Point in a random direction and count 
the number of times it intersects the polygon. If the ray 
intersects the polygon at a vertex or along an edge, pick a 
new direction. Otherwise, the Point is within the polygon 
if and only if the ray intersects the polygon an odd number 
of times. 
*/
bool inside(const Point &P, const vector<Point> &poly) 
{
	bool res = false;
	for (int j = SZ(poly) - 1, i = 0; i < SZ(poly); j = i++) {
		Point A = poly[j];
		Point B = poly[i];
		if (B < A)
			swap(A, B);
		// on the edge
		if (((B - A) ^ (P - A)) == 0 && !(P < A) && !(B < P))
			return false;
		// intersect
		if ((P.y < A.y) ^ (P.y < B.y)) {
			int a = B.y - A.y;
			int b = A.x - B.x;
			if (a < 0) {
				a = -a;
				b = -b;
			}
			assert(a > 0);
			if (a * P.x + b * P.y < a * A.x + b * A.y)
				res = !res;
		}
	}
	return res;
}

const int MAX_N = 100;

int n;
int x[MAX_N];
int y[MAX_N];

inline void getLine(int x1, int y1, int x2, int y2, int &a, int &b, int &c) 
{
	a = y2 - y1;
	b = x1 - x2;
	c = a * x1 + b * y1;
}

inline void intersect(int a1, int b1, int c1, int a2, int b2, int c2, double &x0, double &y0) 
{
	double t = a1 * b2 - a2 * b1;
	x0 = (c1 * b2 - c2 * b1) / t;
	y0 = (c2 * a1 - c1 * a2) / t;
}

// the distance is measured in square
ll dist[MAX_N][MAX_N];

bool colinear(int x, int y, int z) 
{
	ll a[] = { dist[x][y], dist[y][z], dist[z][x] };
	sort(a, a + 3); 
	return (a[2] - a[0] - a[1]) * (a[2] - a[0] - a[1]) == 4 * a[0] * a[1]; 
} 

bool concyclic(int x, int y, int z, int w) 
{ 
	ll a[] = { dist[x][y] * dist[z][w], dist[x][z] * dist[y][w], dist[y][z] * dist[x][w] };
	sort(a, a + 3); 
	return (a[2] - a[0] - a[1]) * (a[2] - a[0] - a[1]) == 4 * a[0] * a[1];  
} 
#endif