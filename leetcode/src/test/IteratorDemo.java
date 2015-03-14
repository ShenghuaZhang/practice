package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String args[]) {
		// Create an array list
		List<String> list = new ArrayList<>(Arrays.asList("C", "A", "E",
				"B", "D", "F"));

		// Use iterator to display contents of list
		System.out.print("Original contents of list: ");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			Object element = itr.next();
			System.out.print(element + " ");
		}
		System.out.println();

		// Modify objects being iterated
		ListIterator<String> litr = list.listIterator();
		while (litr.hasNext()) {
			Object element = litr.next();
			litr.set(element + "+");
		}
		System.out.print("Modified contents of list: ");
		itr = list.iterator();
		while (itr.hasNext()) {
			Object element = itr.next();
			System.out.print(element + " ");
		}
		System.out.println();

		// Now, display the list backwards
		System.out.print("Modified list backwards: ");
		while (litr.hasPrevious()) {
			Object element = litr.previous();
			System.out.print(element + " ");
		}
		System.out.println();
	}
}