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
	public String reverse(String input){
		StringBuilder sb = new StringBuilder();
		for (int i = input.length() - 1; i >= 0; --i) {
			sb.append(input.charAt(i));
		}
		return sb.toString();
	}
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		String input_t = in.next();
		String pattern = in.next();
		int not_same = Integer.MAX_VALUE;
		String fake = new String();
		for (int i = 1; i < pattern.length(); ++i){
			fake += 'A';
		}
		String input = fake + input_t + fake;
		//if (input.length() >= pattern.length()){
			for (int i = 0; i <= input.length() - pattern.length(); ++i){
				int not_same_t = 0;
				for (int j = 0; j < pattern.length(); ++j){
					if (input.charAt(i + j) != pattern.charAt(j)){
						not_same_t++;
					}
				}
				not_same = Math.min(not_same, not_same_t);
			}
			/*for (int i = input.length() - pattern.length() + 1; i < input.length(); ++i){
				int length = input.length() - i;
				int not_same_t = pattern.length() - length;
				for (int j = 0; j < length; ++j){
					if (input.charAt(i + j) != pattern.charAt(j)){
						++not_same_t;
					}
				}
				not_same = Math.min(not_same, not_same_t);
			}*/
			/*for (int i = 0; i < pattern.length(); ++i){
				int not_same_t = 0;
				for (int j = 0; j <=i;++j){
					if (pattern.charAt(pattern.length() - 1 - j) != input.charAt(i - j)){
						++not_same_t;
					}
				}
				not_same_t += 
			}*/
			out.println(not_same);
		//}
	/*else{
			int res = pattern.length() -  input.length();
			int not_same_t = 0;
			for (int i = 0; i < input.length(); ++i){
				if (input.charAt(i) != pattern.charAt(i)){
					++not_same_t;
				}
			}
			res += not_same_t;
			not_same = Math.min(not_same, res);
		}*/
		
		/*input = reverse(input);
		pattern = reverse(pattern);
		
		if (input.length() >= pattern.length()){
			for (int i = 0; i <= input.length() - pattern.length(); ++i){
				int not_same_t = 0;
				for (int j = 0; j < pattern.length(); ++j){
					if (input.charAt(i + j) != pattern.charAt(j)){
						not_same_t++;
					}
				}
				not_same = Math.min(not_same, not_same_t);
			}
			for (int i = input.length() - pattern.length() + 1; i < input.length(); ++i){
				int length = input.length() - i;
				int not_same_t = pattern.length() - length;
				for (int j = 0; j < length; ++j){
					if (input.charAt(i + j) != pattern.charAt(j)){
						++not_same_t;
					}
				}
				not_same = Math.min(not_same, not_same_t);
			}
			//out.println(not_same);
		}else{
			int res = pattern.length() -  input.length();
			int not_same_t = 0;
			for (int i = 0; i < input.length(); ++i){
				if (input.charAt(i) != pattern.charAt(i)){
					++not_same_t;
				}
			}
			res += not_same;
			not_same = Math.min(not_same, res);
		}*/
		//out.println(not_same);
		return;
	}
}

