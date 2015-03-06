package binarySearch;

public class FindMinimumInRotatedSortedArray {
	public static int findMin(int[] num) {
		int left = 0, right = num.length - 1, middle = (left + right) / 2;
		for (; left <= right; middle = (left + right) / 2) {
			if (num[left] <= num[right])	return num[left];
			else if(num[left]>num[middle])	right=middle;
			else	left=middle+1;
		}
		return -1;
	}
	
	//with duplicates
	public static int findMinWithDuplicates(int[] num){
		int left = 0, right = num.length - 1, middle = (left + right) / 2;
		for (; left<right && num[left]>=num[right]; middle = (left + right) / 2) {
			if(num[left]>num[middle])	right=middle;
			else if(num[left]<num[middle])	left=middle+1;
			else	left++;
		}
		return num[left];
	}
	
	public static void main(String[] args){
		int[] test0 = {3,1,2};
		System.out.println(findMin(test0));
		int[] test1 = {1,0,0,0,0,1,1,1,1};
		System.out.println(findMinWithDuplicates(test1));
	}
}
