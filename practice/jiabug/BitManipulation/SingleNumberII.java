package BitManipulation;

/**
 * 137
 * https://leetcode.com/problems/single-number-ii/
 * 
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * @author jiakangze
 *
 * #SingleNumber
 */


public class SingleNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return -1;
        }
        
        int[] digits  = new int[32];
        
        for (int i = 0; i < 32; i++) {
        	for (int j = 0; j < nums.length; j++) {
        		digits[i] += (nums[j] >> i) & 1;
        	}
        }
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
        	int temp = digits[i] % 3;
        	if (temp == 2 || temp == 1) {
        		res |= (1 << i);
        	}
        }
        return res;
    }

}
