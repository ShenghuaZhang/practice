package test;

import java.util.Arrays;
/**
 * http://www.cs.cmu.edu/~adamchik/15-121/lectures/Arrays/arrays.html
 * 
 * @author yili3
 * 
 */
public class ArrayCopyDemo {
	public static void main(String args[]) {
		/* ************ print ************ */
		int[] A = { 8, 12, 3, 52, 6, 7 };
		Arrays.sort(A);
		System.out.println("err print(only A's address): " + A.toString());
		System.out.println("A: " + Arrays.toString(A));
		
		/*
		 * The most efficient copying data between arrays is provided by
		 * System.arraycopy() method. The method requires five arguments.
		 */
		int[] B = new int[A.length];
		System.arraycopy(A, 0, B, 0, A.length);
		/*
		 * And the last copying choice is the use of cloning. Cloning involves
		 * creating a new array of the same size and type and copying all the
		 * old elements into the new array. 
		 * Note, that casting (int[]) is the must.
		 */
		int[] C = (int[])B.clone();
		int[] D = Arrays.copyOf(C, C.length);
		System.out.println("C: "+Arrays.toString(C)+"\nD: " + Arrays.toString(D));
		//test
	}
}
