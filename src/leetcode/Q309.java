package leetcode;
public class Q309 {
	public int maxProfit(int[] prices) {
		int pre_buy = 0;
		int pre_sell = 0;
		int buy = Integer.MIN_VALUE;
		int sell = 0;
		for (int price : prices) {
			pre_buy = buy;
			buy = Math.max(pre_sell - price,pre_buy);
			pre_sell = sell;
			sell = Math.max(pre_buy+price, pre_sell);
		}
		return sell;
	}
}