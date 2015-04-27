package dynamicProgramming;
/**
 * 123
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * http://blog.csdn.net/linhuanmars/article/details/23236995
 * 
 * You may complete at most TWO transactions.
 *  #BestTimeToBuyAndSellStock #BestTimeToBuyAndSellStockII #BestTimeToBuyAndSellStockIV
 */
public class BestTimeToBuyAndSellStockIII {
	public int maxProfitIII(int[] prices){
		int k = 2;	// when we can only do two transactions
		if(prices==null || prices.length<2) return 0;
		int[] global = new int[3], local= new int[3];
		
		for(int i=1; i<prices.length; i++){
			int diff = prices[i]-prices[i-1];
			for(int j=k; j>0; --j){
				local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
				global[j] = Math.max(global[j], local[j]);
			}
			
		}
		
		return global[2];
	}
}
