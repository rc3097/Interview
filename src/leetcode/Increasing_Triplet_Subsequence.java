package leetcode;

public class Increasing_Triplet_Subsequence {
    public boolean increasingTriplet(int[] nums) {
    	int n = nums.length;
    	int min1 =Integer.MAX_VALUE;
    	int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
			if (min1>nums[i]) {
				min1 = nums[i];
			}
			if (min2>nums[i] && nums[i]>min1) {
				min2 = nums[i];
			}
			if (nums[i]>min2 && nums[i]>min1) {
				return true;
			}
		}
        return false;
    }
}