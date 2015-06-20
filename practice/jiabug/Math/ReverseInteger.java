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
		System.out.println("i:" + i);
		
		int max = Integer.MAX_VALUE;
		System.out.println("max: " + max);
		
		int max_1 = Integer.MAX_VALUE + 1;
		int max_2 = max_1 - 1;
		System.out.println("max + 1: " + max_1);
		System.out.println("max + 1 - 1:" + max_2);
		
		int min_1 = Integer.MIN_VALUE - 1;
		int min_2 = min_1 + 1;
		
		System.out.println("min + 1: " + min_1);
		System.out.println("min - 1 + 1: " + min_2);
		
		int raw = 746384741;//2147483637;
		int newresult = raw * 10 + 2;
		System.out.println("2147483637 + 2147483637: " + (2147483637 + 2147483637));
		System.out.println("raw * 10: " + raw * 10);
		System.out.println("newresult:" + newresult);
		System.out.println("reverse raw : " + (newresult - 2) / 10);//this is different with old raw
		
		
		
		

	}
	public static int reverse(int x) {
		long res = 0;
		while (x != 0) {  //we can not use x > 0, because we should consider  negative number
			res = res * 10 + x % 10;
			x = x / 10;
		}
		
		if(res > Integer.MAX_VALUE || res <Integer.MIN_VALUE) {
			return 0;
		}
		return (int)res;
	}
	
	public static int reverse_yi(int x){
		int ret=0;
		while(x!=0){
			if(Math.abs(ret)>Integer.MAX_VALUE/10)	return 0;//we do not need to add x%10, because x itself will overflow
			ret = ret*10+x%10;
			//if we add the estimate at here, we need define the ret as long. 
			x /= 10;
		}
		return ret;
	}
	
	public static int reverse_discuss(int x) {
        int result = 0;

	    while (x != 0)
	    {
	        int tail = x % 10;
	        int newResult = result * 10 + tail;
	        //the value of newResult plus tail then minus tail, so tail does not make any difference, even if result*10 overflows
	        //so we just need to focus on result*10. if this term overflows, we can get it back through dividing 10. 
	        //because dividing 10 just let the number become smaller, can not make it overflow again.
	        //if the result is 214748364, then it is multiplied 10. then if we add 8 it will overflow. but in this 
	        //situation, x itself will overflow. it will not add a number beyond 2.
	        if ((newResult - tail) / 10 != result) { //why??
	        	return 0; 
	        }
	        result = newResult;
	        x = x / 10;
	    }
	
	    return result;
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
