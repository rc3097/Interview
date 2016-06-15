package leetcode;
public class House_Robber {
	public int rob(int[] nums) {
		if (nums.length==0) return 0;
		int dp[][] = new int[nums.length + 1][3];
		dp[1][1] = nums[0];
		dp[1][2] = nums[0];
		for (int i = 2; i <= nums.length; i++) {
			dp[i][0] = dp[i - 1][2];
			dp[i][1] = nums[i - 1] + Math.max(dp[i - 1][0], dp[i - 2][2]);
			dp[i][2] = Math.max(dp[i][0], dp[i][1]);
		}
		return dp[nums.length][2];
	}
}