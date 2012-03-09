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
		int[] input = new int[n];
		for (int i = 0; i < n; ++i){
			input[i] = in.nextInt();
		}
		int max = input[0], min = input[0];
		int res = 0;
		for (int i = 1; i < n; ++i){
			if (input[i] > max){
				++res;
				max = input[i];
			}
			if (input[i] < min){
				++res;
				min = input[i];
			}
		}
		out.println(res);
		return;
	}
}

