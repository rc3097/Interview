package leetcode;
public class WiggleSort {
	public void wiggleSort(int[] nums) {
		int n = nums.length;
		if (n == 1 || n == 0)
			return;
		double pivot;
		if (n % 2 == 1) {
			pivot = getKth(nums, n / 2 + 1, 0, n - 1);
		} else {
			pivot = (getKth(nums, n / 2, 0, n - 1) + getKth(nums, n / 2 + 1, 0,
					n - 1)) / 2;
		}

		int slow = 0;
		int fast = 1;
		System.out.println(pivot);
		while (slow < n && fast < n) {
			while (slow < n && nums[slow] <= pivot) {
				System.out.println("small:" + nums[slow]);
				slow += 2;
			}
			while (fast < n && nums[fast] > pivot) {
				System.out.println("large:" + nums[fast]);
				fast += 2;
			}
			swap(nums, slow, fast);
		}
		System.out.println(pivot);
	}

	private int getKth(int[] nums, int k, int start, int end) {
		int pivot = nums[end];
		int l = start;
		int r = end;
		while (true) {
			while (l < r && pivot >= nums[l]) {
				l++;
			}
			while (l < r && pivot < nums[r]) {
				r--;
			}

			if (l == r)
				break;

			swap(nums, l, r);
		}

		swap(nums, l, end);
		if (l + 1 == k) {
			return pivot;
		}
		if (l + 1 < k) {
			return getKth(nums, k, l + 1, end);
		} else {
			return getKth(nums, k, start, l - 1);
		}
	}

	private void swap(int[] nums, int i, int j) {
		if (i >= nums.length || j >= nums.length)
			return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}