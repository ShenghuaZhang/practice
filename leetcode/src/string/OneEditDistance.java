package string;
/**
 * 161
 * https://leetcode.com/problems/one-edit-distance/
 * 
 * Given two strings S and T, determine if they are both one edit distance apart.
 * 
 * @author yili3
 *
 */
public class OneEditDistance {
	public static boolean isOneEditDistance(String s, String t){
		int m = s.length(), n = t.length();
		if(m>n) return isOneEditDistance(t, s);
		if(n-m>1) return false;
		int i=0, shift = n-m;
		while(i<m && s.charAt(i)==t.charAt(i))	i++;
		if(i==m)	return shift>0;
		if(shift==0) i++;
		while(i<m && s.charAt(i)==t.charAt(i+shift)) i++;
		return i==m;
	}
	
	
	// Dynamic programming algorithm
	public static boolean isOneEditDistanceDP(String s, String t){
		int m=s.length(), n=t.length();
		int[][] d = new int[m+1][n+1];
		for(int i=0; i<m; i++)	d[i][0] = i;
		for(int i=0; i<n; i++)	d[0][i] = i;
		
		for(int j=0; j<n; j++){
			for(int i=0; i<m; i++){
				if(s.charAt(i)==t.charAt(j))	d[i+1][j+1] = d[i][j];
				else	d[i+1][j+1] = Math.min(d[i][j+1]+1, Math.min(d[i+1][j]+1, d[i][j]+1));
			}
		}
		return d[m][n]==1;
	}
	
	public static void main(String[] args){
		System.out.print(isOneEditDistanceDP("kitten", "sitten"));
	}
}
