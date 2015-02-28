package dynamicProgramming;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices){
		if(prices==null || prices.length==0) return 0;
		int max = 0, min = prices[0];
		
		for(int i=1; i<prices.length; i++){
			max = Math.max(prices[i]-min, max);
			min = Math.min(min, prices[i]);
		}
		return max;
	}
}
