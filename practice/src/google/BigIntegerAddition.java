package google;

import java.util.Arrays;

/**
 * Two big integer addition
 * using array to stand big integer
 * 
 * #PlusOne #AddBinary
 * 
 * @author carllee1991
 *
 */
public class BigIntegerAddition {
	public static int[] bigIntAdd(int[] first, int[] second){
		if(first.length>second.length)	return bigIntAdd(second, first);
		int digit = 0, i=first.length-1, j=second.length-1;
		while(i>=0){
			int temp = first[i--] + second[j] + digit;
			second[j--] = temp%10;
			if(temp>9)	digit = 1;
			else digit = 0;
		}
		if(j<=0)	return second;
		while(j>=0){
			int temp = second[j] + digit;
			second[j--] = temp%10;
			if(temp>9)	digit = 1;
			else return second;
		}
		int[] result = new int[second.length+1];
		i = 0;
		result[i++] = 1;
		for(; i<result.length; i++)	result[i] = second[i-1];
		
		return result;
	}
	public static void main(String[] args){
		int[] first = {4,9,8,4,5,6,7};
		int[] second = {1,2,9,9,9,9,9,9};
		System.out.println(Arrays.toString(bigIntAdd(first, second)));
		System.out.println(4984567+12999999);
	}
}
