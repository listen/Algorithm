package mypackage;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskD {
    class Permutation {
            private void swap(int[] a, int i, int j) {
                int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        private void reverse(int[] a, int from, int to) {
            while (from < to)
                swap(a, from++, to--);
        }

        public boolean nextPermutation(int[] a) {
            // find the first inversion
            int i = a.length - 2;
            while (i >= 0 && a[i] >= a[i + 1])
                --i;
            if (i < 0)
                return false;
            // find the smallest number after i that is larger than a[i]
            int j = a.length - 1;
            while (a[j] <= a[i])
                --j;
            swap(a, i, j);
            reverse(a, i + 1, a.length - 1);
            return true;
        }

    }
    int[][] input;
    public boolean isValid(int[] a){
        int[][] square = new int[4][2];
        for (int i = 0; i < 4; ++i){
            square[i][0] = input[a[i]][0];
            square[i][1] = input[a[i]][1];
        }
        return true;
    }

	public void solve(int testNumber, Scanner in, PrintWriter out) {
        input = new int[8][2];
        for (int i = 0; i < 8; ++i){
            input[i][0] = in.nextInt();
            input[i][1] = in.nextInt();
        }
        Permutation p = new Permutation();
		int[] a = {0, 1, 2, 3, 4, 5, 6, 7};
		do {
            if (isValid(a) ){
                out.print("YES");
                for (int i = 0; i < 4; ++i){
                    out.print(" " + a[i] + 1);
                }
                out.println();
                out.print(a[4]);
                for (int i = 5; i < 8; ++i){
                    out.print(" " + a[i]);
                }
                out.println();
                return;
            }
		} while (p.nextPermutation(a));
        out.println("NO");
        return;
	}
}
