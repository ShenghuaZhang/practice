package string;

public class Test {
	public static void main(String[] args){
		String s = new String("Hello ");
		System.out.print("String: " + s);
		changeString(s);
		System.out.print(", " + s);
		
		StringBuffer sb = new StringBuffer("Hello ");
		System.out.print("\nString Buffer: " + sb);
		changeStringBuffer(sb);
		System.out.print(", " + sb);
	}
	private static void changeStringBuffer(StringBuffer sb){
		sb.append("World!");
	}
	private static void changeString(String s){
		s.replace('e', 'f');
	}
}
