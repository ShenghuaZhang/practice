package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target){
		Map<Integer, Integer> map = new HashMap<>();
		int size = numbers.length;
		for(int i=0; i<size; i++){
			if (map.containsKey(target -numbers[i])) return new int[]{map.get(target-numbers[i])+1, i+1};
			else map.put(numbers[i], i);
		}
		return null;
	}
}
