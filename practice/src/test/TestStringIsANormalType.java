package test;

public class TestStringIsANormalType {
	public static void main(String[] args){
		
		String s = new String("Hello ");
		String s1 = "HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello";
		String s2 = "HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello";
		System.out.println(s==s1);
		System.out.println(s1==s2);
		System.out.println("s: " + s);
		changeString(s);
		System.out.println("After replace s: " + s);
		
		StringBuffer sb = new StringBuffer("Hello ");
		System.out.println("sb: " + sb);
		changeStringBuffer(sb);
		System.out.println("After append sb: " + sb);
	}
	private static void changeStringBuffer(StringBuffer sb){
		sb.append("World!");
	}
	private static void changeString(String s){
		s.replace('e', 'f');
	}
}
