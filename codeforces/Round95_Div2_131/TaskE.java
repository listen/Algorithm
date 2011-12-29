package mypackage;

import com.sun.org.apache.xml.internal.security.utils.I18n;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskE {
    static final int MOD = 1000000007;
    long res = 0;
    long[][] record = new long[2][1001];
    int flag = 0;

	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int [] res = new int[9];
        Arrays.fill(res, 0);

        int[] inputr = new int[m];
        int[] inputc = new int[m];

        int[] minv = new int[100001];
        int[] maxv = new int[100001];
        Arrays.fill(minv, Integer.MAX_VALUE);
        Arrays.fill(maxv, 0);

        int[] minh = new int[100001];
        int[] maxh = new int[100001];
        Arrays.fill(minh, Integer.MAX_VALUE);
        Arrays.fill(maxh, 0);

        int[] mindiff = new int[200001];
        int[] maxdiff = new int[200001];
        Arrays.fill(mindiff, Integer.MAX_VALUE);
        Arrays.fill(maxdiff, 0);

        int[] minsum = new int[200001];
        int[] maxsum = new int[200001];
        Arrays.fill(minsum, Integer.MAX_VALUE);
        Arrays.fill(maxsum, 0);

        for (int i = 0; i < m; ++i){
            int r = in.nextInt();
            int c = in.nextInt();
            inputr[i] = r;
            inputc[i] = c;

            if (c < minh[r]){
                minh[r] = c;
            }
            if (c > maxh[r]){
                maxh[r] = c;
            }

            if (r < minv[c]){
                minv[c] = r;
            }
            if (r > maxv[c]){
                maxv[c] = r;
            }

            if (c > maxdiff[r - c + 100000]){
                maxdiff[r - c + 100000] = c;
            }
            if ( c < mindiff[r - c + 100000]){
                mindiff[r - c + 100000] = c;
            }

            if ( c > maxsum[r + c]){
                maxsum[r + c]  = c;
            }
            if (c < minsum[r + c]){
                minsum[r + c] = c;
            }
        }

        for (int i = 0; i < m; ++i){
            int r = inputr[i];
            int c = inputc[i];
            int tmp = 0;
            if (c > minh[r]){
                ++tmp;
            }
            if (c < maxh[r]){
                ++tmp;
            }
            if (r > minv[c]) {
                ++tmp;
            }
            if (r < maxv[c]){
                ++tmp;
            }
            if (c > mindiff[r - c + 100000]){
                ++tmp;
            }
            if (c < maxdiff[r - c + 100000]){
                ++tmp;
            }
            if (c > minsum[r + c]) {
                ++tmp;
            }
            if (c < maxsum[r + c]){
                ++tmp;
            }
            res[tmp]++;
        }
        out.print(res[0]);
        for (int i = 1; i <= 8; ++i){
            out.print(" " + res[i]);
        }
        out.println("");
        return;
	}
}
