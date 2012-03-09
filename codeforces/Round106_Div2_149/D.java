import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @listen
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
	public static int MOD = 1000000007;
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		String inputString = in.next();
		int[] ran = new int[inputString.length()];
		int[] buran = new int[inputString.length()];
		ran[0] = 2;buran[0]=2;
		for (int i = 1; i < inputString.length(); ++i){
			if (inputString.charAt(i) == '('){
				ran[i] = (buran[i-1]*2 % MOD +ran[i-1]%MOD)%MOD;
				buran[i] = (2*((ran[i-1] + buran[i-1]) % MOD))%MOD;
			}else{
				
			}
		}
	}
}

