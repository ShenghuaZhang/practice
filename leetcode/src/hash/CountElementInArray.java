package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountElementInArray {
	public static Integer[] countItems(String[] arr)
	{
	    List<Integer> itemCount = new ArrayList<Integer>();
	    Integer counter = 0;
	    String lastItem = arr[0];

	    for(int i = 0; i < arr.length; i++){
	        if(arr[i].equals(lastItem))	counter++;
	        else{
	            itemCount.add(counter);
	            counter = 1;
	        }
	        lastItem = arr[i];
	    }
	    itemCount.add(counter);

	    return itemCount.toArray(new Integer[itemCount.size()]);
	}

	public static void main(String[] args)
	{
	    String[] array = {"name1","name1","name2","name2", "name2", "name3",
	            "name1","name1","name2","name2", "name2", "name3"};
	    Arrays.sort(array);
	    Integer[] cArr = countItems(array);
	    int num = 0;
	    for(int i = 0; i < cArr.length; i++)
	    {
	        num += cArr[i]-1;
	        System.out.println(array[num] + ": " + cArr[i].toString());
	    }
	}
}


