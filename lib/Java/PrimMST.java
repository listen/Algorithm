package lib;

import java.util.Arrays;

//无向图最小生成树,prim算法,邻接阵形式,复杂度O(n^2)
//返回最小生成树的长度,传入图的大小n和邻接阵g图,不相邻点边权inf
//可更改边权的类型,pre[]返回树的构造,用父结点表示,根节点(第一个)pre值为-1
//必须保证图的连通的!
public class PrimMST {
	public final int MAXN =200;
	public final double inf = 1000000000;
	public int[] pre = new int[MAXN];
	double prim(int n,double g[][],int[] pre){
		double[] min = new double[MAXN];
		int[] visited = new int[MAXN];
		double res = 0;
		int i, j, k;
		Arrays.fill(min, inf);
		Arrays.fill(visited, 0);
		Arrays.fill(pre, -1);
		for (min[j=0]=0;j<n;j++){
			for (k=-1,i=0;i<n;i++){
				if (visited[i] == 0 && (k==-1 || min[i]<min[k])){
					k=i;
				}
			}
			for (visited[k]=1,res+=min[k],i=0;i<n;i++){
				if (visited[i] == 0 && g[k][i]<min[i]){
					min[i]=g[pre[i]=k][i];
				}
			}
		}
		return res;
	}
}

