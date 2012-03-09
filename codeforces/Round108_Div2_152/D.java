import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @listen
 */
public class Main {
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
	int n = 0, m = 0, upperleft1x =0, upperleft1y=0, downright1x=0, downright1y=0;
	int upperleft2x =0, upperleft2y=0, downright2x=0, downright2y=0;
	boolean flag1 = false, flag2 = false;
	boolean[][] matrix;
	boolean[][] copy_matrix;
	ArrayList<Integer>upperleftx = new ArrayList<Integer>();
	ArrayList<Integer>upperlefty = new ArrayList<Integer>();
	ArrayList<Integer>downrightx = new ArrayList<Integer>();
	ArrayList<Integer>downrighty = new ArrayList<Integer>(); 
	public boolean isValid(int x1, int y1, int x2, int y2){
		if (Math.abs(x1 - x2) < 2 || Math.abs(y1 - y2) < 2){
			return false;
		}
		for (int i = x1; i <= x2; ++i){
			if (!matrix[i][y1]){
				return false;
			}
		}
		for (int i = x1; i <= x2; ++i){
			if (!matrix[i][y2]){
				return false;
			}
		}
		for (int i = y1; i <= y2; ++i){
			if (!matrix[x1][i]){
				return false;
			}
		}
		for (int i = y1; i <= y2; ++i){
			if (!matrix[x2][i]){
				return false;
			}
		}
		return true;
	}
	public void check(int x1, int y1, int x2, int y2){
		for (int i = x1; i <= x2; ++i){
			copy_matrix[i][y1] = false;
		}
		for (int i = x1; i <= x2; ++i){
			copy_matrix[i][y2] = false;
		}
		for (int i = y1; i <= y2; ++i){
			copy_matrix[x1][i] = false;
			copy_matrix[x2][i] = false;
		}
		
		return ;
	}
	public boolean check_true(){
		for (int i =0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				if (copy_matrix[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		n = in.nextInt();
		m =in.nextInt();
		matrix = new boolean[n][m];
		String[] inputStrings = new String[n];
		for (int i = 0; i < n; ++i){
			inputStrings[i] = in.next();
			for (int j = 0; j < m; ++j){
				if (inputStrings[i].charAt(j) == '#'){
					matrix[i][j] = true;
				}else{
					matrix[i][j] = false;
				}
			}
		}
		for (int i = 0; i <= n - 3; ++i){
			for (int j = 0; j <= n - 3; ++j){
				if (matrix[i][j] && matrix[i+1][j] && matrix[i][j+1]){
					upperleftx.add(i);
					upperlefty.add(j);
				}
			}
		}
		for (int i = 2; i < n; ++i){
			for (int j = 2; j < m; ++j){
				if (matrix[i][j] && matrix[i-1][j] && matrix[i][j-1]){
					downrightx.add(i);
					downrighty.add(j);
				}
			}
		}
		for (int i = 0; i < upperleftx.size(); ++i){
			for (int j = 0; j < downrightx.size(); ++j){
				if(isValid(upperleftx.get(i), upperlefty.get(i), downrightx.get(j), downrighty.get(j))){
					for (int ii = 0; ii < upperleftx.size(); ++ii){
						for (int jj = 0; jj < downrightx.size(); ++jj){
							if(isValid(upperleftx.get(ii), upperlefty.get(ii), downrightx.get(jj), downrighty.get(jj))){
								/*if (ii == i && jj == j){
									continue;
								}else{*/
									upperleft1x = upperleftx.get(i);
									upperleft1y = upperlefty.get(i);
									downright1x = downrightx.get(j);
									downright1y = downrighty.get(j);
									upperleft2x = upperleftx.get(ii);
									upperleft2y = upperlefty.get(ii);
									downright2x = downrightx.get(jj);
									downright2y = downrighty.get(jj);
									copy_matrix = new boolean[n][m];
									for(int nn = 0; nn < n; ++nn){
										for (int mm = 0; mm < m; ++mm){
											copy_matrix[nn][mm] = matrix[nn][mm];
										}
									}
									check(upperleftx.get(i), upperlefty.get(i), downrightx.get(j), downrighty.get(j));
									check(upperleftx.get(ii), upperlefty.get(ii), downrightx.get(jj), downrighty.get(jj));
									if (check_true()){
										out.println("YES");
										upperleft1x++;upperleft1y++;
										downright1x++;downright1y++;
										upperleft2x++;upperleft2y++;
										downright2x++;downright2y++;
										out.println(upperleft1x + " " + upperleft1y + " " + downright1x + " " + downright1y);
										out.println(upperleft2x + " " + upperleft2y + " " + downright2x + " " + downright2y);
										return;
									}
								//}
							}
						}
					}
				}
			}
		
		}	
		out.println("NO");
		return;
	}
}
