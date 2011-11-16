package lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class MapOperation {
	//@lisen 根据value从大到小排序
	public void sortByValue(Map<String, Integer> tp){
		tp= new TreeMap<String, Integer>();
		List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(tp.entrySet()); 
		Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {  
	            public int compare(Map.Entry<String, Integer> o1,  
	                    Map.Entry<String, Integer> o2) {  
	                return (o2.getValue() - o1.getValue());  
	            }  
	        });
		int count = 0;
		for (int i = 0; i < infoIds.size(); i++) {
			count += infoIds.get(i).getValue();
		}
	}	
}
