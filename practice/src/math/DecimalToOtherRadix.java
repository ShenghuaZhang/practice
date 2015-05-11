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
		System.out.println(x+" to "+sb.toString());
		return sb.toString();
	}
	private char trans(int digit){
		if(digit<10)	return (char)('0'+digit);
		return (char)(digit+'a'-10); // Character.toChars(digit+'a'-10);
	}
	
	public static void main(String[] args){
		new DecimalToOtherRadix(26).change(25);
	}
}
