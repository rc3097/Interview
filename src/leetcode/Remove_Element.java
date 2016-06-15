package leetcode;
public class Remove_Element {
	public int removeElement(int[] nums, int val) {
		int len = nums.length;
		int count = 0;
		int pointer = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				count++;
			} else {
				nums[pointer] = nums[i];
				pointer++;
			}
		}
		return len - count;
	}
}