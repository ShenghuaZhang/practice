package test;

public class TestStringIsANormalType {
	public static void main(String[] args){
		/** about new String*/
		String s = new String("Hello ");
		String s1 = new String("Hello ");
		String s2 = "Hello ";
		String s3 = "Hello ";
		System.out.println(s==s1);
		System.out.println(s==s2);
		System.out.println(s2==s3);
		
		/** about s is same as primitive*/
		System.out.println("s: " + s);
		changeString(s);
		System.out.println("After replace s: " + s);
		
		/** about other objects*/
		StringBuffer sb = new StringBuffer("Hello ");
		System.out.println("sb: " + sb);
		changeStringBuffer(sb);
		System.out.println("After append sb: " + sb);
	}
	private static void changeStringBuffer(StringBuffer sb){
		StringBuffer sb2 = new StringBuffer("Hi");
		sb = sb2;
		sb2.append("World!");
	}
	private static void changeString(String s){
		s.replace('e', 'f');
	}
}
