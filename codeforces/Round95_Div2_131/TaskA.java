package mypackage;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        boolean first = true;
        for (int i = 0; i < input.length(); ++i){
            if (input.charAt(i) >= 'a'){
                first = false;
                break;
            }
        }
        if (first){
            for (int i = 0; i < input.length(); ++i){
                    out.print((char)(input.charAt(i) + 32));
            }
            out.println();
            return;
        }
        if (input.charAt(0) >= 'a' && input.charAt(0) <= 'z'){
            boolean found = true;
            for (int i = 1; i < input.length(); ++i){
                if (input.charAt(i) <= 'z' && input.charAt(i) >= 'a'){
                    found = false;
                    break;
                }
            }
            if (found){
                out.print((char)(input.charAt(0) - 32));
                for (int i = 1; i < input.length(); ++i){
                    out.print((char)(input.charAt(i) + 32));
                }
                out.println();
                return;
            }
        }
        out.println(input);
        return;
	}
}
