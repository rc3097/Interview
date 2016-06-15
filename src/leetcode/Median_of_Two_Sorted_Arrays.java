package leetcode;
import java.util.Arrays;

public class Median_of_Two_Sorted_Arrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if ((nums1.length + nums2.length) % 2 == 1) {
			return findKthnum(nums1, nums2,
					(nums1.length + nums2.length) / 2 + 1);
		} else {
			int median1 = findKthnum(nums1, nums2,
					(nums1.length + nums2.length) / 2);
			int median2 = findKthnum(nums1, nums2,
					(nums1.length + nums2.length) / 2 + 1);
			return ((median1 + median2) / 2.0);
		}
	}

	public int findKthnum(int[] num1, int[] num2, int k) {
		int m = num1.length;
		int n = num2.length;
		if (m < n) {
			int[] temp = num1;
			num1 = num2;
			num2 = temp;
		}

		if (num2.length == 0)
			return num1[k - 1];

		if (k == 1)
			return Math.min(num1[0], num2[0]);
		int step= Math.min(k/2, num2.length);
		if (num1[step -1] < num2[step - 1]) {
			int[] temp = Arrays.copyOfRange(num1, step, num1.length);
			return findKthnum(temp, num2, k - (step));
		}

		if (num1[step - 1] >= num2[step - 1]) {
			int[] temp = Arrays.copyOfRange(num2, step, num2.length);
			return findKthnum(num1, temp, k - (step));
		}

//		if (num1[step - 1] == num2[step - 1]) {
//			return num1[step - 1];
//		}

		return 0;

	}
}