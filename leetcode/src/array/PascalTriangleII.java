package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	public static List<Integer> getRow(int rowIndex){
		List<Integer> list = new ArrayList<>();
		
		if(rowIndex<0) return list;
		for(int row=1; row<=rowIndex+1; row++){
			int previous=-1;
			for(int column=1; column<=row; column++){
				if(row==column)	list.add(1);
				else if(row==1||column==1){
					previous = 1;
					list.set(column-1, 1);
				}else{
					int temp = list.get(column-1);
					list.set(column-1, previous+list.get(column-1));
					previous = temp;
				}
			}
		}
		
		return list;
	}
	
	public static void main(String[] args){
		System.out.print(getRow(3));
	}
	
}
