package lib;

public class Combination {
	//≈≈¡–
	public long calA(int m, int n){
		if (n == 0){
			return 1;
		}
		long res = 1;
		for (int i = 0; i < n; ++i){
			res = res * (m - i);
			res = res % 1000000009;
		}
		return res;
	}
	//◊È∫œ
	public long calC(int m, int n){
		if (n == 0){
			return 1;
		}
		long res = 1;
		for (int i = 0; i < n; ++i){
			res = res * (m - i) / (i + 1);
			res = res % 1000000009;
		}
		return res;
	}
}
