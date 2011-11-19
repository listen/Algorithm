#ifndef FFT__
#define FFT__

/*
SRM 436 DIV 1 1000 CircularShifts
*/

typedef vector<complex<double> > vc;

vc fft(const vc &x, complex<double> w)
{
	int n = SZ(x);
	vc res(n);
	if (n <= 8) {
		complex<double> u(1.0, 0.0);
		for (int i = 0; i < n; ++i) {
			complex<double> v(1.0, 0.0);
			for (int j = 0; j < n; ++j) {
				res[i] += x[j] * v;
				v *= u;
			}
			u *= w;
		}
		return res;
	}
	vc xe(n / 2);
	vc xo(n / 2);
	for (int i = 0; i < n; i += 2) {
		xe[i / 2] = x[i];
		xo[i / 2] = x[i + 1];
	}
	vc ae = fft(xe, w * w);
	vc ao = fft(xo, w * w);
	complex<double> u = complex<double>(1.0, 0.0);
	for (int i = 0; i < n / 2; ++i) {
		res[i] = ae[i] + u * ao[i];
		res[i + n / 2] = ae[i] - u * ao[i];
		u *= w;
	}
	return res;
}

#endif