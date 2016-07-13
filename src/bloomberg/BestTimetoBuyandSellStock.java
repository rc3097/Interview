public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int max = 0;
		int min = Integer.MIN_VALUE;
		if (prices.length<2) return -1;
		for (int i =1; i< prices.length; i++) {
			min = Math.min(min, prices[i-1]);
			max = Math.max(max, prices[i]-min);
		}
		return max;
	}
}