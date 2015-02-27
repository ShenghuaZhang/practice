package vmware;

import java.util.HashMap;
import java.util.Map;

import list.ListNode;


public class vmwareOnlineTest {
	public static int CoinTossEndAmount(int betAmount, String coinTossResults) {
        int length = coinTossResults.length(), bet = 1;
        for (int i=0; i<length; i++){
            if (coinTossResults.charAt(i) == 'H') {
                betAmount = betAmount + bet;
                bet = bet*2;
            }else {
                betAmount = betAmount - bet;
                bet = Math.max(bet/2,1);
            }
        }
        return betAmount;
    }
	
	public static ListNode removeDuplicates(ListNode list) {
		Map<Integer, Integer> map = new HashMap<>();
        ListNode current = list;
        if (current != null) map.put(current.val, 1);
        while(current.next!=null){
            if (!map.containsKey(current.next.val)) {
                map.put(current.next.val, 1);
                current = current.next;
            }
            else if (current.next.next != null) {
                current.next = current.next.next;
            }
            else {
                current.next = null;
                return list;
            }
        }
        return list;
    }
	
	public static int heightOfTree(String enc) {
        int length = enc.length(), max = 0, temp =0;
        for(int i=0;i <length;i++){
            if (enc.charAt(i) == '*'){
                if(i<length-1 && enc.charAt(i+1) == '*'){
                    max = Math.max(max, temp);
                    temp--;
                }else if (i == length-1){
                    return Math.max(max, temp);
                }else{
                    continue;
                }
            }
            else temp ++;
        }
        return max;
    }
	
	public static int DateOfWeekday(int date, int weekday) {
        int curWeekDay = date % 7;
        if (weekday == 0) return date;
        if (weekday > 0){
            if (weekday > curWeekDay)   return date + weekday - curWeekDay;
            if (weekday <= curWeekDay)   return date + 7 - curWeekDay + weekday;
        }
        if (weekday < 0){
            if (Math.abs(weekday)<curWeekDay)   return date - curWeekDay - weekday;
            if (Math.abs(weekday)>=curWeekDay)   return date - 7 - curWeekDay - weekday;
        }
		return date;

	}
    
    public static int MEM[] = new int[100100];   // Can support up to 10000 value
    
     
    public static int is_score_possible(int n, int[] coins) {
        if(n < 0)	return 0;
        else if (n == 0)	return 1;
        else if(MEM[n] != 0)	return 1;
        else {
            for(int i = 0; i < coins.length; i++){
            	MEM[n] = Math.max(MEM[n], is_score_possible(n-coins[i], coins));
            	if (MEM[n] != 0)	return 1;
            }
            return 0;
        }
    }
  
	public static int max_loot(int[] gold,int[] silver, int weight){  
		if (weight < 0)	return 0;
	    if (MEM[weight] >= 0)	return MEM[weight];
	    int max = 0;
	    
	    for(int i=0; i<gold.length; i++)
	    	max=Math.max(max,gold[i]*10 + max_loot(gold, silver, weight-gold[i]));
	    for(int i=0; i<silver.length; i++)
	    	max=Math.max(max,silver[i] + max_loot(gold, silver, weight-silver[i]));
	    
	    MEM[weight]=max;
	    return max;  
	}  
	
	public static void main(String[] args){
		for (int i=0; i<10001; i++)   MEM[i] = -1;
		int[] gold = new int[]{10000};
		int[] silver = new int[]{10000};
		System.out.print(max_loot(gold, silver, 10000));
		
//		int coins[] = {2, 4, 10};
//      int count = is_score_possible(13, coins);
//      System.out.println(count);
	}

}
