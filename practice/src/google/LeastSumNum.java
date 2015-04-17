package google;

import java.util.ArrayList;
import java.util.List;

/**
 * 18. least sum number
 * @author carllee1991
 *
 */
public class LeastSumNum {
	public static List<List<Integer>> leastSum(int num){
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> perfectNum = new ArrayList<>();
		
		for(int i=1; i<=num; i++){
			if(i*i==num){
				List<Integer> curList = new ArrayList<>();
				curList.add(num);
				list.add(curList);
				return list;
			}
			if(i*i < num)	perfectNum.add(0, i*i);
			else	break;
		}
		List<Integer> current = new ArrayList<>();
		helper(num, perfectNum, 0, list, current);
		
		return list;
	}
	private static void helper(int num, List<Integer> perfectNum, int index, List<List<Integer>> list, List<Integer> current){
		if(num==0){
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(current);
			if(list.size()==0)	list.add(temp);
			else if(list.get(0).size()==temp.size()) list.add(temp);
			else if(list.get(0).size()<temp.size()){
				list.clear();
				list.add(temp);
			}
			return;
		}else if(num<0){
			return;
		}
		for(int i= index; i<perfectNum.size(); i++){
			current.add(perfectNum.get(i));
			helper(num-perfectNum.get(i), perfectNum, i+1, list, current);
			current.remove(perfectNum.get(i));
		}
	}
	
	public static void main(String[] args){
		List<List<Integer>> list = leastSum(14);
		for(int i=0; i<list.size(); i++)	System.out.println(list.get(i));
	}
}

