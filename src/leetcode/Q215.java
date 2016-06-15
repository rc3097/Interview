package leetcode;
import java.util.Arrays;

public class Q215 {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
	
}
