import java.awt.Frame;
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
    	int l = in.nextInt();
    	int m = in.nextInt();
    	int n = in.nextInt();
    	int d = in.nextInt();
    	boolean[] flag = new boolean[d + 1];
    	Arrays.fill(flag, false);
    	for (int i = 1; i <= d; ++i){
    		if (i % k == 0 || i % l == 0 || i % m == 0 || i % n == 0){
    			flag[i] = true;
    		}
    	}
    	int res = 0;
    	for (int i = 1; i <= d; ++i){
    		if (flag[i]){
    			++res;
    		}
    	}
    	out.println(res);
    	return ;
    }        
}
