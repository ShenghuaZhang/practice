package string;

import java.util.Arrays;

public class KMP{
	private String pattern;
	private int[] next, nfa, dfa;

	public void getDFA(String pattern){
		dfa = new int[pattern.length()];
		
		int i = 0, j = 0;
		while(j < pattern.length()){
			if(j == 0)	dfa[j++] = 0;
			else if(pattern.charAt(i) == pattern.charAt(j))
				dfa[j++] = ++i;
			else if(i==0)	dfa[j++] = 0;
			else	i = dfa[i-1]; 
		}

		System.out.println("dfa: "+Arrays.toString(dfa));
	}
	
	public void getNFA(String pattern){
		nfa = new int[pattern.length()];
		
		int i=-1, j=0;
		while(j<pattern.length()-1){
			if(j==0)	nfa[j] = -1;
			if(i==-1 || pattern.charAt(i)==pattern.charAt(j))
				nfa[++j] = ++i;
			else i = nfa[i];
		}
		
		System.out.println("nfa: "+Arrays.toString(nfa));
	}
	
	public void getNext(String pattern){
		next = new int[pattern.length()];
		
		int i=-1, j=0;
		while(j < pattern.length()-1){
			if(j==0) next[j] = -1;
			if(i==-1 || pattern.charAt(i)==pattern.charAt(j)){
				if(pattern.charAt(++i)!=pattern.charAt(++j))
					next[j] = i;
				else next[j] = next[i];
			}
			else i = next[i];
		}
		
		System.out.println("next: "+Arrays.toString(next));
	}
	
	public KMP(String pattern) {
		this.pattern = pattern;
		getDFA(pattern);
		getNFA(pattern);
		getNext(pattern);
	}

	
	// return offset of first occurrence of text in pattern (or N if no match)
	// simulate the NFA to find match
	public int search(String text) {
		int M = pattern.length();
		int N = text.length();
		int i, j;
		for (i = 0, j = 0; i < N && j < M; i++, j++) {
			while (j >= 0 && text.charAt(i) != pattern.charAt(j))
				j = next[j];
		}
		if (j == M)
			return i - M;
		return N;
	}

	// test client
	public static void main(String[] args) {
		String pattern = "aabaaaba", 
				text = "ababaabaaabaaaabab";;
		// substring search
		KMP kmp = new KMP(pattern);
		int offset = kmp.search(text);
		kmp.getNext("ababab");
		System.out.println("text:    " + text);
		System.out.print("pattern: ");
		for (int i = 0; i < offset; i++)
			System.out.print(" ");
		System.out.println(pattern);
	}
}
