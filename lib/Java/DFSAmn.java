package lib;

import java.util.ArrayList;
import java.util.List;

public class DFSAmn {
	//@��m��Ԫ����ѡ��n����������n��Ҫ��������
	//list�д洢����ԭ������Ԫ�ص��±�
	List<Integer> list = new ArrayList<Integer>();
	int count = 0;
	int m, n;
	//���ɵ�һ��
	public void generate(){
	}
	//��֦��
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
				/*if (depth == n){//�����ǲ���Ҫ��
					generate();
					dfs(m, depth - 1);
				}else{*/
					if (isValid()){
						dfs(m, depth -1);
					}
					list.remove(Integer.valueOf(i));//�Ƴ�������±�
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
