package dynamicProgramming;

public class Fibonacci {
	public static int recursive(int n) {
        int f0 = 1, f1 = 1, f2 =2;
        if(n<= 0)   return 0;
        if(n==1)    return 1;
        for(int i=2; i<=n; i++){
            f2 = f0+f1;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
	
	public static int dp(int n) {
        if(n==1)    return 1;
        if(n==0)    return 1;
        return dp(n-1)+dp(n-2);
    }
	
	public static int matrix(int n){
		return 0;
	}
	
	public static void main(String[] args){
		System.out.println(matrix(44));
	}
}
