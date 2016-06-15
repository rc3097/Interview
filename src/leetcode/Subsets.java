package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> empty = new ArrayList<Integer>();
		result.add(empty);
		int laststart = 0, lastend = 0;
		for (int i = 0; i < nums.length; i++) {
			int len = result.size();
			int start = 0;
			int end = result.size();
			if (i != 0 && nums[i] == nums[i - 1]) {
				start = laststart;
				end = lastend;
			}
			for (int j = start; j < end; j++) {
				ArrayList<Integer> temp = (ArrayList<Integer>) result.get(j);
				ArrayList<Integer> templist = (ArrayList<Integer>) temp.clone();
				templist.add(nums[i]);
				result.add(templist);
			}
			laststart = len;
			lastend = result.size();

		}
		return result;
	}
}