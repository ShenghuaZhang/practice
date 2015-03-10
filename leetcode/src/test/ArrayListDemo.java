package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Java program to show How to create and initialize List in one line in Java
 * Arrays.asList() our go to method to initialize List in same line.
 * 
 * @author carllee1991
 */
public class ArrayListDemo {

	public static void main(String args[]) {

		// You can create and initialize Array in just one line in Java
		String[] coolStringArray = new String[] { "Java", "Scala", "Groovy" };
		System.out.println(" Array : " + Arrays.toString(coolStringArray));

		// Now If you want to create an ArrayList with three elements
		List<String> notSoCoolStringList = new ArrayList<String>();
		notSoCoolStringList.add("Java");
		notSoCoolStringList.add("Scala");
		notSoCoolStringList.add("Groovy");

		// It took four line to create and initialize List
		System.err.println(" List : " + notSoCoolStringList);

		// Now here is simple Java tips to create and initialize List in one
		// line
		List<String> coolStringList = Arrays.asList("Java", "Scala", "Groovy");
		System.err.println(" List created and initialized at same line : "
				+ coolStringList);
	}
}