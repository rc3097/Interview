package leetcode;
import java.util.ArrayList;
import java.util.List;

public class Q321 {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		String results = "";
		for (int i = 0; i < k; i++) {
			results += 0;
		}

		for (int i = 0; i <= k; i++) {
			if ((nums2.length < k - i || nums1.length < i)
					&& !((i == 0 && k <= nums2.length) || (i == k && k <= nums1.length)))
				continue;
			int[] subset_nums1 = getmaxsubset(nums1, i);
			int[] subset_nums2 = getmaxsubset(nums2, k - i);
			String tempresult = merge(subset_nums1, subset_nums2);
			if (tempresult.compareTo(results) > 0) {
				results = tempresult;
			}
		}

		int[] resultarr = new int[k];
		for (int i = 0; i < results.length(); i++) {
			resultarr[i] = Integer.valueOf(results.charAt(i)) - 48;
		}
		System.out.println(results);
		return resultarr;
	}

	private int[] getmaxsubset(int[] nums, int k) {
		int[] maxsubset = new int[k];
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			while (len > 0 && maxsubset[len - 1] < nums[i]
					&& (nums.length - i) + len > k) {
				len--;
			}
			if (len < k) {
				maxsubset[len++] = nums[i];
			}
		}
		return maxsubset;
	}
	
	private boolean compare(int[] nums1, int len1, int[] nums2, int len2) {
		String s1 = "";
		String s2 = "";
		while (len1<nums1.length && len2<nums2.length) {
			s1 +=nums1[len1];
			s2 += nums2[len2];
			len1++;
			len2++;
		}
		return s1.compareTo(s2)>0;
	}

	private String merge(int[] nums1, int[] nums2) {
		List<Integer> results = new ArrayList<Integer>();
		int len1 = 0;
		int len2 = 0;
		int  i=0;
		while (len1<nums1.length && len2<nums2.length ) {
			if (compare(nums1, len1, nums2, len2)) {
				results.add(i,nums1[len1]);
				len1++;
			} else {
				results.add(i,nums2[len2]);
				len2++;
			}
			i++;
		}
		if (len1==nums1.length) {
			for (int j = len2; j < nums2.length; j++) {
				results.add(i,nums2[j]);
				i++;
			}
		} else {
			for (int j = len1; j < nums1.length; j++) {
				results.add(i,nums1[j]);
				i++;
			}
		}
		String result = "";
		for (Integer integer : results) {
			result += integer;
		}
		return result;

	}
}
