import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @listen
 */
public class C {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {	
	public static int MOD = 1000000007;
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		int n = in.nextInt();
		int m = in.nextInt();
		String[] input = new String[n];
		for (int i = 0; i < n; ++i){
			input[i] = in.next();
		}
		long res = 1;
		for (int i = 0; i < m; ++i){
			HashSet<Character> hSet = new HashSet<Character>();
			for (int j = 0; j < n; ++j){
				hSet.add(input[j].charAt(i));
			}
			res = res * hSet.size();
			res = res % MOD;
		}
		out.println(res);
		return;
	}
}

