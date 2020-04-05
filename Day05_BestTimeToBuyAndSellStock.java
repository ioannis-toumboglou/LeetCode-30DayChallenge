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
