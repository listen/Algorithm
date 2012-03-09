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
		int n = in.nextInt();
		int k = in.nextInt();
		int l = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		int p = in.nextInt();
		int nl = in.nextInt();
		int np = in.nextInt();
		int min = 10000000;
		min = Math.min(min, k * l / (nl * n));
		min = Math.min(min, c * d / n);
		min = Math.min(min, p / (np * n));
        out.println(min);
		return;
	}
}

