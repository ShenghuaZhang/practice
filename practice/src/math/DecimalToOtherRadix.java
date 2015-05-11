package math;
/**
 * Decimal to 26
 * The same function in Java Liabrary: Character.forDigit(int digit, int radix);
 * #Character
 * 
 * @author carllee1991
 *
 */
public class DecimalToOtherRadix {
	int radix;
	
	public DecimalToOtherRadix(){
		this(2);
	}
	public DecimalToOtherRadix(int radix){
		this.radix = radix;
	}
	
	public String change(int x){
		int temp = x;
		StringBuilder sb = new StringBuilder();
		while(temp!=0){
			int digit = temp%radix;
			// Character.forDigit(digit, 10);
			sb.insert(0, trans(digit));
			temp /= radix;
		}
		
		int checkNum = check(sb.toString());
//		System.out.println(x+" to "+sb.toString()+" checkNum: "+checkNum);
		assert(checkNum==x):"Not same";
		System.out.println("Good convert!");
		return sb.toString();
	}
	
	/* helper functions */
	private int check(String radixNum){
		int result = 0;
		for(int i=radixNum.length()-1, multi = 1; i>=0; i--){
			result += multi * retrans(radixNum.charAt(i));
			multi *= radix;
		}
		return result;
	}
	private int retrans(char c){
		if(Character.isDigit(c))	return Character.digit(c, 10);
		return c+10-'a';
	}
	private char trans(int digit){
		if(digit<10)	return (char)('0'+digit);
		return (char)(digit+'a'-10); // Character.toChars(digit+'a'-10);
	}
	
	public static void main(String[] args){
		new DecimalToOtherRadix(26).change(125);
	}
}
