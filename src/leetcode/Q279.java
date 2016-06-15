package leetcode;
public class Q279 {
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		int n_num = (int) Math.sqrt(n);
		int[] nums = new int[n_num];
		for (int i = 0; i < n + 1; i++) {
			dp[i] = 10000000;
		}

		for (int i = 0; i < n_num; i++) {
			nums[i] = (i + 1) * (i + 1);
			dp[nums[i]] = 1;
		}
		dp[0] = 0;

		for (int i = 0; i < n_num; i++) {
			for (int j = nums[i]; j <=n; j++) {
				dp[j] = Math.min(dp[j - nums[i]] + 1, dp[j]);
			}
		}

		return dp[n];
	}
}
