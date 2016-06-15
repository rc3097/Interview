package leetcode;
import java.util.Arrays;


public class Q322 {
    public int coinChange(int[] coins, int amount) {
    	int dp[] =new  int[amount+1];
    	Arrays.sort(coins);
    	for (int i = 0; i < amount+1; i++) {
			dp[i]=100000;
		}
    	dp[0]=0;
        for (int i = 0; i < coins.length; i++) {
			for (int v = coins[i]; v <= amount; v++) {
				dp[v]=Math.min(dp[v-coins[i]]+1,dp[v]);
			}
		}
        return dp[amount]==100000?-1:dp[amount];
    }
}
