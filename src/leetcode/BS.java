package leetcode;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class BS {
	/*
	 * 0,1,2,3,4,target,5 return 4 target is 4.5   0,1,2,3,4,4,4,5 return 6
	 */
	public int lbinarysearch(int[] nums, int k) {
		int l = 0;
		int r = nums.length - 1;
		while (r >= l) {
			int mid = (l + r) / 2;
			if (nums[mid] <= k) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return r;
	}

	/*
	 * always left
	 */
	public int a_lbinarysearch(int[] nums, int k) {
		int l = 0;
		int r = nums.length - 1;
		while (r >= l) {
			int mid = (l + r) / 2;
			if (nums[mid] < k) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return r == nums.length - 1 ? r : (nums[r + 1] == k ? r + 1 : r);
	}

	/*
	 * 0,1,2,3,4,target,5 return 5 target is 4 0,1,2,3,4,4,4,5 return 4
	 */
	public int rbinarysearch(int[] nums, int k) {
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (k <= nums[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		
	}
}
