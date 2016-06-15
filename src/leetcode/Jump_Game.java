package leetcode;
public class Jump_Game {
	public boolean canJump(int[] nums) {
		int n = nums.length;
		int maxlength = nums[0];
		for (int i = 1; i < n; i++) {
			if (i>maxlength) {
				return false;
			}
			maxlength = Math.max(maxlength,i+nums[i]);
		}
		if (maxlength>=n-1) {
			return true;
		}
		return false;
	}
}