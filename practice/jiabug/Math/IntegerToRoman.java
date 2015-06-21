package Math;

import java.util.ArrayList;

/**
 * 12
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * 
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author kajia
 * 
 * http://blog.csdn.net/linhuanmars/article/details/21145639
 * #RomanToInteger
 */


public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(1800));

	}
	//the basic digit is 1, 5, 10. The bigger number is 10 or 100 ...  times of these basic digits.
	//I 1  
    //V 5  
    //X 10  
    //L 50  
    //C 100  
    //D 500  
    //M 1,000
    public static String intToRoman(int num) {
    	if (num < 1 || num > 3999) {
    		return null;
    	}
    	
    	ArrayList<Integer> digits = new ArrayList<Integer>();
    	
    	int digit = 1000;
    	while (digit > 0) {
    		digits.add(num / digit);
    		num %= digit;
    		digit /= 10;
    	}
    	
    	StringBuilder res = new StringBuilder();
    	
    	res.append(convert(digits.get(0), 'M', ' ', ' '));
    	res.append(convert(digits.get(1), 'C', 'D', 'M'));
    	res.append(convert(digits.get(2), 'X', 'L', 'C'));
        res.append(convert(digits.get(3), 'I', 'V', 'X'));
        
        return res.toString();
    }
    
    public static String convert(int digit, char one, char five, char ten) {
    	StringBuilder res = new StringBuilder();
    	switch(digit) {
    	case 1:
    	case 2:
    	case 3: 
    	    for (int i = 0; i < digit; i++) {
    	    	res.append(one);
    	    }
    		break;
    	case 4:
    		res.append(one);
    		res.append(five);
    		break;
    	case 5:
    		res.append(five);
    		break;
    	case 6:
    	case 7:
    	case 8:
    		res.append(five);
    		for (int j = 0; j < (digit - 5); j++) {
    			res.append(one);
    		}
    		break;
    	case 9:
    		res.append(one);
    		res.append(ten);
    		break;
    	default:
    		break;
    	}
    	return res.toString();
    }

}
