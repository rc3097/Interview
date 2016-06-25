package booking;

import java.util.*;
/*
*3. 给一堆数，比如 input ：25400 26300 2 128 5. output：25400 -128 900 -128 -26298 126 -123 题意 只要当前数减去前面数 -127<=diff<=127 就直接输出 diff， 如果不是先输出-128 在输出diff。
* http://www.1point3acres.com/bbs/thread-144112-1-1.html
*/
public class NumDiff {
	public ArrayList<Integer> getDiff(int[] nums) {
		ArrayList<Integer> res = new ArrayList();
		res.add(nums[0]);
		for (int i=1; i< nums.length;i++) {
			int diff = nums[i] - nums[i-1];
			if (diff>=-127 && diff<=127) {

			} else {
				res.add(-128);
			}
			res.add(diff);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{25400,26300,2,128};
		NumDiff q = new NumDiff();
		System.out.println(q.getDiff(nums));
	}
}