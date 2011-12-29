package mypackage;

import java.io.PrintWriter;
import java.lang.Integer;
import java.lang.String;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public int reverse(int x){
	    x = ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1);
	    x = ((x & 0xcccccccc) >> 2) | ((x & 0x33333333) << 2);
	    x = ((x & 0xf0f0f0f0) >> 4) | ((x & 0x0f0f0f0f) << 4);
	    x = ((x & 0xff00ff00) >> 8) | ((x & 0x00ff00ff) << 8);
	    x = ((x & 0xffff0000) >> 16) | ((x & 0x0000ffff) << 16);
	    return ((x >> 24) & 0x000000ff);
    }

	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; ++i){
            input[i] = in.nextInt();
        }
        Arrays.sort(input);
        boolean flag = false;
        for (int i = 0; i < input.length; ++i){
            if (input[i] != 1){
                flag = true;
                break;
            }
        }
        if (flag){
            input[input.length - 1] = 1;
            Arrays.sort(input);
            out.print(input[0]);
        }else{
            input[input.length - 1] = 2;
            out.print(input[0]);
        }
        for (int i = 1; i < input.length; ++i){
            out.print(" " + input[i]);
        }
        return;
	}
}
