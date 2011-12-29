package mypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] count = new int[30];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; ++i){
            int tmp = in.nextInt();
                count[tmp + 10]++;
        }
        long res = 0;
        for (int i = 0; i < 10; ++i){
            res += ( ( (long)(count[i]) ) * ((long)(count[20 - i])));
        }
        res += ( ( ( (long)(count[10]) ) * ((long)(count[10] - 1))) / 2);
        out.println(res);
        return;
	}
}
