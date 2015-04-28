package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 165
 * https://leetcode.com/problems/compare-version-numbers/
 * 
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0. Here is an
 * example of version numbers ordering: 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author yili3
 *
 */
public class CompareVersionNumbers {
	public static int compareVersion(String version1, String version2) {
		List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
		/* Using regular expression when use String.split(String s);
		 * #JumbleSort
		 * The split function takes a regular expression, not a string, to match.
		 * Our regular expression uses a special character - in this case '.'
		 * so we would need to change it to escape that character:
		 * "String[] s = version1.split("\\.");"
		 */
		for (String s1 : version1.split("\\."))	list1.add(Integer.valueOf(s1));
		for (String s2 : version2.split("\\."))	list2.add(Integer.valueOf(s2));
		if (list1.size() == 0)	list1.add(Integer.valueOf(version1));
		if (list2.size() == 0)	list2.add(Integer.valueOf(version2));
		int i = 0;
		for (; i < Math.min(list1.size(), list2.size()); i++) {
			if (list1.get(i) > list2.get(i))	return 1;
			if (list1.get(i) < list2.get(i))	return -1;
		}
		if (list1.size() > list2.size())
			for(;i<list1.size(); i++)	if(list1.get(i)>0)	return 1;
		if (list1.size() < list2.size())
			for(;i<list2.size(); i++)	if(list2.get(i)>0)	return -1;
		return 0;
	}

	public static void main(String[] args) {
		System.out.print(compareVersion("1.0.1.1.1", "1.1"));
	}
}
