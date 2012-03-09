import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @zhendeaini6001
 */
public class D {
        public static void main(String[] args) {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                Scanner in = new Scanner(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                TaskD solver = new TaskD();
                solver.solve(1, in, out);
                out.close();
        }
}

class TaskD {
	public double iter(int w, int b){
		if (w <= 0){
			return 0;
		}
		if (b == 0){
			return 1;
		}
		if (b < 0){
			return 0;
		}
		double res = ((double)(w)) / (w + b);
		double res1 = iter(w, b - 2);
		if (res1 != 0){
			res1 = res1 * ((double)((b - 1) * (b - 2))) / ((w + b - 1) * (w + b - 2));
		}
		double res2 = iter(w - 1, b - 1);
		if (res2 != 0){
			res2 =  res2 * ((double)((b - 1) * w)) / ((w + b - 1) * (w + b - 2)) ;
		}
		res += (res1 + res2) * b / (w + b);
		res += res2;
		return res;
	}
    public void solve(int testNumber, Scanner in, PrintWriter out) {
    	double res = 0.0;
    	int w = in.nextInt();
    	int b = in.nextInt();
    	res += iter(w, b);
    	out.printf("%.9f", res);
    }        
}