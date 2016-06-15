package leetcode;
import java.util.HashMap;

public class Two_Sum {
	public int[] twoSum(int[] nums, int target) {
		int len = nums.length;
		int[] result = new int[2];
		if (len < 2)
			return result;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i + 1);
			} else if (!map2.containsKey(nums[i])) {
				map2.put(nums[i], i + 1);
			}
		}
		for (int i = 0; i < len; i++) {
			int second = target - nums[i];
			if (map.containsKey(second)) {
				if (second == nums[i] && !map2.containsKey(nums[i])) {
					continue;
				}
				int steptwo = map.get(second);
				if (second == nums[i] && map2.containsKey(nums[i])) {
					steptwo = map2.get(second);
				}
				if (i > steptwo) {
					result[0] = steptwo;
					result[1] = i+1;
				} else {
					result[0] = i+1;
					result[1] = steptwo;
				}
				return result;
			}
		}
		return result;
	}
}
