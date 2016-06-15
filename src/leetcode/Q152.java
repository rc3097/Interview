package leetcode;
public class Q152 {
	public static int maxProduct(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		int global = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int temp = max;
			max = Math.max(Math.max(nums[i], max * nums[i]), min * nums[i]);
			min = Math.min(Math.min(nums[i], temp * nums[i]), min * nums[i]);
			global = Math.max(global, max);
		}
		return global;
	}

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { -2 }));
	}
}
