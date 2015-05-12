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
	final static int binary = 2;
	int radix;
	
	public DecimalToOtherRadix(){
		this(binary);
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
		System.out.println(x+" to "+sb.toString()+" checkNum: "+checkNum);
		assert(checkNum==x):"Not same!";
		System.out.println("Nice convert!");
		return sb.toString();
	}
	
	/* helper functions */
	private int check(String radixNum){ //#ExcelSheetColumnNumber
		int result = 0;
		for(char c:radixNum.toCharArray())
			result = result*radix + retrans(c);
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
