package leetcode;
public class Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] nums) {
		int len = nums.length;
		int count = 0;
		int pointer = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				count++;
			} else {
				nums[pointer] = nums[i];
				pointer++;
			}
		}
		return len - count;
	}
}