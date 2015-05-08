package hash;
/**
 * 202
 * https://leetcode.com/problems/happy-number/
 * 
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process:
 * Starting with any positive integer,
 * replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while(sum!=1){
            sum = 0;
            while(n!=0){
                int temp = n%10;
                sum += temp*temp;
                n/=10;
            }
            if(!set.contains(sum))	set.add(sum);
            else return false;
            n = sum;
        }
        return true;
    }
}
