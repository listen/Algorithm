#ifndef SIMPLEX__
#define SIMPLEX__

/*
max c * x, 
s.t. 
A * x <= b, 
x >= 0
*/
enum {INFEASIBLE, UNBOUNDED, OPTIMAL};

const double EPS = 1e-12;
const int MAX_N = 50;
const int MAX_M = 51;

int m;
int n;
int k;
double a[MAX_M][MAX_N + MAX_M + 1];
double b[MAX_M];
double c[MAX_N + MAX_M + 1];

bool nonbasic[MAX_N + MAX_M + 1];
int basic[MAX_M];
double res[MAX_N + MAX_M + 1];
double v;

void pivot(int l, int e)
{
	double t = a[l][e];
	for (int j = 0; j < k; ++j) 
		if (nonbasic[j])
			a[l][j] /= t;
	a[l][basic[l]] = 1 / t;
	b[l] /= t;

	for (int i = 0; i < m; ++i)
		if (i != l) {
			t = a[i][e];
			for (int j = 0; j < k; ++j)
				if (nonbasic[j])
					a[i][j] -= t * a[l][j];
			a[i][basic[l]] = -t * a[l][basic[l]];
			b[i] -= t * b[l];
		}
	t = c[e];
	for (int j = 0; j < k; ++j)
		if (nonbasic[j])
			c[j] -= t * a[l][j];
	c[basic[l]] = -t * a[l][basic[l]];
	v += t * b[l];

	nonbasic[e] = false;
	nonbasic[basic[l]] = true;
	basic[l] = e;
}

int doit()
{
	while (true) {
		int e;
		for (e = 0; e < k; ++e)
			if (nonbasic[e] && c[e] > EPS)
				break;
		if (e >= k) // optimal
			break;
		int l = -1;
		for (int i = 0; i < m; ++i)
			if (a[i][e] > EPS && (l == -1 || b[i] / a[i][e] < b[l] / a[l][e]))
				l = i;
		if (l == -1) // unbounded
			return UNBOUNDED;
		pivot(l, e);
	}
	return OPTIMAL;
}

int simplex()
{
	k = n + m;
	for (int i = 0; i < n; ++i)
		nonbasic[i] = true;
	int l = 0;
	for (int i = 0; i < m; ++i) {
		a[i][n + i] = 1;
		basic[i] = n + i;
		nonbasic[n + i] = false;
		if (b[i] < b[l])
			l = i;
	}
	v = 0;
	if (b[l] < -EPS) {
		for (int i = 0; i < m; ++i)
			a[i][k] = -1;
		double s[MAX_N + MAX_M + 1];
		memcpy(s, c, sizeof(c));
		memset(c, 0, sizeof(c));
		c[k] = -1;
		nonbasic[k] = true;
		pivot(l, k++);
		doit();
		if (v < -EPS) // infeasible
			return INFEASIBLE;
		if (!nonbasic[--k]) {
			int l;
			for (l = 0; l < m; ++l)
				if (basic[l] == k)
					break;
			int e;
			for (e = 0; e < k; ++e)
				if (nonbasic[e] && (a[l][e] < -EPS || a[l][e] > EPS)) 
					break;
			if (e < k) 
				pivot(l, e);
			else {
				if (l != --m) {
					memcpy(a[l], a[m], sizeof(a[m]));
					b[l] = b[m];
					basic[l] = basic[m];
				}
			}
		}
		memcpy(c, s, sizeof(c));
		for (int i = 0; i < m; ++i) { 
			double t = c[basic[i]];
			for (int j = 0; j < k; ++j)
				if (nonbasic[j])
					c[j] -= t * a[i][j];
			v += t * b[i];
		}
	}
	int ans = doit();
	if (ans == OPTIMAL) {
		memset(res, 0, sizeof(res));
		for (int i = 0; i < m; ++i)
			res[basic[i]] = b[i];
	}
	return ans;
}

#endif