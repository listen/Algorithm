import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import sun.tools.jar.resources.jar;

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
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		String input= in.next();
		int res = 0;
		int forbiddenCount = in.nextInt();
		char[] forbiddenTable= new char[256]; 
		Arrays.fill(forbiddenTable, '0');
		for (int i = 0; i < forbiddenCount; ++i){
			String tString = in.next();
			forbiddenTable[tString.charAt(0)] = tString.charAt(1);
			forbiddenTable[tString.charAt(1)] = tString.charAt(0);
		}
		int [] counter = new int[26];
		for(int i = 0; i < input.length();){
			char compare = input.charAt(i);
			Arrays.fill(counter, 0);
			++counter[compare - 'a'];
			boolean forbidden = false;
			int j = i + 1;
			for(; j < input.length(); ++j){
				if (input.charAt(j) == forbiddenTable[compare]){
					forbidden = true;
					compare = input.charAt(j);
					++counter[compare - 'a'];
				}else if (input.charAt(j) == compare){
					++counter[compare - 'a'];
				}else{
					break;
				}
			}
			i = j;
			if (!forbidden){
				continue;
			}else{
				res += Math.min(counter[compare - 'a'], counter[forbiddenTable[compare] - 'a']);
			}
			
		}
		out.println(res);
		return;
	}
}

