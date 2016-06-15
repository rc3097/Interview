package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q40 {
	private int[] candidates = null;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		this.candidates = candidates;
		ArrayList<List<Integer>> resultArrayList = getsubgroup(0, target);
		for (List<Integer> list : resultArrayList) {
			Collections.reverse(list);
		}
		return resultArrayList;
	}

	private ArrayList<List<Integer>> getsubgroup(int pos, int target) {
		ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
		if (target == 0) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			resultList.add(result);
			return resultList;
		}

		if (pos < candidates.length && target >= candidates[pos]) {
			for (int i = 0; i < 2; i++) {
				int skip=1;
				while (i==0 && pos+skip<candidates.length && candidates[pos]==candidates[pos+skip]) {
					skip++;
				}
				ArrayList<List<Integer>> subgroup = getsubgroup(pos + skip, target
						- i * candidates[pos]);
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

		return resultList;
	}
}