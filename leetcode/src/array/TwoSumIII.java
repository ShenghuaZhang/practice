package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumIII {
	Map<Integer,Integer> map = new HashMap<>();
	List<Integer> list = new ArrayList<>();
	/************************** 0 **************************/
	// add--O(n) find--O(1) space--O(n^2)
	public void add(int number){
		int size = list.size();
		while(size>0)	{
			size--;
			map.put(list.get(size)+number, null);
		}
		list.add(number);
	}
	
	public boolean find(int value){
		return map.containsKey(value);
	}
	
	/************************** 1 **************************/
	// add--O(n) find--O(n) space--O(n)
	public void addI(int number){
		if (list.isEmpty()){
			list.add(number);
			return;
		}
		int start = 0, end = list.size()-1, middle = (start+end)/2;
		for(; start <= end; middle=(start+end)/2){
			if (number>list.get(middle))	start = middle+1;
			else if (number<list.get(middle))	end = middle-1;
			else return;
		}
		list.add(list.get(list.size()-1));
		for (int i=start; i < list.size(); i++){
			int temp = list.get(i);
			list.set(i, number);
			number = temp;
		}
	}
	
	public boolean findI(int value){
		int start = 0, end = list.size()-1;
		while(start < end){
			if (list.get(start)+list.get(end) < value)	start++;
			else if (list.get(start)+list.get(end) > value)	end--;
			else return true;
		}
		return false;
	}
	
	/************************** 2 **************************/
	// add--O(1) find--O(n) space--O(n)
	// TODO: Map.Entry<Integer, Integer> entry:map.entrySet()
	public void addII(int number){
		int count = map.containsKey(number)?map.get(number):0;
		map.put(number, count+1);
	}
	public boolean findII(int value){
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			int num = entry.getKey();
			int y = value-num;
			if (y==num)	return entry.getValue()>1;
			else if(map.containsKey(y))	return true;
		}
		return false;
	}
}
