package mypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskE {
    static final int MOD = 1000000007;
    long res = 0;
    long[][][] record = new long[2][1001][1001];
    int flag = 0;
    public long dfs(int n, int m, int k){
        if (k == 0){
            return 1;
        }
        if (n - 2 < k || m -2 < k){
            return 0;
        }
        long tmp = 0;
        for (int i = n - 2; i >= k ; --i){
           for (int j = m - 2; j >= k; --j){
               tmp += ( (n - 1- i) * (m - 1 - j) * (dfs(i, j, k - 1) % MOD) ) % MOD;
           }
        }
        return tmp;
    }

	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        for (int i = 0; i < 2; ++i){
            for (int j = 0; j < 1001; ++j){
                Arrays.fill(record[i][j], 0);
            }
        }
        for (int i = 3; i <= n; ++i){
            for (int j = 3; j <= m; ++j){
                record[flag][i][j] = ((i - 2) * (j - 2) ) % MOD;
            }
        }

        for (int i = 2; i <= k; ++i){
            for (int a = i + 2; a <= n; ++a){
                for (int b = i + 2; b <= m; ++b){
                    record[flag ^ 1][a][b] = ( (a - 2) * (b - 2) * (record[flag][a - 2][b - 2] % MOD) ) % MOD;
                    flag = flag ^ 1;
                }
            }
        }
        for (int i = 1; i <= n; ++i){
            for (int j = 1; j <= m; ++j){
                res += record[flag][i][j];
                res = res % MOD;
            }
        }
        out.println(res);
        return;
	}
}
