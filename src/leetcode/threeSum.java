package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (len < 3)
			return result;
		HashSet<Integer> availnum = new HashSet<Integer>();

		for (int i = 0; i < len; i++) {
			availnum.add(nums[i]);
		}

		for (int i = 0; i < len - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < len - 1; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1])
					continue;
				int third = -nums[i] - nums[j];
				if (third < nums[j])
					continue;
				if ((third == nums[j] && nums[j] != nums[j + 1]))
					continue;

				if (availnum.contains(third)) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(third);
					result.add(temp);
				}
			}
		}
		return result;
	}
}