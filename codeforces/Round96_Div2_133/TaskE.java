package mypackage;

import com.sun.org.apache.xml.internal.security.utils.I18n;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskE {
    int[][][] dp = new int[101][51][2];
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        int num = in.nextInt();
        int n = input.length();
        for (int i = 0; i < 101; ++i){
            for (int j = 0; j < 51; ++j){
                Arrays.fill(dp[i][j], 0);
            }
        }
        int res = 0;
        int flag = 0;
        for (int i = 1; i <= n; ++i)     {
            if (input.charAt(i - 1) == 'F'){
                 if (flag == 0){
                     ++res;
                 }else{
                     --res;
                }
                dp[i][0][flag] = res;
            }else{
               flag = flag ^ 1;
            }
        }
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        for (int i = 1; i < num; ++i){
            dp[0][i][0] = 1001;
            dp[0][i][1] = 1001;
        }
        for (int i = 1; i <= n; ++i){
            for (int j = 1; j <= Math.min(num, i); ++j){
                if (input.charAt(i - 1) == 'F'){
                    if (dp[i - 1][j][0] == 1001){
                        dp[i][j][0] = dp[i-1][j-1][1];
                    }else if (Math.abs(dp[i-1][j-1][1]) <= Math.abs(dp[i-1][j][0] + 1)){
                        dp[i][j][0] = dp[i - 1][j][0] + 1;
                    }else{
                        dp[i][j][0] = dp[i-1][j-1][1];
                    }

                    if (dp[i - 1][j][1] == 1001){
                        dp[i][j][1] = dp[i - 1][j - 1][0];
                    }else if (Math.abs(dp[i - 1][j - 1][0]) <= Math.abs(dp[i -1][j][1] - 1) && j <= i - 1){
                        dp[i][j][1]  = dp [i - 1][j][1] - 1;
                    }else{
                        dp[i][j][1] = dp[i - 1][j - 1][0];
                    }

                }else{
                    if (dp[i - 1][j - 1][0] == 1001){
                        dp[i][j][0] = dp[i-1][j][1];
                    }else if (Math.abs(dp[i - 1][j][1]) <= Math.abs(dp[i - 1][j - 1][0] + 1) && j <= i) {
                       dp[i][j][0] = dp[i - 1][j - 1][0] + 1;
                   }else{
                       dp[i][j][0] = dp[i - 1][j][1];
                   }
                    if (dp[i - 1][j - 1][1] == 1001){
                          dp[i][j][1] = dp[i - 1][j][0];
                    }else if (Math.abs(dp[i - 1][j][0]) <= Math.abs(dp[i - 1][j - 1][1] - 1) && j <= i){
                       dp[i][j][1] = dp[i - 1][j - 1][1] - 1;
                   }else{
                        dp[i][j][1] = dp[i - 1][j][0];
                   }
                }

            }
        }
        res = Math.max(Math.abs(dp[n][num][0]), Math.abs(dp[n][num][1]));
        out.println(res);
        return;
	}
}
