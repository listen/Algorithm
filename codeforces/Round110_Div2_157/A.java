import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @listen
 */
public class A {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		int n = in.nextInt();
		int[][] input = new int[n][n];
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < n; ++j){
				input[i][j] = in.nextInt();
			}
		}
		int[] rowsum = new int[n];int [] colsum = new int[n];
		Arrays.fill(rowsum, 0);
		Arrays.fill(colsum, 0);
		int res = 0;
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < n; ++j){
				rowsum[i] += input[i][j];
				colsum[j] += input[i][j];
			}
		}
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < n; ++j){
				if (rowsum[i] < colsum[j]){
					++res;
				}
			}
		}
		out.println(res);
		return;
	}
}

