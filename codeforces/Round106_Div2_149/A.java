import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
		int k = in.nextInt();
		int[] list = new int[12];
		for (int i = 0; i < 12; ++i){
			list[i] = in.nextInt();
		}
		Arrays.sort(list);
		int total = 0;
		if (k == 0){
			out.println(0);
			return;
		}
		for (int i = 11; i >= 0; --i){
			total += list[i];
			if (total >= k){
				out.println(12 - i);
				return;
			}
		}
		out.println("-1");
        return;
	}
}

