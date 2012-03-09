import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @listen
 */
public class B {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public int cal_min(String input) {
		int min = 0;
		for (int i = 0; i < input.length(); ++i){
			if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'){
				int t = input.charAt(i) - 'A' + 10;
				min = Math.max(t, min);
			}else{
				min = Math.max(input.charAt(i) - '0', min);
			}
		}
		return min + 1;
	}
	public int cal_val(String input, int x) {
		int res = 0;
		for (int i = 0; i < input.length(); ++i){
			int t = 0;
			if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'){
				t = input.charAt(i) - 'A' + 10;
			}else{
				t = input.charAt(i) - '0';
			}
			res = res * x;
			res += t;
		}
		return res;
	}
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		String inputString = in.next();
		String temp_hourString = inputString.split(":")[0];
		String temp_miniteString = inputString.split(":")[1];
		int hourMin = 0, miniteMin = 0, hourMax = 24, miniteMax = 60;
		hourMin = cal_min(temp_hourString);
		if (hourMin > hourMax){
			out.println(0);
			return;
		}
		miniteMin = cal_min(temp_miniteString);
		if (miniteMin > miniteMax){
			out.println(0);
			return;
		}
		int all_min = Math.max(miniteMin, hourMin);
		int real_hour_max = -1;
		for (int i = hourMax; i >= all_min; --i){
			int t = cal_val(temp_hourString, i);
			if (t >= 24){
				continue;
			}else{
				real_hour_max = i;break;
			}
		}
		if (real_hour_max == -1){
			out.println("0");
			return;
		}
		int real_minite_max = -1;
		for (int i = miniteMax; i >= all_min; --i){
			int t = cal_val(temp_miniteString, i);
			if (t >= 60){
				continue;
			}else{
				real_minite_max = i;break;
			}
		}
		if (real_minite_max == -1){
			out.println("0");
			return;
		}
		if (real_hour_max == 24 && real_minite_max == 60){
			out.println("-1");
			return;
		}
		int all_max;
		if (real_hour_max == 24){
			all_max = real_minite_max;
		}else if (real_minite_max == 60){
			all_max = real_hour_max;
		}else{
			all_max = Math.min(real_hour_max, real_minite_max);
		}
		if (all_min > all_max){
			out.println("0");
			return;
		}
		out.print(all_min);
		++all_min;
		for (int i = all_min; i <= all_max; ++i){
			out.print(" " + i);
		}
		out.println();
		return;
	}
}

