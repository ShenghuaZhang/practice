package vmware;

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
    
    public static int MEM[] = new int[10001];   // Can support up to 10000 value
     
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

}
