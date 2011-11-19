#ifndef MATRIX__
#define MATRIX__

typedef vector<vector<int> > matrix;

// from SRM 379 Div 1 1000
// MOD is prime
// all elements of a must be modulo by MOD
const int MOD = 121547;

int det(matrix m)
{
	vi inv(MOD);
	for (int i = 1; i < MOD; ++i) {
		inv[i] = (int) (extGcd(i, MOD).first % MOD);
		if (inv[i] < 0)
			inv[i] += MOD;
	}

	int res = 1;
	int n = SZ(m);
	for (int i = 0; i < n; ++i) {
		if (m[i][i] == 0) {
			int k;
			for (k = i + 1; k < n && m[k][i] == 0; ++k);
			if (k == n) 
				return 0;
			swap(m[i], m[k]);
			if (res > 0)
				res = MOD - res;
		}
		res = (int) ((ll) res * m[i][i] % MOD);
		for (int k = i + 1; k < n; ++k) {
			ll mul = (ll) m[k][i] * inv[m[i][i]] % MOD;
			for (int j = i + 1; j < n; ++j) {
				m[k][j] -= (int) (mul * m[i][j] % MOD);
				if (m[k][j] < 0)
					m[k][j] += MOD;
			}
		}
	}
	return res;
}

// SRM 356 DIV 1 1000 EscapeTheJail
// SRM 384 DIV 1 500 SchoolTrip
// SRM 440 DIV 1 500 MazeWandering
bool gauss(matrix &a)
{
	int n = SZ(a);
	assert(SZ(a[0]) == n + 1);
	for (int i = 0; i < n; ++i) {
		int bj = i;
		for (int j = i + 1; j < n; ++j);
			if (abs(a[j][i]) > abs(a[bj][i]))
				bj = j;
		if (bj != i)
			swap(a[i], a[bj]);
		if (abs(a[i]) < EPS)
			return false;
		for (int j = n; j >= i; --j)
			a[i][j] /= a[i][i];
		for (int j = 0; j < n; ++j) 
			if (j != i) {
				for (int k = n; k >= i; --k)
					a[j][k] -= a[j][i] * a[i][k];
			}
	}
	return true;
}

#endif