package twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static int[] twoSum(int[] numbers, int target){
		Map<Integer, Integer>map = new HashMap<>();
		for (int i=0; i < numbers.length; i++){
			if (map.containsKey(target-numbers[i]))
				return new int[] {map.get(target-numbers[i])+1, i+1};
			map.put(numbers[i], i);
		}
		throw new IllegalArgumentException("No two sum solution.");
	}
	public static void main(String[] args){
		int[] numbers = {12, 23, 23, 1, 2, 3, 4, 5}, result;
		int target = 13;
		result = twoSum(numbers, target);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	 }
}
