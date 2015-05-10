package math;

import java.util.ArrayList;
import java.util.List;

/**
 * 12
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 0.	N: 5000 M: 1000 D: 500 C: 100 L: 50 X: 10 V:5 I:1
 * 1.	V, L, and D cannot be repeated.
 * 2.	I, X, C, and M can be repeated up to 3 times.
 * 3.	9 will write as IX instead of VIV or VIIII
 * 
 * @author carllee1991
 * #RomanToInteger
 */
public class IntegerToRoman {
	public static String intToRoman(int num){
		if(num<1 || num>3999)
	        return "";
	    int digit = 1000;
	    List<Integer> digits = new ArrayList<>();
	    while(digit>0)
	    {
	        digits.add(num/digit);
	        num %= digit;
	        digit /= 10;
	    }
	    StringBuilder res = new StringBuilder();
	    res.append(convert(digits.get(0),'M',' ', ' '));
	    res.append(convert(digits.get(1),'C','D', 'M'));
	    res.append(convert(digits.get(2),'X','L', 'C'));
	    res.append(convert(digits.get(3),'I','V', 'X'));
	    return res.toString();
	}
	static String convert(int digit, char one, char five, char ten)
	{
	    StringBuilder res = new StringBuilder();
	    switch(digit)
	    {
	        case 9:
	            res.append(one);
	            res.append(ten);
	            break;
	        case 8:
	        case 7:
	        case 6:
	        case 5:
	            res.append(five);
	            for(int i=5;i<digit;i++)
	                res.append(one);
	            break;
	        case 4:
	            res.append(one);
	            res.append(five);
	            break;   
	        case 3:
	        case 2:
	        case 1:
	            for(int i=0;i<digit;i++)
	                res.append(one);
	            break;   
	        default:
	            break;
	    }
	    return res.toString();
	}
}
