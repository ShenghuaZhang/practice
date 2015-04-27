package dynamicProgramming;
/**
 * TODO
 * 121 122 123 188
 * @author yili3
 */
public class BestTimeToBuyAndSellStock {
	
	
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
	 * http://blog.csdn.net/linhuanmars/article/details/23236995
	 * You may complete at most TWO transactions.
	 */
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
	/**
	 * 188
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
	 * 
	 * You may complete at most K transactions.
	 */
	public int maxProfitIV(int k, int[] prices){
		if(prices==null || prices.length==0) return 0;
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
	
	int maxProfit(int k, int[] prices) {
		int len = prices.length;
	    if (len < 2) return 0;
	    int maxProfit = 0;
	    //simple case where we just need to find the maximum climb in prices among all the pairs
	    if (k >= len / 2){
	        for (int i = 1; i < len; i++)
	            maxProfit += Math.max(0, prices[i] - prices[i-1]);
	        return maxProfit;
	    }

	    //Dynamic Programming case where we need to maximize our profit

	    //keeps track of maximum profit so far at each index. On any index 'i' the value is max profit that we gained
	    //by dealing stock that came before 'i'. After any 'm' iterations, this array holds max profit on index 'i' if we had
	    //only 'i' stock values and 'm' possible deals.
	    int[] maxProfitSoFar= new int[len+1];
	    //calculates the difference between the very current and previous stock price
	    int currentProfit = 0;
	    //keeps track of our current balance.
	    int runningProfit = 0;
	    //it backs up the value of max profit after doing 'm-1' deals until index 'i' before updating it to 
	    //the value of doing 'm' deals until index i.
	    int prevMaxProfit = 0;
	    //k iterations for k deals - after each round mapxProfitSoFar holds the max profit for 'j' possible deals
	    for (int j = 0; j < k; j++){
	        //resetting our balance for new iteration
	        runningProfit = 0;
	        //initializing with the last max profit we are going to start the next iteration with indexes after this.
	        prevMaxProfit = maxProfitSoFar[j]; 
	        //we don't need to start from the beginning eveytime since we would face "the simple case" (above) and the profit 
	        //is already calculated. It means that number of deals is greater than the 'len'
	        for (int i = j+1; i < len; i++){
	            //what is the immediate different of the current two prices.
	            currentProfit = prices[i] - prices[i-1];
	            //is it better to do this deal? or should we stick to what we did with one less deal and see what future holds!
	            runningProfit = Math.max(runningProfit + currentProfit, prevMaxProfit);
	            //backing up max value with one less deal to compare in the next round
	            prevMaxProfit = maxProfitSoFar[i]; 
	            //updating max profit so far by asking if we gained more profit with last deal or we didn't gain anything more
	            maxProfitSoFar[i] = Math.max(runningProfit, maxProfitSoFar[i-1]); 
	        }
	    }

	    //well the last item in the MaxProfitSoFar after k iterations holds max profit of 'k' deals of 'len' items.
	    return maxProfitSoFar[len-1];
	}
	
}
