package mypackage;

import java.io.PrintWriter;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    ArrayList<Integer> statue_row = new ArrayList<Integer>();
    ArrayList<Integer> statue_col = new ArrayList<Integer>();
    int[] dr = {0,1,1,1,0,0,-1,-1,-1};
    int[] dc = {0,-1,0,1,-1,1,-1,0,1};
    public boolean dfs(int r, int c, int depth){
        if (depth == 9){
            return true;
        }
        for (int i = 0; i < 9; ++i){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8){
                boolean can = true;
                for (int j = 0; j < statue_row.size(); ++j){
                    if ((statue_row.get(j) - depth == nr && statue_col.get(j) == nc) ||
                            statue_row.get(j) - depth == nr + 1 && statue_col.get(j) == nc){
                        can = false;
                        break;
                    }
                }
                if (can){
                    if(dfs(nr, nc, depth + 1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

	public void solve(int testNumber, Scanner in, PrintWriter out) {
        ArrayList<String> input = new ArrayList<String>();
        for (int i = 0; i < 8; ++i){
            String tmp = in.next();
            input.add(tmp);
            for (int j = 0; j < 8; ++j){
                if (tmp.charAt(j) == 'S'){
                    statue_row.add(8 - i - 1);
                    statue_col.add(j);
                }
            }
        }
        if (dfs(0, 0, 0) ){
            out.println("WIN");
        }else{
            out.println("LOSE");
        }
        return;
	}
}
