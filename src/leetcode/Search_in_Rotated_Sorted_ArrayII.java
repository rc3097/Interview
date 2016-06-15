package leetcode;
public class Search_in_Rotated_Sorted_ArrayII {
	public boolean found;
	public int[] num;

	public boolean search(int[] A, int target) {
		if (A == null)
			return false;
		found = false;
		int left = 0;
		int right = A.length - 1;
		num = A;
		binarysearch(target, left, right);
		if (found) {
			return true;
		} else {
			return false;
		}

	}

	public void binarysearch(int target, int left, int right) {
		if (right >= left && !found) {
			int middle = (left + right) / 2;
			if (num[middle] == target) {
				found = true;
				return;
			}
			if (num[left] < num[middle]
					&& (num[left] <= target && num[middle] >= target)) {
				binarysearch(target, left, middle - 1);
			}
			if (num[left] > num[middle]
					&& (num[left] <= target || num[middle] > target)) {
				binarysearch(target, left, middle - 1);
			}
			if (num[right] > num[middle]
					&& (target >= num[middle] && target <= num[right])) {
				binarysearch(target, middle + 1, right);
			}
			if (num[middle] > num[right]
					&& (num[middle] <= target || target <= num[right])) {
				binarysearch(target, middle + 1, right);
			}
			if (num[left] == num[middle]) {
				binarysearch(target, left, middle - 1);
			}
			if (num[middle] == num[right]) {
				binarysearch(target, middle + 1, right);
			}
		}
	}
}