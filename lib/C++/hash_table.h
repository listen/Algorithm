#include <ext/hash_map>
#include <ext/hash_set>

using namespace std;
using namespace __gnu_cxx;

namespace __gnu_cxx {
	template <> struct hash<string> {
		size_t operator () (const string &s) const {
			return __stl_hash_string(s.c_str());
		}
	};
}

namespace __gnu_cxx {
	template <> struct hash<ll> {	
		size_t operator () (ll x) const { 
			return (size_t) (x ^ (x >> 32)); 
		}
	};
}
