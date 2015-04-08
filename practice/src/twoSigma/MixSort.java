package twoSigma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MixSort {
	public static void main(String[] args) throws Exception{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);
		String line = null;
		while((line = reader.readLine())!=null)
			sortString(line);
	}
	
	public static void sortString(String line){
		List<Integer> integers = new ArrayList<>();
		List<String> words = new ArrayList<>();
		int index_integer = 0, index_word = 0;
		
		String[] stringlist = line.split(" ");
		
		for(int i=0; i<stringlist.length; i++){
			if(isNumeric(stringlist[i]))
				integers.add(Integer.parseInt(stringlist[i]));
			else	words.add(stringlist[i]);
		}
		
		Collections.sort(integers);
		Collections.sort(words);
		
		for(int i=0; i<stringlist.length; i++){
			if(isNumeric(stringlist[i]))
				stringlist[i] = String.valueOf(integers.get(index_integer++));
			else
				stringlist[i] = words.get(index_word++);
		}
		
		for(int i=0; i<stringlist.length-1; i++)
			System.out.print(stringlist[i]+" ");
		System.out.print(stringlist[stringlist.length-1]);
	}
	
	public static boolean isNumeric(String s){
		return s.matches("[-+]?\\d*\\.?\\d+");
	}
}
