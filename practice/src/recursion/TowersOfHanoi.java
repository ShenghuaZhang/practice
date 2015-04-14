package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * http://introcs.cs.princeton.edu/java/23recursion/TowersOfHanoi.java.html
 * 
 * Our goal is to issue a sequence of instructions for moving the discs.
 * We assume that the poles are arranged in a row,
 * and that each instruction to move a disc specifies its number
 * and whether to move it left or right. If a disc is on the left pole,
 * an instruction to move left means to wrap to the right pole;
 * if a disc is on the right pole,
 * an instruction to move right means to wrap to the left pole.
 * 
 * @author yili3
 * 
 * http://www.javawithus.com/programs/towers-of-hanoi
 * http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/13/hanoi.html
 *
 */
public class TowersOfHanoi {
	int Size;
	List<Integer> Start, Auxiliary, End;
	Map<String, List<Integer>> map;
	
	public TowersOfHanoi(int n){
		if(n<1){
			System.err.print("n must bigger than 0");
			return;
		}
		
		Size = n;
		Start = new ArrayList<Integer>();
		for(int i=1; i<=Size; i++)	Start.add(i);
		Auxiliary = new ArrayList<Integer>();
		End = new ArrayList<Integer>();
		map = new HashMap<String, List<Integer>>(){
			private static final long serialVersionUID = 4624797769248664305L;
			{
				put("Start", Start);
				put("Auxiliary", Auxiliary);
				put("End", End);
			}
		};
		showTowersOfHanoi();
	}
	
	public void move(String from, String to){
		int temp = map.get(from).get(0);
		map.get(from).remove(0);
		map.get(to).add(0, temp);
	}
	
	public void showTowersOfHanoi(){
		for(int i=0; i<Size; i++){
			if(Start.size()+i>=Size)	System.out.print(Start.get(Start.size()+i-Size)+" ");
			else	System.out.print("* ");
			if(Auxiliary.size()+i>=Size)	System.out.print(Auxiliary.get(Auxiliary.size()+i-Size)+" ");
			else	System.out.print("* ");
			if(End.size()+i>=Size)	System.out.print(End.get(End.size()+i-Size)+" ");
			else	System.out.print("* ");
			System.out.println();
		}
		System.out.println();
	}
	
	public void towersOfHanoi(int n, String from, String auxiliary, String to){
		if(n<1)	return;
		towersOfHanoi(n-1, from, to, auxiliary);
		move(from, to);
		showTowersOfHanoi();
		towersOfHanoi(n-1, auxiliary, from, to);
	}
	
	public void towersOfHanoi(){
		towersOfHanoi(Size, "Start", "Auxiliary", "End");
	}
	
	public static void main(String[] args){
		while(true){
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
			TowersOfHanoi towers = new TowersOfHanoi(n);
			towers.towersOfHanoi();
		}
	}
}
