package leetcode;
import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	public List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> results = new ArrayList<String>();
		int pre = start - 1;
		for (int val : vals) {
			if (val - pre > 1) {
				results.add(generateString(pre + 1, val - 1));
			}
			pre = val;
		}
		if (end - vals[vals.length - 1] > 1) {
			results.add(generateString(vals[vals.length - 1], end - 1));
		}
		return results;
	}

	private String generateString(int from, int to) {
		return (to - from > 1) ? from + "->" + to : from + "";
	}

	public List<String> findMissingRanges(int[] vals) {
		int[] nums = new int[101];
		for (int val : vals) {
			nums[val] = 1;
		}
		nums[100] = 1;

		List<String> results = new ArrayList<String>();

		int start = 0;

		for (int end = 0; end < 101; end++) {
			if (nums[end] == 1 && (end - 1 >= 0 && nums[end - 1] == 0)) {
				results.add(start != end - 1 ? start + "->" + (end - 1) : start
						+ "");
			} else if (nums[end] == 0 && (end - 1 >= 0 && nums[end - 1] == 1)) {
				start = end;
			}
		}
		return results;
	}
}
