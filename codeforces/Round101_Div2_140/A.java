import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
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
                TaskA solver = new TaskA();
                solver.solve(1, in, out);
                out.close();
        }
}

class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
        	String guest = in.next();
        	String host = in.next();
        	String shuffle = in.next();
        	int[] origin = new int[126];
        	int[] res = new int[126];
        	Arrays.fill(origin, 0);
        	Arrays.fill(res, 0);
        	for (int i = 0; i < guest.length(); ++i){
        		origin[(int)guest.charAt(i)]++;
        	}
        	for (int i = 0; i < host.length(); ++i){
        		origin[(int)host.charAt(i)]++;
        	}
        	for (int i = 0; i < shuffle.length(); ++i){
        		res[shuffle.charAt(i)]++;
        	}
        	for (int i = 'A'; i <= 'Z'; ++i){
        		if (origin[i] != res[i]){
        			System.out.println("NO");
        			return;
        		}
        	}
        	System.out.println("YES");
        	return;
        } 
        
}