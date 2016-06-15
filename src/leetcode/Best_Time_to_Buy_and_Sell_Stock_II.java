package leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
    	int len = prices.length;
    	if (len < 2 )
			return 0;
		int max=0;
		for (int i = 1; i < len; i++) {
			max+=Math.max(prices[i]-prices[i-1], 0);
		}
		return max;
    }
}