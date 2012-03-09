import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @zhendeaini6001
 */
public class C {
        public static void main(String[] args) {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                Scanner in = new Scanner(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                TaskC solver = new TaskC();
                solver.solve(1, in, out);
                out.close();
        }
}

class TaskC {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
        	String a = in.next();
        	String b = in.next();
        	int a_4_count = 0, b_4_count = 0;
        	for (int i = 0; i < a.length(); ++i){
        		if (a.charAt(i) == '4'){
        			++a_4_count;
        		}
        		if (b.charAt(i) == '4'){
        			++b_4_count;
        		}
        	}
        	int res = Math.abs(a_4_count - b_4_count);
        	int tmp = res;
        	StringBuilder achange = new StringBuilder();
        	if (a_4_count > b_4_count){
        		for (int i = 0; i < a.length(); ++i){
        			if (a.charAt(i) == '4' && b.charAt(i) == '7' && tmp != 0){
        				achange.append('7');
        				--tmp;
        				continue;
        			}else{
        				achange.append(a.charAt(i));
        			}
        		}
        	}else if (a_4_count < b_4_count){
        		for (int i = 0; i < a.length(); ++i){
        			if (a.charAt(i) == '7' && b.charAt(i) == '4' && tmp != 0){
        				achange.append('4');
        				--tmp;
        				continue;
        			}else{
        				achange.append(a.charAt(i));
        			}
        		}
        	}
        	String aString = achange.toString();
        	if (a_4_count == b_4_count){
        		aString = a;
        	}
        	int swap_count = 0;
        	for (int i = 0; i < aString.length(); ++i){
        		if (aString.charAt(i) != b.charAt(i)){        	
        			++swap_count;
        		}
        	}
        	res += (swap_count / 2);
        	out.println(res);
        	return;
        	
        }   
}