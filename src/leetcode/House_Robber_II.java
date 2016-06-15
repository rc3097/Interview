package leetcode;
public class House_Robber_II {
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int dp[][] = new int[nums.length + 1][3];
		// first one is robbed.
		dp[1][1] = nums[0];
		dp[1][2] = nums[0];
		dp[2][0] = nums[0];
		dp[2][1] = nums[0];
		dp[2][2] = nums[0];
		for (int i = 3; i <= nums.length; i++) {
			dp[i][0] = dp[i - 1][2];
			dp[i][1] = nums[i - 1] + Math.max(dp[i - 1][0], dp[i - 2][2]);
			dp[i][2] = Math.max(dp[i][0], dp[i][1]);
		}

		int max = dp[nums.length][0];
		// first one is not robbed
		dp = new int[nums.length + 1][3];
		dp[1][1] = 0;
		dp[1][2] = 0;
		for (int i = 2; i <= nums.length; i++) {
			dp[i][0] = dp[i - 1][2];
			dp[i][1] = nums[i - 1] + Math.max(dp[i - 1][0], dp[i - 2][2]);
			dp[i][2] = Math.max(dp[i][0], dp[i][1]);
		}

		return Math.max(dp[nums.length][2], max);
	}
}