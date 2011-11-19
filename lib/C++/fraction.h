#ifndef FRACTION__
#define FRACTION__

ll gcd(ll a, ll b) 
{
	return b == 0 ? a : gcd(b, a % b);
}

struct Fraction {
	ll a;
	ll b;

	Fraction(ll _a = 0, ll  _b = 1) { 
		ll d = gcd(_a, _b);
		a = _a / d;
		b = _b / d;
	}

	Fraction operator - () const { return Fraction(-a, b); }

	Fraction inverse() const {
		if (a == 0) {
			cerr << "Zero divisor" << endl;
			exit(1);
		}
		return a < 0 ? Fraction(-b, -a) : Fraction(b, a);
	}

	Fraction& operator += (const Fraction &f);
	Fraction& operator -= (const Fraction &f);
	Fraction& operator *= (const Fraction &f);
	Fraction& operator /= (const Fraction &f);

	double doubleValue() const { return 1.0 * a / b; }

	string toStr() const { 
		ostringstream oss;
		oss << a << "/" << b;
		return oss.str();
	}
};

inline bool operator  < (const Fraction &f1, const Fraction &f2) { return f1.a * f2.b < f2.a * f1.b; }
inline bool operator  > (const Fraction &f1, const Fraction &f2) { return f2 < f1; }
inline bool operator <= (const Fraction &f1, const Fraction &f2) { return !(f2 < f1); }
inline bool operator >= (const Fraction &f1, const Fraction &f2) { return !(f1 < f2); }
inline bool operator == (const Fraction &f1, const Fraction &f2) { return !(f1 < f2) && !(f2 < f1);}

inline Fraction operator + (const Fraction &f1, const Fraction &f2) { return Fraction(f1.a * f2.b + f2.a * f1.b, f1.b * f2.b); }
inline Fraction operator - (const Fraction &f1, const Fraction &f2) { return f1 + (-f2); }
inline Fraction operator * (const Fraction &f1, const Fraction &f2) { return Fraction(f1.a * f2.a, f1.b * f2.b); }
inline Fraction operator / (const Fraction &f1, const Fraction &f2) { return f1 * f2.inverse(); }

inline Fraction &Fraction::operator += (const Fraction &f) { return *this = *this + f; }
inline Fraction &Fraction::operator -= (const Fraction &f) { return *this = *this - f; }
inline Fraction &Fraction::operator *= (const Fraction &f) { return *this = *this * f; }
inline Fraction &Fraction::operator /= (const Fraction &f) { return *this = *this / f; }

inline void swap(Fraction &f1, Fraction &f2) 
{
	swap(f1.a, f2.a);
	swap(f1.b, f2.b);
}

#endif