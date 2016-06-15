package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q77 {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (k == 1) {
			for (int i = 1; i <= n; i++) {
				List<Integer> sons = new ArrayList<Integer>();
				sons.add(i);
				results.add(sons);
			}
			return results;
		}
		return generatesubset(n, 0, k);

	}

	public static List<List<Integer>> generatesubset(int n, int pre, int k) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (k == 1) {
			for (int i = n; i >=pre+1; i--) {
				List<Integer> sons = new ArrayList<Integer>();
				sons.add(i);
				results.add(sons);
			}
			return results;
		}

		for (int i = n; i >= pre+1; i--) {
			List<List<Integer>> subsets = generatesubset(n, i, k - 1);
			for (List<Integer> list : subsets)
				list.add(0,i);
			results.addAll(subsets);
		}
		return results;
	}
	
	public static void main(String[] args) {
		System.out.println(combine(4, 2));
	}
}
