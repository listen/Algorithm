package lib;

import java.util.Arrays;

//����ͼ��С������,prim�㷨,�ڽ�����ʽ,���Ӷ�O(n^2)
//������С�������ĳ���,����ͼ�Ĵ�Сn���ڽ���gͼ,�����ڵ��Ȩinf
//�ɸ��ı�Ȩ������,pre[]�������Ĺ���,�ø�����ʾ,���ڵ�(��һ��)preֵΪ-1
//���뱣֤ͼ����ͨ��!
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

