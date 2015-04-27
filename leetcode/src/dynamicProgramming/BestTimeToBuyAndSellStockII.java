package dynamicProgramming;
/**
 * 122
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * 
 *  #BestTimeToBuyAndSellStock #BestTimeToBuyAndSellStockIII #BestTimeToBuyAndSellStockIV
 */

public class BestTimeToBuyAndSellStockII {
	public int maxProfitII(int[] prices){
		if(prices==null || prices.length<2) return 0;
		int max = 0;
		
		for(int i=1; i<prices.length; i++)
			if(prices[i]-prices[i-1]>0) max += prices[i]-prices[i-1];
		
		return max;
	}
}
