package google;

public class CalculateTarget{
	public static boolean calculate(int[] num, int target){
		for(int i=0; i<num.length; i++){
			if(helper(num, target, i, 0))	return true;
		}
		return false;
	}
	private static boolean helper(int[] num, int target, int index, int current){
		if(current == target)	return true;
		for(int i=index; i<num.length; i++){
			if(helper(num, index+1, target, current+num[index]))	return true;
			if(helper(num, index+1, target, current-num[index]))	return true;
			if(helper(num, index+1, target, num[index]-current))	return true;
			if(helper(num, index+1, target, current * num[index]))	return true;
			if(num[index]!=0 && helper(num, index+1, target, current / num[index]))	return true;
			if(target!=0 && helper(num, index+1, target, num[index] / current))	return true;
		}
		return current==target;
	}
	
	public static void main(String[] args){
		int[] num = {1, 2, 4};
		System.out.println(calculate(num, 5));
	}
}
