package array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/ 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * @author yili3
 *
 */

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows){
		List<List<Integer>> list = new ArrayList<>();
		if(numRows==0)	return list;
		for(int row=1; row<=numRows; row++){
			List<Integer> curList = new ArrayList<>();
			for(int column=1; column<=row; column++){
				if(row==1 || column==1 || row==column)	curList.add(1);
				else curList.add(list.get(row-2).get(column-2)+list.get(row-2).get(column-1));
			}
			list.add(curList);
		}
		return list;
	}
	
	public static void main(String[] args){
		System.out.print(generate(3));
	}
}
