import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
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
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		int n = in.nextInt();
		int[] input = new int[n];
		int total = 0;
		for (int i = 0; i < n; ++i){
			input[i] = in.nextInt();
			total += input[i];
		}
		int[][] dp = new int[n][n / 2];
		dp[0][0] = 0;
		for (int i = 0; i < n; ++i){
			
		}
	}
}

