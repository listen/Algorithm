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
	boolean fu = false;
	public void outputIntger(String a){
		System.out.println("12" );
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
		/*StringBuilder outputBuilder = new StringBuilder();
		for (int i = sbBuilder.length() - 1; i >= 0; --i){
			outputBuilder.append(sbBuilder.charAt(i));
		}
		System.out.print(outputBuilder.toString());*/
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
    	if (sp.length == 0){
    		out.print(input);
    		out.print(".00");
    	}else{
    		outputIntger(sp[0]);
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

/*class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
        	int r1 = in.nextInt();
        	int r2 = in.nextInt();
        	int c1 = in.nextInt();
        	int c2 = in.nextInt();
        	int d1 = in.nextInt();
        	int d2 = in.nextInt();
        	
        	for (int a1 = 1; a1 <= 9; ++a1){
        		for (int a2 = 1; a2 <= 9; ++a2){
        			for (int b1 = 1; b1 <= 9; ++b1){
        				for (int b2 = 1; b2 <= 9; ++b2){
        					if (a1 + a2 == r1 && b1 + b2 == r2 && a1 + b1 == c1 && a2 + b2 == c2 &&
        							a1 + b2 == d1 && a2 + b1 == d2){
        						if (a1 != a2 && a1 != b1 && a1 != b2 && a2 != b1 && a2 != b2 && b1 != b2){
        							out.println(a1 + " " + a2);
        							out.println(b1 + " " + b2);
        							return;
        						}
        					}
        				}
        			}
        		}
        	}
        	out.println("-1");
        	return;
        	
        } 
        
}*/