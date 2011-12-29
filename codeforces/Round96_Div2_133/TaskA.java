package mypackage;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        for (int i = 0; i < input.length(); ++i){
            if (input.charAt(i) == 'H' || input.charAt(i) == 'Q' || input.charAt(i) == '9'){
                out.println("YES");
                return;
            }
        }
        out.println("NO");
        return;
	}
}
