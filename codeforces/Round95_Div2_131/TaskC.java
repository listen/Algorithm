package mypackage;

import java.io.PrintWriter;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    //组合
	public long calC(int m, int n){
		if (n == 0){
			return 1;
		}
		long res = 1;
		for (int i = 0; i < n; ++i){
			res = res * ((long)(m - i) ) / (i + 1);
		}
		return res;
	}
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int t = in.nextInt();
        long res = 0;
        for (int i = 4; i <= Math.min(t - 1, n); ++i){
            res += calC(n, i) * calC(m, t - i);
        }
        out.println(res);
        return;
	}
}
