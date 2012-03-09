import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
class Pair{
	public int a;
	public int b;
	public Pair(int a, int b) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
	}
}

class TaskB {
	ArrayList<Pair> list = new ArrayList<Pair>();

	public void solve(long testNumber, Scanner in, PrintWriter out) {
		int n = in.nextInt();
		for (int i = 0; i < n; ++i){
			int a = in.nextInt();
			int b = in.nextInt();
			Pair tPair = new Pair(a, b);
			list.add(tPair);
		}
		Collections.sort(list, new Comparator<Pair>(){
			public int compare(Pair o1, Pair o2){
				if (o1.b != o2.b){
					return (o2.b - o1.b);
				}
				return (o2.a - o1.a);
			}
		});
		int counter = 1;
		int res = 0;
		for (int i = 0; i < n; ++i){
			if (counter <= 0){
				break;
			}
			res += list.get(i).a;
			--counter;
			counter += list.get(i).b;
		}
		out.println(res);
		return;
	}
}

