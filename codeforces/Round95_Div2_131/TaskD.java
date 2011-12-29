package mypackage;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskD {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] inputstart = new int[3001];
        int[] inputend = new int[3001];
        int[] res = new int[3001];

        int[] next = new int[3001];
        int[] pre = new int[3001];
        boolean[] visited = new boolean[3001];
        Arrays.fill(next, -1);
        Arrays.fill(pre, -1);
        Arrays.fill(visited, false);
        Arrays.fill(res, 0);
        int ss = -1 , ee = -1;
        for (int i = 0; i < n; ++i){
            int start = in.nextInt();
            int end = in.nextInt();

            if (start > end){
                int tmp = end;
                end = start;
                start = tmp;
            }
            if (visited[end] || visited[start]){
                ss = start;
                ee = end;
                continue;
            }else{
                inputstart[i] = start;
                inputend[i] = end;
                next[start] = end;
                pre[end] = start;
                visited[end] = true;
                visited[start] = true;
            }
        }
        int tmp = 0;
        while(pre[ss] != -1){
            ++tmp;
            res[pre[ss]] = tmp;
            ss = pre[ss];
        }
        tmp = 0;
        while (next[ee] != -1){
            ++tmp;
            res[next[ee]] = tmp;
            ee = next[ee];
        }
        for (int i = 1; i <= n; ++i){
             if(res[i] == -1){
                 res[i] = 0;
             }
        }
        out.print(res[1]);
        for (int i = 2; i <= n; ++i){
            out.print(" " + res[i]);
        }
        out.println();
	}
}
