package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Q216 {
	private int[] candidates = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private int total = 0;

	public List<List<Integer>> combinationSum3(int k, int n) {
		this.total = k;
		ArrayList<List<Integer>> resultList = getsubgroup(0, n, 0);
		for (List<Integer> list : resultList) {
			Collections.reverse(list);
		}
		return resultList;
	}

	private ArrayList<List<Integer>> getsubgroup(int pos, int target,
			int currentk) {
		ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
		if (target == 0 && currentk == total) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			resultList.add(result);
			return resultList;
		}

		if (currentk< total && pos < candidates.length && candidates[pos] <= target ) {
			int maxsum = (candidates[8 - (total - currentk)+1] + candidates[8])
					* ((total - currentk) + 1) / 2;
			if (target <= maxsum) {
				for (int i = 0; i < 2; i++) {
					ArrayList<List<Integer>> subgroup = getsubgroup(pos + 1,
							target - i * candidates[pos], currentk + i);
					for (List<Integer> list : subgroup) {
						for (int j = 0; j < i; j++) {
							list.add(candidates[pos]);
						}
					}

					if (!subgroup.isEmpty()) {
						resultList.addAll(subgroup);
					}

				}
			}
		}
		return resultList;
	}
}