#ifndef STRING_ARITHMETIC__
#define STRING_ARITHMETIC__

bool lt(const string &a, const string &b)
{
	if (SZ(a) != SZ(b))
		return SZ(a) < SZ(b);
	else
		return a < b;
}

string add(string a, string b)
{
	if (SZ(a) > SZ(b)) 
		swap(a, b);
	a += string(SZ(b) - SZ(a), '0'); 
	int n = SZ(a);
	string res(n, '0');
	int carry = 0;
	for (int i = 0; i < n; ++i) {
		int cur = a[i] - '0' + b[i] - '0' + carry;
		res[i] = (char) (cur % 10 + '0');
		carry = cur / 10;
	}
	if (carry > 0)
		res += (char) (carry + '0');
	return res;
}

string mul(string a, string b)
{
	if (SZ(a) > SZ(b))
		swap(a, b);
	string res = "0";
	for (int i = 0; i < SZ(a); ++i) {
		string p(SZ(b), '0');
		int carry = 0;
		for (int j = 0; j < SZ(b); ++j) {
			int cur = (a[i] - '0') * (b[j] - '0') + carry;
			p[j] = (char) (cur % 10 + '0');
			carry = cur / 10;
		}
		if (carry > 0)
			p += (char) (carry + '0');
		res = add(res, string(i, '0') + p);
	}
	return res; 
}

#endif