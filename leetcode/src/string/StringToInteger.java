package string;

public class StringToInteger {
	private static final int maxDiv10 = Integer.MAX_VALUE/10;
	
	public static int atoi(String str){	
		int n = str.length(), i = 0, sign = 1, result = 0;
		while(i<n && Character.isWhitespace(str.charAt(i))) i++;
		if(i<n && str.charAt(i) == '-'){
			i++;
			sign=-1;
		}else if(i<n && str.charAt(i) == '+') i++;
		
		while(i<n && Character.isDigit(str.charAt(i))){
			int digit = Character.getNumericValue(str.charAt(i));
			if(result>maxDiv10 || result==maxDiv10 && digit>=8)	
				return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
			result = result*10 + digit;
			i++;
		}
		return result*sign;
	}
	
	public static int atoiO(String str){	
		int n = str.length(), i = 0, sign = 1, result = 0;
		while(i<n && str.charAt(i)==' ') i++;
		if(i<n && str.charAt(i) == '-'){
			i++;
			sign=-1;
		}else if(i<n && str.charAt(i) == '+') i++;
		int maxDiv = 214748364;
		while(i<n && (str.charAt(i)>=48 && str.charAt(i)<=57)){
			int digit =str.charAt(i)-48;
			if(result>maxDiv || result==maxDiv && digit>=8)	
				return sign==1?2147483647:-2147483648;
			result = result*10 + digit;
			i++;
		}
		return result*sign;
	}
	
	public static void main(String[] args){
		int rs = atoi("1");
		System.out.print(rs);
	}
}
