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
	String[] names;
	int max_taxi = 0, max_pizza = 0, max_girl = 0;
	public int judge(String input){
		if (input.charAt(0) == input.charAt(1) && input.charAt(1) == input.charAt(3) &&
				input.charAt(3) == input.charAt(4) &&  input.charAt(4) ==  input.charAt(6) &&  
					input.charAt(6) == input.charAt(7)){
			return 1;
		}
		if (input.charAt(0) > input.charAt(1) && input.charAt(1) > input.charAt(3) &&
				input.charAt(3) > input.charAt(4) &&  input.charAt(4) >  input.charAt(6) &&  
				input.charAt(6) > input.charAt(7)){
			return 2;
		}
		return 3;
	}
	public void output(ArrayList<Integer> index) {
		if (index.size() == 0){
			System.out.println(".");
			return;
		}
		System.out.print(names[index.get(0)]);
		for (int i = 1; i < index.size(); ++i){
			System.out.print(", " + names[index.get(i)]);
		}
		System.out.println(".");
		return;
	}
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		int n = in.nextInt();
		names = new String[n];
		ArrayList<Integer> taxi_index = new ArrayList<Integer>();
		ArrayList<Integer> pizza_index = new ArrayList<Integer>();
		ArrayList<Integer> girl_index = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i){
			int size = in.nextInt();
			names[i] = in.next();
			int taxi = 0, pizza = 0, girl = 0;
			for (int j = 0; j < size; ++j){
				String number = in.next();
				if (judge(number) == 1){
					taxi++;
				}else if (judge(number) == 2){
					pizza++;
				}else{
					girl++;
				}
			}
			if (taxi > max_taxi){
				taxi_index.clear();
				taxi_index.add(i);
				max_taxi = taxi;
			}else if (taxi == max_taxi){
				taxi_index.add(i);
			}
			if (pizza > max_pizza){
				pizza_index.clear();
				pizza_index.add(i);
				max_pizza = pizza;
			}else if (pizza == max_pizza){
				pizza_index.add(i);
			}
			if (girl > max_girl){
				girl_index.clear();
				girl_index.add(i);
				max_girl = girl;
			}else if (girl == max_girl){
				girl_index.add(i);
			}
		}
		System.out.print("If you want to call a taxi, you should call: ");
		output(taxi_index);
		System.out.print("If you want to order a pizza, you should call: ");
		output(pizza_index);
		System.out.print("If you want to go to a cafe with a wonderful girl, you should call: ");
		output(girl_index);
		return;
	}
}

