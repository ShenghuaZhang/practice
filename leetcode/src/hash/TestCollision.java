package hash;

import java.util.HashMap;
import java.util.Map;

public class TestCollision {
	/**
	 * static int hash(int h) {
       		h ^= (h >>> 20) ^ (h >>> 12);
       		return h ^ (h >>> 7) ^ (h >>> 4);
    	}
	 * @param args
	 */
	public static void main(String[] args){
		Map<String, Integer> map = new HashMap<String, Integer>();
		String a = "Aa", b = "BB";
		System.out.println(a.equals(b));
		map.put(a, 1);
		map.put(b, 2);
		map.put("CC", 3);
	}
}
