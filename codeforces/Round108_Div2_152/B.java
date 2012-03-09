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
		long n = in.nextLong();
		long m = in.nextLong();
		long cur_x = in.nextLong();
		long cur_y = in.nextLong();
		int k = in.nextInt();
		long[] dx = new long[k];
		long[] dy = new long[k];
		for (int i = 0; i < k; ++i){
			dx[i] = in.nextLong();
			dy[i] = in.nextLong();
		}
		long res = 0;
		for (int i = 0; i < k; ++i){
			long end_x = 1, end_y = 1;
			if (dx[i] > 0){
				end_x = n;
			}
			if (dy[i] > 0){
				end_y = m;
			}
			long movex = end_x - cur_x;
			long movey = end_y - cur_y;
			if (dx[i] == 0){
				long steps = Math.abs(movey) / Math.abs(dy[i]);
				res += steps;
				cur_y = cur_y + dy[i] * steps;
			}else if (dy[i] == 0){
				long steps = Math.abs(movex) /  Math.abs(dx[i]);
				res += steps;
				cur_x = cur_x + dx[i] * steps;
			}else{
				long steps = Math.abs(movex) /  Math.abs(dx[i]);
				steps = Math.min(Math.abs(movey) /  Math.abs(dy[i]), steps);
				cur_x = cur_x + dx[i] * steps;
				cur_y = cur_y + dy[i] * steps;
				res += steps;
			}
		}
		out.print(res);
		return;
	}
}

