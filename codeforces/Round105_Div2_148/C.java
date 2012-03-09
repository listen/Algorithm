import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        	int n = in.nextInt();
        	int a = in.nextInt();
        	int b = in.nextInt();
        	if (n == 2){
        		if (a == 0 && b == 0){
        			out.println("1 1");
        		}else if ( a == 1){
        			out.println("-1");
        		}else if (b == 1){
        			out.println("1 2");
        		}
        		return;
        	}
        	if (a == n - 1){
        		if ( n == 1){
        			out.println("1");
        		}else{
        			out.println("-1");
        		}
        		return;
        	}
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	int total = 0;
        	int big = 0;
        	if (b > 0){
        		list.add(1);
        		list.add(2);
        		big = 2;
        		total += 3;
        		--b;--n;
        	}else {
        		list.add(3);
        		list.add(3);
        		big = 3;
        		total += 6;
        		--n;
        	}
        	for (int i = 0; i < b; ++i){
        		list.add(total + 1);
        		big = total + 1;
        		if (big > 50000){
        			out.println("-1");
        			return;
        		}
        		total = total * 2;
        		++total;
        	}
        	for (int i = 0; i < a; ++i){
        		++big;
        		if (big > 50000){
        			out.println("-1");
        			return;
        		}
        		list.add(big);
        		total += (big);
        	}
        	
        	for (int i = 0; i < n - a - b - 1; ++i){
        		list.add(1);
        	}
        	out.print(list.get(0));
        	for (int i = 1; i < list.size(); ++i){
        		out.print(" " + list.get(i));
        	}
        	out.println();
        	return;
        }   
}