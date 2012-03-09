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
		boolean fu = false;
		public void outputIntger(String a){
			if (a.charAt(a.length() - 1) == '-'){
				fu = true;
				System.out.print("($");
			}else{
				System.out.print("$");
			}
			StringBuilder sbBuilder = new StringBuilder();
			for (int i = 0; i < a.length(); ++i){
				if (a.charAt(i) != '-'){
					sbBuilder.append(a.charAt(i));
					if (a.charAt(i) != '-' && i % 3 == 2 && i != a.length() - 1){
						sbBuilder.append(',');
					}
				}
			}
			
			System.out.print(sbBuilder.toString());
			return;
		}
        public void solve(int testNumber, Scanner in, PrintWriter out) {
        	String inputString = in.next();
        	StringBuilder inputBuilder = new StringBuilder();
        	for (int i = inputString.length() - 1; i >= 0; --i){
        		inputBuilder.append(inputString.charAt(i));
        	}
        	String input = inputBuilder.toString();
        	String[] sp = input.split(".");
        	System.out.println(sp.length);
        	outputIntger(sp[0]);
        	if (sp.length == 1){
        		out.print(".00");
        		
        	}else{
        		if (sp[1].length() == 1){
        			out.print(sp[1].charAt(0));
        			out.print("0");
        		}else {
        			for (int i = 0; i < 2; ++i){
        				out.print(sp[1].charAt(i));
        			}
        		}
        	}
        	if (fu){
    			out.print(")");
    		}
    		out.println();
        	return;
        }        
}