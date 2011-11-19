#ifndef RANK_PERMUTATION__
#define RANK_PERMUTATION__

/*
 "Ranking and Unranking Permutations in Linear Time"
 Wendy Myrvold & Frank Ruskey
 Apr 13, 2000.
 Note: NOT in lexicographical order.
*/

const int MAX_N = 8;

int doRank(int p[], int q[], int n) 
{
	if (n <= 1)
		return 0;
	else {
		int t = p[n - 1];
		swap(p[n - 1], p[q[n - 1]]);
		swap(q[t], q[n - 1]);
		return t + n * doRank(p, q, n - 1);
	}
}

int rank(const int p[], int n) 
{
	int t[MAX_N];
	int q[MAX_N];
	for (int i = 0; i < n; ++i) {
		t[i] = p[i];
		q[p[i]] = i;
	}
	return doRank(t, q, n);
}

void doUnrank(int r, int p[], int n) 
{
	if (n > 1) {
		swap(p[n - 1], p[r % n]);
		doUnrank(r / n, p, n - 1);
	}
}

void unrank(int r, int p[], int n) 
{
	for (int i = 0; i < n; ++i)
		p[i] = i;
	doUnrank(r, p, n);
}

#endif