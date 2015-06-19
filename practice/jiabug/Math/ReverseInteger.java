package Math;

/**
 * 7
 * https://leetcode.com/problems/reverse-integer/
 * 
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * @author kajia
 *
 */

public class ReverseInteger {

	public static void main(String[] args) {
		long i = 101;//101 is int, but i is long. the = converts the int to long type. 
		              //so if the value does not beyond the range, we may not add l or L int the end
		System.out.print(i);
		// TODO Auto-generated method stub

	}
	public static int reverse(int x) {
		long res = 0;
		while (x != 0) {  //we can not use x > 0, because we should consider  negative number
			res = res * 10 + x%10;
			x = x / 10;
		}
		
		if(res > Integer.MAX_VALUE || res <Integer.MIN_VALUE) {
			return 0;
		}
		return (int)res;
	}
	/*x doesn't overflow. but its reverse overflow. 
    Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows.
	so the above method already overflows in parseInt.
	*/
	public int reverseBad(int x) {
        String s = Integer.toString(x);
        char [] arr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        char temp;

        if (x < 0){
            i++;
        }
        while (i < j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return Integer.parseInt(new String(arr));
    }

}
