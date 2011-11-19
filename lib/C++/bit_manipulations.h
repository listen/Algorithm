#ifndef BIT_OPERATION__
#define BIT_OPERATION__

inline int reverse(int x) 
{
	x = ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1);
	x = ((x & 0xcccccccc) >> 2) | ((x & 0x33333333) << 2);
	x = ((x & 0xf0f0f0f0) >> 4) | ((x & 0x0f0f0f0f) << 4);
	x = ((x & 0xff00ff00) >> 8) | ((x & 0x00ff00ff) << 8);
	x = ((x & 0xffff0000) >> 16) | ((x & 0x0000ffff) << 16);
	return x;
}

// return the least number larger than s that has the same number of bits set as s
inline int next(int s) 
{
	int lo = s & -s;      
	int lz = (s + lo) & ~s;    
	s |= lz;                    
	s &= ~(lz - 1);    
	s |= (lz / lo / 2) - 1; 		
	return s;
}

#endif