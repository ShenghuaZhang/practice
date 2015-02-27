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
}
