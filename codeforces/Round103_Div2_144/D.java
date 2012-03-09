import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @zhendeaini6001
 */
public class D {
        public static void main(String[] args) {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                Scanner in = new Scanner(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                TaskD solver = new TaskD();
                solver.solve(1, in, out);
                out.close();
        }
}

class TaskD {
	static final int inf = 0x3f3f3f3f; // max of cost
	int n, m, s, l; 
	int[]pre = new int[10001];
	int[][] edge = new int[20001][3];
	long dist[] = new long[10001];
	public int relax (int u, int v, long c){
		if (dist[v] > dist[u] + c) {
			dist[v] = dist[u] + c;
			pre[v] = u; 
			return 1;
		}
		return 0;
	}
	public int bellman (int src){
		int i, j;
		for (i=0; i<n; ++i) {
			dist[i] = inf; pre[i] = -1;
		}
		dist[src] = 0;
		for (i=1; i<n; ++i) for (j=0; j<m; ++j) {
			relax(edge[j][0], edge[j][1], edge[j][2]);
		}
		for (j=0; j<m; ++j) {
			if (1 == relax(edge[j][0], edge[j][1], edge[j][2]))
				return 0; // ÓĞ¸ºÈ¦
		}
		return 1;
	}
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        s = in.nextInt();
        for (int i = 0; i < m; ++i){
        	//edge[2*i][0] = in.nextInt() - 1;
        	//edge[2*i][1] = in.nextInt() - 1;
        	//edge[2*i][2] = in.nextInt();
        	edge[2*i][0] = in.nextInt() - 1;
        	edge[2*i][1] = in.nextInt() - 1;
        	edge[2*i][2] = in.nextInt();
        	edge[2*i + 1][0] = edge[2*i][1];
        	edge[2*i + 1][1] = edge[2*i][0];
        	edge[2*i + 1][2] = edge[2*i][2];
        }
        l = in.nextInt();
        m = m * 2;
        bellman(s - 1);
        int res = 0;
        for (int i = 0 ; i < n; ++i){
        	if (dist[i] == l){
        		++res;
        	}
        }
        for (int i = 0; i < m; i += 2){
        	if ((dist[edge[i][0]] < l && dist[edge[i][1]] > l) || (dist[edge[i][0]] > l && dist[edge[i][1]] < l)){
        		++res;
        		continue;
        	}else if (dist[edge[i][0]] == l && dist[edge[i][1]] == l){
        		//++res;
        		continue;
        	}else if (dist[edge[i][0]] == l){
        		if (dist[edge[i][1]] < l && dist[edge[i][1]] + edge[i][2] > l){
        			++res;
        			continue;
        		}
        	}else if (dist[edge[i][1]] == l){
        		if (dist[edge[i][0]] < l && dist[edge[i][0]] + edge[i][2] > l){
        			++res;
        			continue;
        		}
        	}else if (dist[edge[i][0]] < l && dist[edge[i][1]] < l){
        		long dist_max = Math.max(dist[edge[i][0]], dist[edge[i][1]]);
        		long dist_min = Math.min(dist[edge[i][0]], dist[edge[i][1]]);
        		long diff = dist_max - dist_min; 
        		if (diff >= edge[i][2]){
        			continue;
        		}
        		if (((double)(edge[i][2] + dist_min + dist_max)) / 2 > l){
        			++res;
        			++res;
        			continue;
        		}else if (((double)(edge[i][2] + dist_min + dist_max)) / 2 == l){
        			++res;
        		}
        	}
        }
        out.println(res);
        return;
    }        
}