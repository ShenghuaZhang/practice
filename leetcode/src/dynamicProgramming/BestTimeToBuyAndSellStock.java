package dynamicProgramming;
/**
 * 121
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Say you have an array for which the i element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock)
 * design an algorithm to find the maximum profit.
 * 
 *  #BestTimeToBuyAndSellStockIV #BestTimeToBuyAndSellStockII #BestTimeToBuyAndSellStockIII
 */
public class BestTimeToBuyAndSellStock{
	public int maxProfitI(int[] prices){
		if(prices==null || prices.length<2) return 0;
		int max = 0, min = prices[0];
		
		for(int i=1; i<prices.length; i++){
			max = Math.max(prices[i]-min, max);// actually DP algorithm here
			min = Math.min(min, prices[i]);
		}
		return max;
	}

	public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2) return 0;
        int profit = 0, max =0, len = prices.length;
        
        for(int i=1;i<len;i++){
        	if(profit <= 0)	profit = prices[i]-prices[i-1];
            else	profit += (prices[i]-prices[i-1]);
            
            if(profit > max) max = profit;
        }
        return max;
    }
}
