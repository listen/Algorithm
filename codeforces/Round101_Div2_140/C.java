import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
        	int n = in.nextInt();
        	String[] res = new String[n];
        	int[] height = new int[n];
        	Arrays.fill(height, -1);
        	Map<String, Integer> tp = new TreeMap<String, Integer>();
        	for (int i = 0; i < n; ++i){
        		String tmp = in.next();
        		int count = in.nextInt();
        		tp.put(tmp, count);
        	}
        	List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(tp.entrySet()); 
    		Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {  
    	            public int compare(Map.Entry<String, Integer> o1,  
    	                    Map.Entry<String, Integer> o2) {  
    	                return (o2.getValue() - o1.getValue());  
    	            }  
    	        });
    		
        	int count = 0;
        	for (int i = infoIds.size() - 1; i >= 0; --i){
    			int upto = infoIds.get(i).getValue();
    			//++upto;
    			++count;
    			boolean flag = false;
    			while(upto >= 0){
    				if (height[upto] == -1){
    					flag = true;
    					height[upto] = count;
    					res[upto] = infoIds.get(i).getKey();
    					break;
    				}
    				--upto;
    			}
    			if (!flag){
    				out.println(-1);
    				return;
    			}
    		}
        	for (int i = 0; i < n; ++i){
        		out.println(res[i] + " " + height[i]);
        	}
        	return;
        }        
}