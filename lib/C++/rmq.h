#ifndef RMQ__
#define RMQ__

/*
sparse table method, <O(nlogn), O(1)>
*/

const int MAX_N = 200000;
const int LG_MAX_N = 17;

int n;
int a[MAX_N];
int mn[MAX_N][LG_MAX_N + 1];
int lg[MAX_N + 1];

void preprocess() 
{
	for (int i = 0, j = -1; i < n; ++i) {
		mn[i][0] = i;
		if (1 << (j + 1) == i + 1)
			++j;
		lg[i + 1] = j;
	}
	for (int j = 1; 1 << j <= n; ++j) 
		for (int i = 0; i + (1 << j) <= n; ++i) {
			int p = mn[i][j - 1];
			int q = mn[i + (1 << (j - 1))][j - 1];
			mn[i][j] = a[q] < a[p] ? q : p;
		}
}

int rmq(int l, int r) 
{
	int j = lg[r - l + 1];
	int p = mn[l][j];
	int q = mn[r - (1 << j) + 1][j];
	return a[q] < a[p] ? q : p;
}

/*
interval tree method, <O(n), O(logn)>
*/
const int MAX_N = 200000;
const int LG_MAX_N = 18; 

int n;
int a[MAX_N];
int tree[1 << (LG_MAX_N + 1)];

#define L(i) (i << 1)
#define R(i) (L(i) + 1)

void initialize(int i, int l, int r) 
{
	assert(l <= r);
	if (l == r)
		tree[i] = l;
	else {
		int m = (l + r) >> 1;
		initialize(L(i), l, m);
		initialize(R(i), m + 1, r);
		int p = tree[L(i)];
		int q = tree[R(i)];
		tree[i] = a[q] < a[p] ? q : p;
	}
}

void preprocess() 
{
	initialize(1, 0, n - 1);
}

int getMin(int i, int l, int r, int x, int y) 
{
	assert(l <= y && x <= r);
	if (x <= l && r <= y) 
		return tree[i];
	int p = -1;
	int q = -1;
	int m = (l + r) >> 1;
	if (x <= m)
		p = getMin(L(i), l, m, x, y);
	if (y > m)
		q = getMin(R(i), m + 1, r, x, y);
	if (p == -1 || (q >= 0 && a[q] < a[p]))
		return q;
	else
		return p;
}

void update(int k, int v) 
{
	assert(0 <= k && k < n);
	int i = 1;
	int l = 0;
	int r = n - 1;
	while (l < r) {
		int m = (l + r) >> 1;
		if (k <= m) {
			i = L(i);
			r = m;
		} else {
			i = R(i);
			l = m + 1;
		}
	}
	a[k] = v;
	i >>= 1;
	while (i > 0) {
		int p = tree[L(i)];
		int q = tree[R(i)];
		tree[i] = a[q] < a[p] ? q : p;
		i >>= 1;
	}
}

#endif