package leetcode;
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionofTwoArrays {
	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		
		for (int num:nums1) set1.add(num);
		for (int num:nums2) set2.add(num);
		set1.retainAll(set2);
		int[] res = new int[set1.size()];
		int i = 0;
		for (int num : set1) {
			res[i++] = num;
		}

		return res;
	}

	public static void main(String[] args) {
		intersection(new int[] { 1, 2, 2 }, new int[] { 2, 2 });
	}
}
