package mypackage;

import java.io.PrintWriter;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
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
        String input = in.nextLine();
        int res = 0;
        for (int i = 0; i < input.length(); ++i){
            int a = (input.charAt(i) );
            int re = reverse(a);
            res = res - re + 256;
            res = res % 256;
            out.println(res);
            res = re;
        }
        return;
	}
}
