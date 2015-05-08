package dynamicProgramming;

public class DecodeWays {
	public static int numDecodings(String s){
		if(s==null || s.length()==0 || s.charAt(0)=='0') return 0;
		int num1 = 1, num2 =1, rs = 1;
		for(int i=1; i<s.length(); i++){
			if(s.charAt(i) == '0')
				if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2')	rs = num2;
				else return 0;
			else if(s.charAt(i)>'0' && s.charAt(i)<'7' && s.charAt(i-1)=='2')	rs=num1+num2;
			else if(s.charAt(i)>='0' && s.charAt(i)<='9' && s.charAt(i-1)=='1')	rs=num1+num2;
			num2 = num1;
			num1 = rs;
		}
		return rs;
	}
	
	public static void main(String[] args){
		System.out.print(numDecodings("12120"));
	}
}
