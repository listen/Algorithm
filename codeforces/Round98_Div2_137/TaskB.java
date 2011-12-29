package mypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
    public static int[] representationInBase(long number, int base) {
		long basePower = base;
		int exponent = 1;
		while (number >= basePower) {
			basePower *= base;
			exponent++;
		}
		int[] representation = new int[exponent];
		for (int i = 0; i < exponent; i++) {
			basePower /= base;
			representation[i] = (int) (number / basePower);
			number %= basePower;
		}
		return representation;
	}
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int c = in.nextInt();
        ArrayList<Integer> aList = new ArrayList<Integer>();
        int[] aarray = representationInBase(a, 3);
        ArrayList<Integer> cList = new ArrayList<Integer>();
        int[] carray = representationInBase(c, 3);
        if (aarray.length < carray.length){
            for (int i = 0; i < carray.length - aarray.length; ++i){
                aList.add(0);
            }
        }else{
            for (int i = 0; i < aarray.length - carray.length; ++i){
                cList.add(0);
            }
        }
        for (int i = 0; i < aarray.length; ++i){
            aList.add(aarray[i]);
        }
        for (int i = 0; i < carray.length; ++i){
            cList.add(carray[i]);
        }
        int[] res = new int[aList.size()];
        for (int i = 0; i < cList.size(); ++i){
            res[i] =  cList.get(i) - aList.get(i);;
            if (res[i] < 0){
                res[i] += 3;
            }
        }
        long ret = 0;
        for (int i = 0; i < res.length; ++i){
            ret += res[i];
            ret = ret * 3;
        }
        ret = ret / 3;
        out.println(ret);
        return;
	}
}
