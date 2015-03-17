package array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public int majorityElement(int[] num) {
        int length = num.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:num){
            if(map.containsKey(i)){
                int cnt = map.get(i);
                map.put(i, cnt+1);
            }else map.put(i, 1);
        }
        
        for(int i:num)
            if(map.get(i)>(length/2))   return i;
        
        return -1;
    }
}
