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
	public double dis(double x1, double y1, double x2, double y2){
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
        public void solve(int testNumber, Scanner in, PrintWriter out) {
        	int xa, ya, xb, yb;
        	xa = in.nextInt();
        	ya = in.nextInt();
        	xb = in.nextInt();
        	yb = in.nextInt();
        	int xmin = Math.min(xa, xb);
        	int xmax = Math.max(xa, xb);
        	int ymin = Math.min(ya, yb);
        	int ymax = Math.max(ya, yb);
        	
        	int []rx = new int[1000];
        	int[] ry = new int[1000];
        	int[] r = new int[1000];
        	int n = in.nextInt();
        	for (int i = 0; i < n; ++i){
        		rx[i] = in.nextInt();
        		ry[i] = in.nextInt();
        		r[i] = in.nextInt();
        	}
        	int count = 0;
        	for (int i = xmin; i <= xmax; ++i){
        		boolean flag = false;
        		for (int j = 0; j < n; ++j){
        			double tmp = dis(i, ymin, rx[j], ry[j]);
        			if (tmp <= r[j]){
        				flag = true;
        				break;
        			}
        		}
        		if (!flag){
        			count++;
        		}
        		flag = false;
        		for (int j = 0; j < n; ++j){
        			double tmp = dis(i, ymax, rx[j], ry[j]);
        			if (tmp <= r[j]){
        				flag = true;
        				break;
        			}
        		}
        		if (!flag){
        			count++;
        		}
        	}
        	for (int i = ymin + 1; i <= ymax - 1; ++i){
        		boolean flag = false;
        		for (int j = 0; j < n; ++j){
        			double tmp = dis(xmin, i, rx[j], ry[j]);
        			if (tmp <= r[j]){
        				flag = true;
        				break;
        			}
        		}
        		if (!flag){
        			count++;
        		}
        		flag = false;
        		for (int j = 0; j < n; ++j){
        			double tmp = dis(xmax, i, rx[j], ry[j]);
        			if (tmp <= r[j]){
        				flag = true;
        				break;
        			}
        		}
        		if (!flag){
        			count++;
        		}
        	}
        	out.println(count);
        }        
}