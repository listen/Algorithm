import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @listen
 */
public class E {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskE solver = new TaskE();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskE {
	public final int MOD = 1000000007;
	int[] p = new int[2001];
	int[] rank = new int[2001];
	int sz;
	void link(int x, int y) {
		if (x == y) return;
		if (rank[x] > rank[y]) p[y] = x;
		else p[x] = y;
		if (rank[x] == rank[y]) rank[y]++;
	}
	void makeset(int n) {
		sz = n;
		for (int i=0;i<sz;i++) {
			p[i] = i; rank[i] = 0;
		}
	}
	int findset(int x) {
		if (x != p[x]) p[x] = findset(p[x]);
		return p[x];
	}
	void unin(int x, int y) {
		link(findset(x), findset(y));
	}
	void compress() {
		for (int i = 0; i < sz; i++) findset(i);
	}
	public long cal(int m, int count) {
		long res = 1;
		for (int i = 0; i < count; ++i){
			res = res * m;
			res = res % MOD;
		}
		return res;
	}
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		if (k > n){
			out.println(cal(m, n));
			return;
		}
		makeset(n);
		int res = 0;
		for (int i = 0; i <= n - k; ++i){
			for (int j = 0; j < (k + 1) / 2; ++j){
				unin(i + j, i + k - 1 - j);
			}
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; ++i){
			int t = findset(i);
			set.add(t);
		}
		int count = set.size();
		out.println(cal(m, count));
		return;
	}
}

