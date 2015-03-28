package math;

public class Pow {
	static double pow(double x, int n){
		if(n==0)	return 1;
		if(n%2==0)	return pow(x*x, n/2);
		else if(n>0)	return pow(x*x, n/2)*x;
		else return pow(x*x, n/2)/x;
	}
	
	public static void main(String[] args){
		System.out.print(pow(1, Integer.MIN_VALUE));
	}
}
