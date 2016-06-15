package leetcode;
public class LongestIncreasingArray {
	public int findLongestConsecutive(int[] nums) {
		int max = 1;
//		5 2 3 4 6
//		0 1 2 3 4 6 7
		for (int i=1; i<nums.length; i++) {
			int j= i;
			while (j<nums.length && nums[j]==nums[j-1]+1) {
				j++;
			}
			max = Math.max(max, j-i+1);
			i=j;
		}
		return max;
	}
}
