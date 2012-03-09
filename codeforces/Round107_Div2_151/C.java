import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @listen
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
	public static long ret = -1; 
	public ArrayList<Long> prime(long input) {
		ArrayList<Long> resArrayList = new ArrayList<Long>();
		int upper_limit = (int)Math.sqrt(input);
		for (long i = 2; i <= upper_limit; ++i){
			if (input % i == 0){
				resArrayList.add(i);
				resArrayList.add((input / i));
			}
		}
		return resArrayList;
	}
	public boolean isWining(long input){
		ArrayList<Long> divisor = prime(input);
		if (divisor.size() == 0){
			return true;
		}
		for (long x : divisor)
			if(!isWining(x)){
				this.ret = x;
				return true;
			}
		return false;
	}
	
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		long first_number = in.nextLong();
		ArrayList<Long> divisor = prime(first_number);
		if (divisor.size() == 0){
			out.println("1");
			out.println("0");
			return;
		}
		if(isWining(first_number)){
			out.println("1");
			out.println(ret);
		}else{
			out.println("2");
		}
		return;
	}
}

