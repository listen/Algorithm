import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
        	while (in.hasNext()){
        		BigDecimal r = in.nextBigDecimal();
        		int n = in.nextInt();
        		BigDecimal pi = new BigDecimal(3.1415926535897);
        		BigDecimal res = pi.multiply(BigDecimal.valueOf(2));
        		BigDecimal res1 = res.multiply(r);
        		BigDecimal res2 = res1.multiply(BigDecimal.valueOf(n)); 
        		out.printf("%.2f", res2.setScale(2,java.math.BigDecimal.ROUND_HALF_UP).doubleValue());
        		out.println();
        		out.flush();
        	}
        }        
}