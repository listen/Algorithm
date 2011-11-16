package lib;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TopologySort {
	public final int MAXSIZE = 100;
	//@������������Ҫ��һ��ͼ�����a->b�бߣ���g[a][b] = true;����false
	boolean[][] g = new boolean[MAXSIZE][MAXSIZE];
	//set������¼������Щ�ڵ㣬Ҳ������ͼ�е����нڵ㣻ͼ�нڵ���Ҫӳ�������
	//set<Type>......
    Set<Character> set = new HashSet<Character>();
   public String topologySort(String[] messages) {
	   //��ʼ��ͼ
		for (int i = 0; i < MAXSIZE; i++) {
			Arrays.fill(g[i], false);
		}
		for (int i = 0; i < messages.length; i++) {
			for (int j = 0; j < messages[i].length() - 1; j++) {
				//��������ӳ������α�����ͼ
				g[i][j] = true;
				//set.add(Type)
				set.add(messages[i].charAt(j));
			}
			//set.add(���һ��Type)
			set.add(messages[i].charAt(messages[i].length()-1));
		}
		//�洢���
		//List<Type> res = ArrayList<Type>();
		StringBuilder sb = new StringBuilder();
		while (!set.isEmpty()){
			for (int i = 0; i < MAXSIZE; i++) {
				//�������Ԫ��
				if (set.contains('a')){
					int j;
					for (j = 0; j < MAXSIZE; j++) {
						if (g[j][i] == true){
							break;
						}
					}
					if (j == MAXSIZE){
						//�������⽫����ӳ���Type
						//res.add(Type)
						sb.append('a');
						Arrays.fill(g[i], false);
						//�������⽫����ӳ���Type
						set.remove('a');
						break;//һ��Ҫbreak, ��������ֵ����
					}
				}
			}
		}
		//return res
		return sb.toString();
   	}
}
