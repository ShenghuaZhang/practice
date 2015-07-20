package string;

import java.util.ArrayList;

/**
 * 165
 * https://leetcode.com/problems/compare-version-numbers/
 * 
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author kajia
 *
 */

public class CompareVersionNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int compareVersion_my(String version1, String version2) {
    	int i = 0;
    	int j = 0;
    	int l1 = version1.length();
    	int l2 = version2.length();

    	while (i < l1 && j < l2) {
        	int num1 = 0;
        	int num2 = 0;
        	
    		while (i < l1 && Character.isDigit(version1.charAt(i))) {
    			num1 = num1 * 10 + version1.charAt(i) - '0' - 0;
    			i++;
    		}
    		while (j < l2 && Character.isDigit(version2.charAt(j))) {
    			num2 = num2 * 10 + version2.charAt(j) - '0' - 0;
    			j++;
    		}
    		
    		if (num1 > num2) {
    			return 1;
    		} else if (num1 < num2) {
    			return -1;
    		} else {
    			i++;
    			j++;
    			continue;
    		}
    	}
    	
    	while (i < l1) {
    		if (version1.charAt(i) == '0' || version1.charAt(i) == '.') {
    			i++;
    		} else {
    			return 1;
    		}
    	}
    	while (j < l2) {
    		if (version2.charAt(j) == '0' || version2.charAt(j) == '.') {
    			j++;
    		} else {
    			return -1;
    		}
    	}
    	return 0;
    }
    
    public static int compareVersion_yi(String version1, String version2) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (String s: version1.split("\\.")) {
        	list1.add(Integer.valueOf(s));
        }
        for (String s: version2.split("\\.")) {
        	list2.add(Integer.valueOf(s));
        }
        if (list1.size() == 0) {
        	list1.add(Integer.valueOf(version1));
        }
        if (list2.size() == 0) {
        	list2.add(Integer.valueOf(version2));
        }
        
        int i = 0;
        for (; i < Math.min(list1.size(), list2.size()); i++) {
        	if (list1.get(i) > list2.get(i)) {
        		return 1;
        	}
        	if (list1.get(i) < list2.get(i)) {
        		return -1;
        	}
        }
        while (i < list1.size()) {
        	if (list1.get(i) > 0) {
        		return 1;
        	}
        	i++;
        }
        while (i < list2.size()) {
        	if (list2.get(i) > 0) {
        		return -1;
        	}
        	i++;
        }
        return 0;
    }
    
    
    public static int compareVersion_discuss(String version1, String version2) {
    	String [] s1 = version1.split("\\.");
    	String [] s2 = version2.split("\\.");
    	
    	for (int i = 0; i < Math.max(s1.length, s2.length); i++) {
    		int num1 = i < s1.length ? Integer.valueOf(s1[i]) : 0;
    		int num2 = i < s2.length ? Integer.valueOf(s2[i]) : 0;
    		
    		if (num1 > num2) {
    			return 1;
    		} 
    		if (num1 < num2) {
    			return -1;
    		}
    	}
    	return 0;
    }
        

}
