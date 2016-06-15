package leetcode;
public class Q312 {
	public int maxCoins(int[] nums) {
		int n = nums.length;
		int dp[][] = new int[n+2][n+2];
		int[] tempnums= new int[n+2];
		System.arraycopy(nums, 0, tempnums, 1, n);
		tempnums[0] = 1;
		tempnums[n+1] = 1;
		nums =  tempnums;

		for (int gap = 1; gap <= n; gap++) {
			for (int left = 1; left <= n - gap+1; left++) {
				int right = left + gap - 1;
				for (int i = left; i <= right; i++) {
					dp[left][right] = Math.max(dp[left][i-1]
							+ dp[i + 1][right] + nums[left - 1]
							* nums[i] * nums[right+1],
							dp[left][right]);
				}
			}
		}

		return dp[1][n ];
	}
}
