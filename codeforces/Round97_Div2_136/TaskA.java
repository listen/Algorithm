package mypackage;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] res = new int[101];
        for (int i = 0; i < n; ++i) {
            int tmp = in.nextInt();
            res[tmp] = i + 1;
        }
        out.print(res[1]);
        for (int i = 2; i <= n; ++i){
            out.print( " "  + res[i]);
        }
        out.println();
        return;
	}
}
