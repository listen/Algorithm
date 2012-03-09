import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
    public void solve(int testNumber, Scanner in, PrintWriter out) {
    	int a1 = in.nextInt();
    	int a2 = in.nextInt();
    	int a3 = in.nextInt();
    	int a4 = in.nextInt();
    	if (a3 > a1 || a3 > a2 || a4 > a1 || a4 > a2){
    		out.println("-1");
    		return;
    	}
    	if (Math.abs(a3 - a4) >= 2){
    		out.println("-1");
    		return;
    	}
    	if (a3 + a4 >= a1 + a2){
    		out.println("-1");
    		return;
    	}
    	if (a3 > a4){
    		StringBuilder res = new StringBuilder();
    		for (int i = 0; i < a3; ++i){
    			res.append("47");
    		}
    		int f_count = a1 - a3;
    		int s_count = a2 - a3;
    		if (f_count < 0 || s_count < 0){
    			out.println("-1");
    			return;
    		}
    		for (int i = 0; i < f_count; ++i){
    			out.print(4);
    		}
    		out.print(res.toString());
    		for (int i = 0; i < s_count; ++i){
    			out.print(7);
    		}
    		out.println();
    		return;
    	}else if (a3 == a4){
    		if (a1   > a3){
    			for (int i = 0; i < a1 - a3 - 1; ++i){
    				out.print("4");
    			}
    			for (int i = 0; i < a3; ++i){
    				out.print("47");
    			}
    			for (int i = 0; i < a2 - a3; ++i){
    				out.print("7");
    			}
    			out.println("4");
    			return;
    		}else{
    			for (int i = 0; i < a3; ++i){
    				out.print("74");
    			}
    			for (int i = 0; i < a2 - a3; ++i){
    				out.print("7");
    			}
    			out.println();
    			return;
    		}
    	}else if (a3 < a4){
    		StringBuilder res = new StringBuilder();
    		out.print("74");
    		for (int i = 0; i < a1 - a4; ++i){
    			out.print("4");
    		}
    		for (int i = 0; i < a4 - 2; ++i){
    			out.print("74");
    		}
    		for (int i = 0; i < a2 - a4; ++i){
    			out.print("7");
    		}
    		out.print("74");
    		return;
    	}
    }        
}