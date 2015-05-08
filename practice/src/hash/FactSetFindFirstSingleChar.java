package hash;

import java.util.HashMap;
import java.util.Map;

public class FactSetFindFirstSingleChar {
	public static void firstSingle(String s){
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<s.length(); i++){
			if(map.containsKey(s.charAt(i))){
				int time = map.get(s.charAt(i))+1;
				map.put(s.charAt(i), time);
			}else map.put(s.charAt(i), 1);
		}
		
		for(int i=0; i<s.length(); i++){
			if(map.get(s.charAt(i)) == 1){
				System.out.print(s.charAt(i)+" ");
				return;
			}
		}
	}
	
	public static void main(String[] args){
		firstSingle("aaaaddddfddsdgfdfdsjklkfblgkdlfklcodsfsdsderdfjkw");
	}
}
