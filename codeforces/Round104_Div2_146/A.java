import java.awt.Frame;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
    	int length = in.nextInt();
    	String inputString = in.next();
    	int sum1 = 0, sum2 = 0;
    	for (int i = 0; i < length / 2; ++i){
    		if (inputString.charAt(i) != '4' && inputString.charAt(i) != '7'){
    			out.println("NO");
    			return;
    		}else{
    			sum1 += Integer.valueOf(inputString.charAt(i));
    		}
    	}
    	for (int i = length /2 ; i < length; ++i){
    		if (inputString.charAt(i) != '4' && inputString.charAt(i) != '7'){
    			out.println("NO");
    			return;
    		}else{
    			sum2 += Integer.valueOf(inputString.charAt(i));
    		}
    	}
    	if (sum1 == sum2){
    		out.println("YES");
    	}else{
    		out.println("NO");
    	}
    	return ;
    }        
}
