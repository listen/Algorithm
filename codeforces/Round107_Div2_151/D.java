import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @listen
 */
public class D {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
	public static int MOD = 1000000007;
	public long calC(int m, int n){
		if (n == 0){
			return 1;
		}
		long res = 1;
		for (int i = 0; i < n; ++i){
			res = res * (m - i) / (i + 1);
			res = res % MOD;
		}
		return res;
	}
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		if (k > n){
			out.println();
			return;
		}
		if (k % 2 == 0){
			out.println(m);
		}else{
			long res = calC(m, 2) * 2;
			res += m;
			res %= MOD;
			out.println(res);
		}
		return;
	}
}

