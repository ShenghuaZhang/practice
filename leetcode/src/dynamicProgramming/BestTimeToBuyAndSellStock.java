package dynamicProgramming;
/**
 * TODO 4.26 DP
 * https://leetcode.com/discuss/26745/c-solution-with-o-n-klgn-time-using-max-heap-and-stack
 * https://leetcode.com/discuss/32338/share-my-c-dp-solution-with-o-kn-time-o-k-space-10ms
 * 121 122 123 188
 * @author yili3
 */
public class BestTimeToBuyAndSellStock {
	/**
	 * 121
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	 * 
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * If you were only permitted to complete at most one transaction
	 * (ie, buy one and sell one share of the stock)
	 * design an algorithm to find the maximum profit.
	 */
	public int maxProfitI(int[] prices){
		if(prices==null || prices.length<2) return 0;
		int max = 0, min = prices[0];
		
		for(int i=1; i<prices.length; i++){
			max = Math.max(prices[i]-min, max);
			min = Math.min(min, prices[i]);
		}
		return max;
	}
	/*First with DP solution */
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
	/**
	 * 122
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
	 * 
	 * Design an algorithm to find the maximum profit.
	 * You may complete as many transactions as you like
	 * (ie, buy one and sell one share of the stock multiple times).
	 * However, you may not engage in multiple transactions at the same time
	 * (ie, you must sell the stock before you buy again).
	 */
	public int maxProfitII(int[] prices){
		if(prices==null || prices.length<2) return 0;
		int max = 0;
		
		for(int i=1; i<prices.length; i++)
			if(prices[i]-prices[i-1]>0) max += prices[i]-prices[i-1];
		
		return max;
	}
	/**
	 * 123
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
	 * 
	 * You may complete at most TWO transactions.
	 */
	public int maxProfitIII(int[] prices){
		if(prices==null || prices.length<2) return 0;
		int max = 0;
		
		for(int i=1; i<prices.length; i++)
			if(prices[i]-prices[i-1]>0) max += prices[i]-prices[i-1];
		
		return max;
	}
	/**
	 * 188
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
	 * 
	 * You may complete at most K transactions.
	 */
	public int maxProfitIV(int k, int[] prices){
		if(prices==null || prices.length==0) return 0;
		return -1;
	}
}
