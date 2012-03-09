import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @zhendeaini6001
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
	
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		int vp = in.nextInt();
		int vd = in.nextInt();
		double t = in.nextDouble();
		int f = in.nextInt();
		int c = in.nextInt();
		if (vp >= vd){
			out.println("0");
			return;
		}
		int res = 0;
		while (true) {
			double dis = vp * t;
			double x = ((double)dis ) / (vd - vp);
			double pos_p = vp * (t + x);
			if (pos_p >= c){
				break;
			}else{
				++res;
				t = t + f + 2 * x;
			}
		}
		out.println(res);
		return;
	}    	      
}