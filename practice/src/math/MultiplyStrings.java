package math;
/**
 * TODO 43
 * 
 * Given two numbers represented as strings,
 * return multiplication of the numbers as a strign.
 * Note: The numbers can be arbitrarily large and
 * are non-negative.
 * 
 * @author carllee1991
 *
 */
public class MultiplyStrings {
	public static String multiply(String num1, String num2){
		String[] multiplyEachNum = new String[num2.length()];
		for(int i=0; i<num2.length(); i++)
			multiplyEachNum[i] = multiplyOneByOne(num1, num2.charAt(i));
		return addAll(multiplyEachNum);
	}
	private static String multiplyOneByOne(String num1, char c){
		StringBuilder sb = new StringBuilder();
		int digit = 0, ch = Character.digit(c, 10);
		for(int i=num1.length()-1; i>=0; i--){
			int first = Character.digit(num1.charAt(i), 10);
			int mul = first * ch + digit;
			sb.insert(0, mul%10);
			digit = mul/10;
		}
		
		return sb.toString();
	}
	private static String addAll(String[] ss){
		return addPart(ss, 0, ss.length-1);
	}
	private static String addPart(String[] ss, int left, int right){
		if(left==right)	return ss[left];
		String first = addPart(ss, left, (left+right)/2);
		String second = addPart(ss, (left+right)/2+1, right);
		return addTwo(first, second);
	}
	private static String addTwo(String first, String second){
		if(first.length()>second.length())	return addTwo(second, first);
		int digit = 0, i=first.length()-1, j=second.length()-1;
		StringBuilder sb = new StringBuilder();
		while(i>=0){
			int temp = Character.digit(first.charAt(i--),10) + Character.digit(second.charAt(j), 10) + digit;
			sb.insert(0, temp%10+'0');
			if(temp>9)	digit = 1;
			else digit = 0;
		}
		while(j>=0){
			int temp = Character.digit(second.charAt(j), 10) + digit;
			sb.insert(0, temp%10+'0');
			if(temp>9)	digit = 1;
			else digit = 0;
		}
		if(digit==1) sb.insert(0, 1+'0');
		
		return sb.toString();
	}
	
	public static void main(String[] args){
		System.out.println(multiply("8791743912739","9911999999"));
	}
}
