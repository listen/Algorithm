#ifndef NUMBER_THEORY__
#define NUMBER_THEORY__

// primes less than 100
const int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

// 735134400 has 1344 factors 

pair<ll, ll> extGcd(ll a, ll b) 
{
	if (b == 0)
		return make_pair(1ll, 0ll);
	else {
		pair<ll, ll> t = extGcd(b, a % b);
		return make_pair(t.second, t.first - (a / b) * t.second);
	}
}

/*
the inverse of x to p, where p is a prime
*/
ll inverse(ll x, ll p) 
{
	return (extGcd(x, p).first + p) % p;
}

const int MOD = 1000000007;

/*
exponentiation
*/
ll pow(int a, ll k) 
{
	ll res = 1;
	while (k > 0) {
		if (k & 1) res *= a;
		a *= a;
		k >>= 1;
	}
	return res;
}

/*
the sum of the geometry series
*/
ll geom(int a, ll n) 
{
	if (n == 0)
		return 0;
	else if (n % 2) 
		return (1 + a * geom(a, n - 1)) % MOD;
	else
		return geom(a, n / 2) * (1 + pow(a, n / 2)) % MOD;
}

/*
sieve method
*/
void erasto(int n) 
{
	vi f(n);
	for (int i = 2; i <= n; ++i)
		if (f[i] == 0)
			for (int j = i; j <= n; j += i)
				f[j] = i;
} 

/*
sieve method to factorize 2 to n
*/
void factorize(int n) 
{
	vector<vector<pair<int, int> > > pf(n);
	for (int i = 2; i <= n; ++i)
		if (pf[i].empty()) {
			for (int j = i; j <= n; j += i) {
				int c = 0;
				for (int z = j; z % i == 0; z /= i)
					++c;
				pf[j].push_back(make_pair(i, c));
			}
		}
}

/*
factorize p out of n!
the result is bounded by n - 1
*/
int fp(int n, int p) 
{
	int res = 0;
	while (n > 0) {
		n /= p;
		res += n;
	}
	return res;
}

/*
factorize p out of c(n, m)
the result is bounded by lg n
*/
int fp(int n, int m, int p) 
{
	int res = 0;
	for (ll z = 1; z <= n; z *= p)
		if (z % m > z % n)
			++res;
	return res;
}

#endif