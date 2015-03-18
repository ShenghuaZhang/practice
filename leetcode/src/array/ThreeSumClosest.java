package array;

import java.util.Arrays;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] num, int target){
		Arrays.sort(num);
		int closest = Integer.MAX_VALUE, rs=0;
		
		for(int i=0; i<num.length; i++){
			int start=i+1, end=num.length-1;
			while(start<end){
				int sum = num[i]+num[start]+num[end];
				if(Math.abs(closest)>Math.abs(target-sum)){
					closest = target-sum;
					rs = sum;
				}
				if(sum>target) end--;
				else if(sum<target)	start++;
				else return sum;
			}
		}
		
		return rs;
	}
	
	public static void main(String[] args){
		int[] num = {-1, 2, 1, 4};
		System.out.print(threeSumClosest(num, 1));
	}
}
