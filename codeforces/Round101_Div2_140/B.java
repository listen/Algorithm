import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @zhendeaini6001
 */
public class Main {
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
        	int edge = in.nextInt();
        	int x = in.nextInt();
        	int y = in.nextInt();
        	if (x >= edge || x <= -edge || (y % edge) == 0){
        		System.out.println(-1);
        		return;
        	}
        	if (y < edge){
        		if (x <= -((double)edge / 2) || x >= ((double)edge / 2) ){
        			out.println(-1);
        			return;
        		}else{
        			out.println(1);
        			return;
        		}
        	}
        	y -= edge;
        	int floor = y / edge;
        	double compare = edge;
        	int res = 0;
        	if (floor % 2 == 0){
        		compare = (double)edge / 2;
        	}else {
        		if (x == 0){
        			out.println(-1);
        			return;
        		}
        	}
        	if (x >= compare || x <= -compare){
        		out.println(-1);
    			return;
        	}
        	if (floor % 2 == 0){
        		res = floor / 2 * 3 + 2;
        	}else{
        		res = (floor - 1) / 2 * 3 + 3;
        		if (x > 0){
        			++res;
        		}
        	}
        	out.println(res);
        	return;
        }        
}