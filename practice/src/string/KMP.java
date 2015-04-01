package string;

public class KMP {
	static int[] getPartialMatchTable(String s){
		int length = s.length();
		int[] table = new int[length];
		table[0] = 0;
		
		int start = 0, i = 1, previous=0;
		boolean flag = false;
		while(i<length){
			if(s.charAt(start) == s.charAt(i)){
				table[i] = previous+1;
				previous = table[i];
				start++;
				i++;
				flag=false;
			}else{
				previous = 0;
				if(start+1 == i){
					table[i] = 0;	
					start=0;
					i++;
					flag=false;
				}else if(!flag){
					previous = 0;
					start=0;
					flag = true;
				}else{
					previous = 0;
					start++;
				}
			}
		}
		return table;
	}
	
	static int[] getNext(String s){
		int[] table = new int[s.length()];
		table = getPartialMatchTable(s);

		for(int i=table.length-1; i>0; i--)
			table[i] = table[i-1];
		table[0] = -1;
		return table;
	}
	
	static boolean kmp(String target, String s){
		if(target.length()<s.length())	return false;
		int[] next = getNext(s);
		
		int i=0, j=0;
		while(i<target.length() && j<s.length()){
			if(j==-1 || target.charAt(i)==s.charAt(j)){
				i++;
				j++;
			}else	j = next[j];
		}
		
		if(j==s.length())	return true;
		else return false;
	}
	
	public static void main(String[] args){
		System.out.println(kmp("ababsabs", "xabs"));
	}
}
