package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FactSetFindFirstSingleChar {
	public static char firstSingle(String s){
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<s.length(); i++){
			if(map.containsKey(s.charAt(i))){
				int time = map.get(s.charAt(i))+1;
				map.put(s.charAt(i), time);
			}else map.put(s.charAt(i), 1);
		}
		
		Set<Character> set = map.keySet();
		for(char a:set)	{
			System.out.print(a);
			System.out.print(map.get(a));
		}
		
		for(int i=0; ;i++)
			if(map.get(s.charAt(i)) == 1)	return s.charAt(i);
		
	}
	
	public static void main(String[] args){
		System.out.println(firstSingle("aaaaddddfddsdgfdfdsjklkfblgkdlfklcodsfsdsderdfjkw"));
	}
}
