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
    	int count = in.nextInt();
    	int max_index = 0, min_index = 0;
    	int[] input = new int[count];
    	input[0] = in.nextInt();
    	for (int i = 1; i < count; ++i){
    		input[i] = in.nextInt();
    		if (input[i] <= input[min_index]){
    			min_index = i;
    		}
    		if (input[i] > input[max_index]){
    			max_index = i;
    		}
    	}
    	if (max_index > min_index){
    		out.print(max_index + count - min_index - 2);
    	}else{
    		out.print(max_index + count - min_index - 1);
    	}
    	
    	return ;
    }        
}
