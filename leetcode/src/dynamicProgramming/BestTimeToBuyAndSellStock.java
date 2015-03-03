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
	
	public int maxProfitII(int[] prices){
		if(prices==null || prices.length==0) return 0;
		int max = 0;
		
		for(int i=1; i<prices.length; i++)
			if(prices[i]-prices[i-1]>0) max += prices[i]-prices[i-1];
		
		return max;
	}
	
	public int maxProfitIV(int k, int[] prices){
		if(prices==null || prices.length==0) return 0;
		return -1;
	}
}
