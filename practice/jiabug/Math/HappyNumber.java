package Math;

import java.util.ArrayList;

/**
 * 202
 * https://leetcode.com/problems/happy-number/
 * 
 * Write an algorithm to determine if a number is "happy".
 * 
 * @author jiakangze
 *
 */

public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
	
	
    public static boolean isHappy(int n) {
    	if (n <= 0) {
    		return false;
    	}
    	
    	ArrayList<Integer> dup = new ArrayList<Integer>();
    	while (true) {
    		int happy = 0;
    		while (n > 0) {
    			happy += (n % 10) * (n % 10);
    			n /= 10;
    		}
    		if (dup.contains(happy)) { 
    			return false;
    		} else {
    			dup.add(happy);
    		}
    		n = happy;
    		if (happy == 1) {
    			return true;
    		}
    		
    	}
    }

}
