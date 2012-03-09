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
		int m = in.nextInt();
		String[] input = new String[n];
		HashSet<Integer> resHashSet = new HashSet<Integer>();
		for (int i = 0; i < n; ++i){
			input[i] = in.next();
		}
		for (int i = 0; i < m; ++i){
			char max = '0';
			for (int j = 0; j < n; ++j){
				max = (char)Math.max((int)input[j].charAt(i), (int)max);
			}
			for (int j = 0; j < n; ++j){
				if (input[j].charAt(i) == max){
					resHashSet.add(j);
				}
			}
		}
		out.println(resHashSet.size());
		return;
	}
}

