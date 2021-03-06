/* Say you have an array for which the ith element is the price of a given stock on day i.
 *  Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (i.e., buy one and sell one share of the stock multiple times).
 *  
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock 
 *       before you buy again). 
 */

package LeetCode;

public class Day05_BestTimeToBuyAndSellStock {
	
	public static int maxProfit(int[] prices) {
		
		int profit = 0;
		
		for (int i=0; i<prices.length-1; i++) {
			if (prices[i] >= prices[i+1]) {
				continue;
			} else {
				profit += (prices[i+1] - prices[i]);
			}
		}
		
		return profit;
	}

	public static void main(String[] args) {
		
		int[] stockPrices = {7,6,4,3,1};
		
		System.out.println(maxProfit(stockPrices));

	}

}
