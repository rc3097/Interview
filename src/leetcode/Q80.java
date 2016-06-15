package leetcode;
import java.util.ArrayList;

public class Q80 {
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int length = 1;
		int index = 0;
		ArrayList<Integer> results = new ArrayList<Integer>();
		results.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				index++;
				if (index == 1) {
					length++;
					results.add(nums[i]);
				}
			} else {
				index = 0;
				length++;
				results.add(nums[i]);
			}
		}
		for (int i = 0; i < results.size(); i++) {
			nums[i] = results.get(i);
		}
		return length;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2 };
		System.out.println(removeDuplicates(nums));
	}
}