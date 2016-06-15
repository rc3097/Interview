package leetcode;
public class Q34 {
	public static int[] searchRange(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (right > left) {
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				left = mid+1;
			} else {
				right = mid;
			}
		}
		int leftbound = -1;
		if (left == right && nums[left] == target) {
			leftbound = left;
		}
		right = nums.length - 1;

		while (right > left) {
			int mid = (left + right+1) / 2;
			if (nums[mid] > target) {
				right = mid-1;
			} else {
				left = mid;
			}
		}
		int rightbound = -1;
		if (left == right && nums[left] == target) {
			rightbound = right;
		}
		int[] results = { leftbound, rightbound };
		return results;
	}

	public static void main(String[] args) {
		int[] nums = { 7, 7, 7, 8, 8, 8, 10 };
		System.out.println(searchRange(nums, 7));
	}
}