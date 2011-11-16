package mypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        boolean[][] tied = new boolean[101][101];
        int[] count = new int[101];
        int m = in.nextInt();
        int res = 0;
        for (int i = 0; i < m; ++i){
            int start  = in.nextInt();
            int end = in.nextInt();
            tied[start][end] = true;
            tied[end][start] = true;
            count[start]++;
            count[end]++;
        }
        while (true){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i <= n; ++i){
                if (count[i] == 1){
                    list.add(i);
                }
            }
            if (list.size() == 0){
                break;
            }
            res++;
            for (int i = 0; i < list.size(); ++i){
                for (int j = 1; j <= n; ++j){
                    if (tied[list.get(i)][j]){
                        tied[list.get(i)][j] = false;
                        tied[j][list.get(i)] = false;
                        --count[list.get(i)];
                        --count[j];
                    }
                }
            }
        }
        out.println(res);
	}
}
