package leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_III {
    public int maxProfit(int[] prices) {
		int len = prices.length;
		int k=2;
		if (len < 2 || k == 0)
			return 0;
		if (k>len/2) {
			int max=0;
			for (int i = 1; i < len; i++) {
				max+=Math.max(prices[i]-prices[i-1], 0);
			}
			return max;
		}
		int[] hold = new int[k + 1];
		int[] rele = new int[k + 1];
		for (int i=0;i<=k;i++){
            hold[i] = Integer.MIN_VALUE;
            rele[i] = 0;
        }
		
		for (int i = 0; i < len; i++) {
			for (int j = k; j > 0; j--) {
				hold[j]=Math.max(hold[j], rele[j-1]-prices[i]);
				rele[j]=Math.max(rele[j], hold[j]+prices[i]);
			}
		}

		return rele[k];
	}
}