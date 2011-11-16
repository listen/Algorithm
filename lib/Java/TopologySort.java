package lib;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TopologySort {
	public final int MAXSIZE = 100;
	//@拓扑排序首先要有一个图，如果a->b有边，则g[a][b] = true;否则false
	boolean[][] g = new boolean[MAXSIZE][MAXSIZE];
	//set用来记录都有哪些节点，也就是上图中的所有节点；图中节点需要映射成整形
	//set<Type>......
    Set<Character> set = new HashSet<Character>();
   public String topologySort(String[] messages) {
	   //初始化图
		for (int i = 0; i < MAXSIZE; i++) {
			Arrays.fill(g[i], false);
		}
		for (int i = 0; i < messages.length; i++) {
			for (int j = 0; j < messages[i].length() - 1; j++) {
				//根据题意映射成整形变量的图
				g[i][j] = true;
				//set.add(Type)
				set.add(messages[i].charAt(j));
			}
			//set.add(最后一个Type)
			set.add(messages[i].charAt(messages[i].length()-1));
		}
		//存储结果
		//List<Type> res = ArrayList<Type>();
		StringBuilder sb = new StringBuilder();
		while (!set.isEmpty()){
			for (int i = 0; i < MAXSIZE; i++) {
				//如果还有元素
				if (set.contains('a')){
					int j;
					for (j = 0; j < MAXSIZE; j++) {
						if (g[j][i] == true){
							break;
						}
					}
					if (j == MAXSIZE){
						//根据题意将整形映射成Type
						//res.add(Type)
						sb.append('a');
						Arrays.fill(g[i], false);
						//根据题意将整形映射成Type
						set.remove('a');
						break;//一定要break, 可以输出字典序的
					}
				}
			}
		}
		//return res
		return sb.toString();
   	}
}
