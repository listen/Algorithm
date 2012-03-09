import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

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
	public static long MOD = 100001L;
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		ArrayList<Long> record = new ArrayList<Long>();
		int n = in.nextInt();
		int m = in.nextInt();
		long res = 0;
		boolean[] visited = new boolean[n + 1];
		Arrays.fill(visited, false);
		for (int i = 0; i < m; ++i){
			int a = in.nextInt();
			visited[a] = true;
			int b = in.nextInt();
			visited[b] = true;
			record.add(Math.min(a, b) * MOD + Math.max(a, b));
		}
		int counter = 0;
		for (int i = 1; i <= n; ++i){
			if (!visited[i]){
				++counter;
			}
		}
		res += ((long)counter) * (counter - 1) / 2;
		Collections.sort(record);
		for (int i = 0; i < record.size(); ++i){
			int j = i + 1; boolean valid = true;
			for (; j < record.size(); ++j){
				if (record.get(i) / MOD == record.get(j) / MOD){
					continue;
				}else{
					valid = false;
					break;
				}
			}
			int end = j;
			if (end == record.size()){
				--end;
			}
			res += end - i + 1;
			Set<Long> iSet = new HashSet<Long>();
			for (int ii = i; ii <= end; ++ii){
				iSet.add(record.get(ii) % MOD); 
			}
			for (int ii = i; ii <= end; ++ii){
				long b = record.get(ii) % MOD;
				for (int jj = end + 1; jj < record.size(); ++jj){
					if (record.get(jj) / MOD == b){
						iSet.add(b % MOD);
					}else if (record.get(jj) / MOD > b){
						break;
					}
				}
			}
			res += iSet.size();
			i = j;
		}
		out.println(res);
		return;
	}
}

