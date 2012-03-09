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
public class E {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskE solver = new TaskE();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskE {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		int n = in.nextInt();
		for (int i = 0; i < n; ++i){
			int cx = in.nextInt();
			int cy = in.nextInt();
			int r = in.nextInt();
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			int flag1 = 0, flag2 = 0;
			double dis1 = Math.sqrt( ((double)x1 - cx) * (x1 - cx) + ((double)y1 - cy) * (y1 - cy));
			if (dis1 < r){
				flag1 = 1;
			}else if (dis1 == r){
				flag1 = 0;
			}else{
				flag1 = -1;
			}
			double dis2 = Math.sqrt( ((double)x2 - cx) * (x2 - cx) + ((double)y2 - cy) * (y2 - cy));
			if (dis2 < r){
				flag2 = 1;
			}else if (dis2 == r){
				flag2 = 0;
			}else{
				flag2 = -1;
			}
			if (flag1 <= 0 && (flag2 <= 0) ){
				out.println("ALL IN");
			}else if (flag1 * flag2 < 0){
				out.println("PART IN");
			}else{
				out.println("ALL OUT");
			}
		}
		return;
	}
}

