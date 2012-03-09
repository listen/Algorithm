import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.NEW;

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
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		int n = in.nextInt();
		int truth_count = in.nextInt();
		String[] inputStrings = new String[n + 1];
		int[] input = new int[n + 1];
		int[] yes_count = new int[n + 1];int[] no_count = new int[n + 1];
		Arrays.fill(yes_count, 0); Arrays.fill(no_count, 0);
		int total_yes_count = 0, total_no_count = 0;
		for (int i = 1 ; i <= n; ++i){
			inputStrings[i] = in.next();
			input[i] = Integer.valueOf(inputStrings[i].substring(1));
			if (inputStrings[i].charAt(0) == '-'){
				input[i] = input[i] * (-1);
			}
			if (input[i] > 0){
				yes_count[input[i]]++;
				++total_yes_count;
			}else{
				no_count[-input[i]]++;
				++total_no_count;
			}
		}
		if (total_no_count + total_yes_count != n){
			throw new RuntimeException();
		}
		ArrayList<Integer> candidate = new ArrayList<Integer>();
		for (int i = 1; i <= n; ++i){
			if ( (yes_count[i] + (total_no_count - no_count[i]) ) == truth_count){
				candidate.add(i);
			}
		}
		if (candidate.size() <= 0){
			throw new RuntimeException();
		}
		ArrayList<Integer> wrong_list = new ArrayList<Integer>();
		ArrayList<Integer> right_list = new ArrayList<Integer>();
		//ArrayList<Integer> not_defined_list = new ArrayList<Integer>();
		int first = candidate.get(0);
		for (int i = 1; i <= n; ++i){
			if (input[i] > 0){
				if (input[i] == first){
					right_list.add(i);
				}else{
					wrong_list.add(i);
				}
			}else{
				if (-input[i] == first){
					wrong_list.add(i);
				}else{
					right_list.add(i);
				}
			}
		}
		if (right_list.size() + wrong_list.size() != n){
			throw new RuntimeException();
		}
		for (int i = 1; i < candidate.size(); ++i){
			int index = candidate.get(i);
			for (int j = 0; j < right_list.size(); ++j){
				int a = right_list.get(j);
				if (input[a] > 0 ){
					if (input[a] == index){
						continue;
					}else{
						right_list.remove(j);
						--j;
						//right_list.remove(Integer.valueOf(a));
						//not_defined_list.add(a);
					}
				}else{
					if (-input[a] == index){
						right_list.remove(j);
						--j;
						//right_list.remove(Integer.valueOf(a));
						//not_defined_list.add(a);
					}else{
						continue;
					}
				}
			}
			for (int j = 0; j < wrong_list.size(); ++j){
				int a = wrong_list.get(j);
				if (input[a] > 0 ){
					if (input[a] == index){
						wrong_list.remove(j);
						--j;
						//wrong_list.remove(Integer.valueOf(a));
						//not_defined_list.add(a);
					}else{
						continue;
					}
				}else{
					if (-input[a] == index){
						continue;
					}else{
						wrong_list.remove(j);
						--j;
						//wrong_list.remove(Integer.valueOf(a));
						//not_defined_list.add(a);
					}
				}
			}
		}
		int[] output = new int[n + 1];
		Arrays.fill(output, 0);
		for (Integer integer : wrong_list){
			output[integer] = -1;
		}
		for (Integer integer : right_list){
			output[integer] = 1;
		}
		for (int i = 1; i <= n; ++i){
			if (output[i] == 0){
				out.println("Not defined");
			}else if (output[i] == -1){
				out.println("Lie");
			}else{
				out.println("Truth");
			}
		}
		return;
	}
}
