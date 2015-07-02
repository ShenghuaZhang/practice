package BitManipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * 136
 * https://leetcode.com/problems/single-number/
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * @author jiakangze
 *
 */

public class SingleNumber {

	public static void main(String[] args) {
		
		int [] nums = new int[]{-1};
		System.out.println(singleNumberCommon(nums));
	}
    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	res ^= nums[i];
        }
        return res;
    }
    
    public static int singleNumberCommon (int[] nums) {
    	int[] digits = new int[32];
    	
    	for (int i = 0; i < 32; i++) {
    		for (int j = 0; j < nums.length; j++) {
    			digits[i] += ((nums[j]>>>i) & 1);
    		}
    	}
    	int res = 0;
    	for (int i = 0; i < 32; i++){
    		res |= (digits[i]%2) << i;
    		
    	}
    	return res;
    }
    
    public static int singleNumberSet(int[] A){
		Set<Integer> set = new HashSet<>();
		for(int i:A){
			if(set.contains(i))	set.remove(i);
			else set.add(i);
		}
		return set.iterator().next();
	}
    
    public static int singleNumber_bad(int[] nums) {
    	//[17,12,5,-6,12,4,17,-5,2,-3,2,4,5,16,-3,-4,15,15,-4,-5,-6] this will output 15 not the right answer 16.
    	//the right result is ahead of 15, and 15 does not show before the 16. so this leads wrong result.
    	Set<Integer> set = new HashSet<Integer>();
    	int res = 0;
    	for (int i:nums) {
    		if (set.contains(i)) {
    			continue;
    		}
    		res = i;
    		set.add(i);
    	}
    	return res;
    }

}
