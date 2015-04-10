package math;
/**
 * https://leetcode.com/problems/add-binary/
 * 
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * @author carllee1991
 *
 */
public class AddBinary {
	public static String addBinary(String a, String b){
		int rest = 0, i=a.length()-1, j=b.length()-1;
        StringBuilder sb = new StringBuilder();
        
        for(; i>=0&&j>=0; i--,j--){
            if(a.charAt(i)==b.charAt(j)){
                sb.append(rest);
                rest = Integer.parseInt(a.substring(i, i+1));
            }
            else sb.append((rest==0)?1:0);
        }
        while(i>=0){
        	if(rest==0)	sb.append(a.charAt(i--));
        	else if(a.charAt(i--)=='0'){
        		rest = 0;
        		sb.append('1');
        	}else	sb.append('0');
        }
        while(j>=0){
        	if(rest==0)	sb.append(b.charAt(j--));
        	else if(b.charAt(j--)=='0'){
        		rest = 0;
        		sb.append('1');
        	}else	sb.append('0');
        }
        if(rest==1)	sb.append('1');
        
        return sb.reverse().toString();
	}
	
	public static void main(String[] args){
		String a = "11", b = "1";
		System.out.println(addBinary(a, b));
	}
}
