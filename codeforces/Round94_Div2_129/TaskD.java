package mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

class StringUtils {
	public static int[] prefixFunction(CharSequence s) {
        int l = s.length();
        int[] p = new int[l];
        p[0] = 0;
        int k = 0;
        for (int i = 1; i < l; i++) {
                while ((k > 0) && (s.charAt(k) != s.charAt(i)))
                        k = p[k - 1];
                if (s.charAt(k) == s.charAt(i))
                        k++;
                p[i] = k;
        }
        return p;
	}
	public static int[] zAlgorithm(CharSequence s) {
        int length = s.length();
        int[] z = new int[length];
        z[0] = 0;

        int left = 0, right = 0;
        for (int i = 1; i < length; i++) {
                if (i > right) {
                        int j;
                        //noinspection StatementWithEmptyBody
                        for (j = 0; i + j < length && s.charAt(i + j) == s.charAt(j); j++) ;
                        z[i] = j;
                        left = i;
                        right = i + j - 1;
                } else if (z[i - left] < right - i + 1)
                        z[i] = z[i - left];
                else {
                        int j;
                        //noinspection StatementWithEmptyBody
                        for (j = 1; right + j < length && s.charAt(right + j) == s.charAt(right - i + j); j++) ;
                        z[i] = right - i + j;
                        left = i;
                        right = right + j - 1;
                }
        }
        return z;
	}
	public static int kmp(String text, String pattern){
		int[] fail = prefixFunction(pattern);
		int i = 0, j = 0;
		while (i < text.length() && j < pattern.length() ){
			if (pattern.charAt(j) == text.charAt(i)){
				++i;++j;
			}else if (j == 0){//如果第一个字符匹配失败，从str的下一个字符开始
				++i;
			}else{
				j = fail[j - 1];
			}
		}
		if (j == pattern.length() ){
			return i - j;
		}else{
			return -1;
		}

	}
}
public class TaskD {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        char c = input.charAt(input.length() - 1);
        char cc = input.charAt(0);
        List<Integer> tail = new ArrayList<Integer>();
        List<Integer> head = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); ++i){
            if (input.charAt(i) == c && i != input.length() - 1){
                tail.add(i);
            }
        }
       for (int i = tail.size() - 1; i >= 0; --i){
           String pattern = input.substring(0, tail.get(i) + 1);
           if (pattern.equals("fix")){
               int cm = 190;
           }
           if (input.substring(input.length()- tail.get(i) - 1).equals(pattern) ){
               String text = input.substring(1, input.length() - 1);
               if (StringUtils.kmp(text, pattern) != -1){
                   out.println(pattern);
                   return;
               }
           }
        }
        out.println("Just a legend");
	}
}
