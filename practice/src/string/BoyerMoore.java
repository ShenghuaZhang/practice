package string;
/**
 * http://algs4.cs.princeton.edu/53substring/BoyerMoore.java.html
 * @author yili3
 *
 */
public class BoyerMoore {
	private int[] right = new int[256];
	private String pattern;
	
	
	// the bad-character skip
	public BoyerMoore(String pattern){
		this.pattern= pattern;
		
		for(int i=0; i<256; i++)	right[i] = -1;
		for(int i=0; i<pattern.length(); i++)	right[pattern.charAt(i)]=i;
	}
	
	public int search(String text){
		int M = pattern.length();
		int N = text.length();
		int skip;
		for(int i=0; i<=N-M; i+=skip){
			skip=0;
			for(int j=M-1; j>=0; j--){
				if(text.charAt(i+j)!=pattern.charAt(j)){
					skip=Math.max(j-right[pattern.charAt(j)], 1);
					break;
				}
			}
			if(skip==0) return i;	//found
		}
		return N;					//not found
	}
	
	public static void main(String[] args){
		String pattern = "ababaaa";
		String text = "babaaabaababaaabaabbbabaa";
		
		BoyerMoore bm = new BoyerMoore(pattern);
		int offset = bm.search(text);
		
		System.out.println("text:    " + text);

		System.out.print("pattern: ");
        for (int i = 0; i < offset; i++)
        	System.out.print(" ");
        System.out.println(pattern);
	}
}
