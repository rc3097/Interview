package bloomberg;
import java.util.*;

public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		if (prices.length<2) return 0;
		int max = 0;
		for (int i=1; i< prices.length;i++) 
			max += Math.max(prices[i]-prices[i-1],0);
		return max;
	}
}