package string;


public class KMP {
	private String pattern;
	private int[] next;
	
	public KMP(String pattern) {
		this.pattern = pattern;
		getNext(pattern);
	}
	
	public void getNext(String pattern) {
		next = new int[pattern.length()];
		if (pattern.length() > 0) {
			next[0] = -1;
		}
		
		int j = 0;
		int k = -1;
		
		while (j < pattern.length()-1) {
			if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
				k++;
				j++;
				if (pattern.charAt(j) == pattern.charAt(k)) {
					next[j] = next[k];
				} else {
					next[j] = k;
				}
			} else {
				k = next[k];
			}
		}
	}
	
	public int search(String text) {
		int i = 0;
		int j = 0;
		int iLen = pattern.length();
		int jLen = text.length();
		
		while (i < iLen && j < jLen) {
			if (i == -1 || pattern.charAt(i) == text.charAt(j)) {
				i++;
				j++;
			} else {
				i = next[i];
			}
		}
		if (i == iLen) {
			return j - i;
		} else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		String pattern = "iss", 
				text = "mississippi";;
		// substring search
		KMP kmp = new KMP(pattern);
		int offset = kmp.search(text);
		System.out.println("text:    " + text);
		System.out.print("pattern: ");
		for (int i = 0; i < offset; i++)
			System.out.print(" ");
		System.out.println(pattern);
	}

}
