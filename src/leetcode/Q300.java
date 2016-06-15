package leetcode;
public class Q300 {
	public int lengthOfLIS(int[] nums) {
	    if (nums.length==0) return 0;
		int n = nums.length;
		int[] dp = new int[n];
		int max = 1;
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int k = 0; k < i; k++) {
				if (nums[i] > nums[k]) {
					dp[i] = Math.max(dp[k] + 1,dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
