package leetcode;
public class Q238 {
	public int[] productExceptSelf(int[] nums) {
		long product = 1;
		int countzero = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				product *= nums[i];
			else {
				countzero++;
			}
		}
		int[] results = new int[nums.length];

		for (int i = 0; i < results.length; i++) {
			if (countzero > 1)
				results[i] = 0;
			else if (countzero == 1) {
				if (nums[i] == 0) {
					results[i] = (int) product;
				} else {
					results[i] = 0;
				}
			} else {
				results[i] = (int) product / nums[i];
			}
		}
		return results;
	}
}
