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
	public boolean isConflict(int a, int b){
		int c;
		while((c = a % b) != 0) {
			a = b;
			b = c;
		}
		return (b == 1);//b == 1 ±Ì æª•÷ 
	}
	boolean[] isOn;
	ArrayList<Integer> onList = new ArrayList<Integer>();
	HashMap<Long, Boolean> recordConfict = new HashMap<Long, Boolean>();
	HashMap<Long, Boolean> recordNonConfict = new HashMap<Long, Boolean>();
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		int n = in.nextInt();
		isOn = new boolean[n + 1];
		Arrays.fill(isOn, false);
		int m = in.nextInt();
		for (int i = 0; i < m; ++i){
			String op = in.next();
			int number = in.nextInt();
			if (op.equals("+")){
				if (isOn[number]){
					out.println("Already on");
				} else {
					boolean valid = true;
					for (int otherOn : onList){
						int min = Math.min(otherOn, number);
						int max = Math.max(otherOn, number);
						long target = min * 100001L + max;
						if (recordConfict.containsKey(target)){
							out.println("Conflict with " + otherOn);
							valid = false;
							break;
						}else if (recordNonConfict.containsKey(target)){
							continue;
						}else{
							boolean res = isConflict(max, min);
							if (!res){
								recordConfict.put(target, true);
								out.println("Conflict with " + otherOn);
								valid = false;
								break;
							}else{
								recordNonConfict.put(target, false);
							}
						}
					}
					if (valid){
						isOn[number] = true;
						onList.add(number);
						out.println("Success");
					}
				}
			}else{
				if (isOn[number]){
					isOn[number] = false;
					onList.remove(Integer.valueOf(number));
					out.println("Success");
				}else{
					out.println("Already off");
				}
			}
		}
		return;
	}
}
