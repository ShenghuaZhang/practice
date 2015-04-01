package string;

import java.util.Arrays;

public class KMP {
	private String pattern;
	private int[] table;
	
	public KMP(String s){
		this.pattern = s;

		int length = pattern.length();
		table = new int[length];
		
		int pre = 0, suffix = 0, value=0;
		boolean fromBegin = true;
		while(suffix < length){
			if(suffix == 0)	table[suffix++] = 0;
			if(pattern.charAt(pre) == pattern.charAt(suffix)){
				table[suffix++] = ++value;
				pre++;
				fromBegin=false;
			}else{
				value = 0;
				if(pre+1 == suffix){
					table[suffix++] = 0;	
					pre=0;
				}else if(!fromBegin){
					pre=0;
					fromBegin = true;
				}else	pre++;
			}
		}
		
		System.out.println(Arrays.toString(table));
		
		for(int i=table.length-1; i>=0; i--)
			table[i] = (i==0)?-1:table[i-1];
		
		System.out.println(Arrays.toString(table));
	}
	
	public KMP(String s, Boolean x) {
		this.pattern = s;
		
		int length = pattern.length();
		table = new int[length];
		
		int pre = -1, suffix = 0;
		for (; suffix < length; suffix++) {
			if (suffix == 0)	table[suffix] = -1;
			else if (pattern.charAt(suffix) != pattern.charAt(pre))
				table[suffix] = pre;
			else
				table[suffix] = table[pre];
			while (pre >= 0 && pattern.charAt(suffix) != pattern.charAt(pre))
				pre = table[pre];
			pre++;
		}

		System.out.println(Arrays.toString(table));
	}
	
	static boolean kmp(String text, String pattern){
		if(text.length()<pattern.length())	return false;
		KMP kmp = new KMP(pattern);
		
		int i=0, j=0;
		while(i<text.length() && j<pattern.length()){
			if(j==-1 || text.charAt(i)==pattern.charAt(j)){
				i++;
				j++;
			}else	j = kmp.table[j];
		}
		
		if(j==pattern.length())	return true;
		return false;
	}
	
	public static void main(String[] args){
		System.out.println(kmp("dabcabdabcxxxaabaaabaxasdfsaf", "aabaaaba"));
	}
}
