package test;
/**
 * http://introcs.cs.princeton.edu/java/33design/
 * 
 * @author yili3
 *
 */
public class Vector {
	private final int N;
	private final double[] cou;
	
	public Vector(double[] a){
		N = a.length;
		cou = new double[N];
		for(int i=0; i<N; i++)	cou[i] = a[i];////Defensive copy
	}
}
