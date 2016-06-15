package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		boolean[] visited = new boolean[nums.length];
		dfs(nums, visited, results, new ArrayList<Integer>());
		return results;
	}

	private void dfs(int[] nums, boolean[] visited,
			List<List<Integer>> results, ArrayList<Integer> arrayList) {
		// TODO Auto-generated method stub
		if (arrayList.size() == nums.length) {
			results.add((List<Integer>) arrayList.clone());
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i])
				continue;
			if (i > 0 && !visited[i - 1] && nums[i - 1] == nums[i]) {
				continue;
			}
			visited[i] = true;
			arrayList.add(nums[i]);
			dfs(nums, visited, results, arrayList);
			arrayList.remove(arrayList.size()-1);
			visited[i] = false;
		}
	}

}