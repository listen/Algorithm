import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @zhendeaini6001
 */
public class C {
        public static void main(String[] args) {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                Scanner in = new Scanner(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                TaskC solver = new TaskC();
                solver.solve(1, in, out);
                out.close();
        }
}

class TaskC {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
        	String string = in.next();
        	String pString = in.next();
        	if (pString.length() > string.length()){
        		out.println(0);
        		return;
        	}
        	int[][] count = new int[string.length()][26];
        	for (int i = 0; i < string.length(); ++i){
        		Arrays.fill(count[i], 0);
        	}
        	if (string.charAt(0) != '?'){
        		count[0][string.charAt(0) - 'a'] = 1;
        	}
        	for (int i = 1; i < string.length(); ++i){
        		System.arraycopy(count[i-1], 0, count[i], 0, 26);
        		if (string.charAt(i) != '?'){
        			count[i][string.charAt(i) - 'a']++;
        		}
        	}
        	int[] target_count = new int[26];
        	Arrays.fill(target_count, 0);
        	for (int i = 0; i < pString.length(); ++i){
        		target_count[pString.charAt(i) - 'a']++;
        	}
        	int res = 0;
        	boolean tmp = true;
        	for (int i = 0; i < 26; ++i){
        		if (target_count[i] < count[pString.length() - 1][i] - 0){
        			tmp = false;
        			break;
        		}
        	}
        	if (tmp){
        		++res;
        	}
        	for (int i = 1; i <= string.length() - pString.length(); ++i){
        		int begin = i;
        		int end = i + pString.length() - 1;
        		boolean flag = true;
        		for (int j = 0; j < 26; ++j){
        			if (target_count[j] < count[end][j] - count[begin - 1][j]){
        				flag = false;
        				break;
        			}
        		}
        		if (flag){
        			++res;
        		}
        	}
        	out.println(res);
        	return;
        }   
}