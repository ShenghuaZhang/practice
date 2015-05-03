package dynamicProgramming;
/**
 * 188
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 
 * You may complete at most K transactions.
 * 
 * #BestTimeToBuyAndSellStock #BestTimeToBuyAndSellStockII #BestTimeToBuyAndSellStockIII
 */
public class BestTimeToBuyAndSellStockIV {
	public int maxProfitIV(int k, int[] prices){
		if(prices==null || prices.length<2) return 0;
		if(k>prices.length/2){	// same situation with II
			int max = 0;
			for(int i=1; i<prices.length; i++)
				max += Math.max(prices[i]-prices[i-1], 0);
			return max;
		}
		int[] global = new int[k+1], local = new int[k+1];
		
		for(int i=1; i<prices.length; i++){
			int diff = prices[i]-prices[i-1];
			for(int j=k; j>0; --j){
				local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
				global[j] = Math.max(global[j], local[j]);
			}
			
		}
		
		return global[k];
	}
}
