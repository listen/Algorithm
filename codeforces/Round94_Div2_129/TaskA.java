package mypackage;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int even = 0, odd = 0;
        for (int i = 0; i < n; ++i){
            int count = in.nextInt();
            if (count % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        if (odd % 2 == 0){
            out.println(even);
            return;
        }else{
            out.println(odd);
            return;
        }

	}
}
