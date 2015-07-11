package Math;

import java.util.ArrayList;
import java.util.HashSet;

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
    
    public static boolean isHappy_good(int n) {
    	HashSet<Integer> set = new HashSet<Integer>();
        while (n != 1) {
    	    int number = 0;
    	    while (n > 0) {
    	    	number += (n%10) * (n%10);
    	    	n /= 10;
    	    }
    	    if (!set.add(number) && number != 1) {
    	    	return false;
    	    }
    	    n = number;
        }
        return true;
    }
}
