package lib;

import java.util.ArrayList;
import java.util.List;

public class DFSAmn {
	//@从m个元素中选出n个出来，这n个要进行排列
	//list中存储的是原来所有元素的下标
	List<Integer> list = new ArrayList<Integer>();
	int count = 0;
	int m, n;
	//生成第一个
	public void generate(){
	}
	//剪枝用
	public boolean isValid(){
		return true;
	}
	public void dfs(int m, int depth) {
		if (depth == 0){
			++count;
			return;
		}
		for (int i = 0; i < m; i++) {
			if (!list.contains(i)){
				list.add(i);
				/*if (depth == n){//可能是不需要的
					generate();
					dfs(m, depth - 1);
				}else{*/
					if (isValid()){
						dfs(m, depth -1);
					}
					list.remove(Integer.valueOf(i));//移除掉这个下标
				//}
			}
		}
	}
	
	public static void main(String[] args){
		DFSAmn test = new DFSAmn();
		test.dfs(4, 2);
		System.out.println(test.count);
	}
}
