package leetcode;

public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
    	int len=prices.length;
    	if (len<2) return 0;
    	int lowest=Integer.MAX_VALUE;
    	int max=0;
    	for (int i = 1; i < len; i++) {
			lowest=Math.min(lowest, prices[i-1]);
			max=Math.max(max, prices[i]-lowest);
		}
        return max;
    }
}