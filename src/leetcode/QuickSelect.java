package leetcode;
public class QuickSelect {
	public int select(int[] nums, int kth) {
		return getKth(nums, kth, 0, nums.length - 1);
	}

	private int getKth(int[] nums, int k, int start, int end) {
		int pivot = nums[end];
		int l = start; 
		int r = end;
		while (true) {
			while (l < r && pivot > nums[l]) {
				l++;
			}
			while (l < r && pivot <= nums[r]) {
				r--;
			}

			if (l == r)
				break;

			swap(nums, l, r);
		}

		swap(nums, l, end);
		if (l+1 == k) {
			return pivot;
		}
		if (l+1 < k) {
			return getKth(nums, k, l + 1, end);
		} else {
			return getKth(nums, k, start, l - 1);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
