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
	public int cal_lucky (int i){
		String iString = String.valueOf(i);
		int res = 0;
		for (int j = 0; j < iString.length(); ++j){
			if (iString.charAt(j) == '4' || iString.charAt(j) == '7'){
				res = res * 10;
				res += (iString.charAt(j) - '0');
			}
		}
		return res;
	}
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		int a = in.nextInt();
		int lucky = in.nextInt();
		for (int i = a + 1; i <= 999999; ++i){
			int tmp = cal_lucky(i);
			if (tmp == lucky){
				out.println(i);
				return;
			}
		}
	}    	      
}