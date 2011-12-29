package mypackage;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskE {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        int oneCount = 0, zeroCount = 0, blurCount = 0;
        for (int i = 0; i < input.length(); ++i){
            if (input.charAt(i) == '1'){
                oneCount++;
            }else if (input.charAt(i) == '0'){
                zeroCount++;
            }else{
                blurCount++;
            }
        }
        int removeOneCount = 0, removeZeroCount = 0, removeBlurCount = 0, oneIndex = -1, zeroIndex = -1, blurIndex = -1;
        for (int i = 0; i < input.length() - 2; ++i){
            boolean found =false;
            if (i % 2 == 0 && removeOneCount != oneCount){
                while (++oneIndex < input.length()) {
                    if (input.charAt(oneIndex) == '1'){
                        found = true;
                        ++removeOneCount;
                        break;
                    }
                }
                if (found){
                    continue;
                }
            }else if (i % 2 == 1 && removeZeroCount != zeroCount){
                while (++zeroIndex < input.length()) {
                    if (input.charAt(zeroIndex) == '0'){
                        found = true;
                        ++removeZeroCount;
                        break;
                    }
                }
                if (found){
                    continue;
                }
            }
            if (removeBlurCount != blurCount){

            }else{
                if (i % 2 == 0){
                    out.println("00");
                    return;
                }else{
                out.println("11");
                return;
            }
        }

        return;
	}
    }
}
