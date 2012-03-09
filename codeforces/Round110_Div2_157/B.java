import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @listen
 */
public class B {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}
class TaskB {
	public void solve(long testNumber, Scanner in, PrintWriter out) {
		int n = in.nextInt();
		int[] input;
		if (n % 2 != 0){
			++n;
			input = new int[n];
			input[0] = 0;
			for (int i = 1; i < n; ++i){
				input[i] = in.nextInt();
			}
		}else{
			input = new int[n];
			for (int i = 0; i < n; ++i){
				input[i] = in.nextInt();
			}
		}
		Arrays.sort(input);
		long res = 0;
		for (int i = 1; i < n; i += 2){
			res += (input[i] * input[i] - input[i - 1] * input[i - 1]);
		}
		double ret = res * 3.141592653589793;
		out.println(ret);
		return;
	}
}

