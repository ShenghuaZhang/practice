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
		map.put("Aa", 1);
		map.put("BB", 2);
		map.put("CC", 3);
	}
}
