package leetcode;
public class Unique_Binary_Search_Trees {
	public int numTrees(int n) {
		int[] UniqueTrees = new int[n + 1];
		UniqueTrees[0] = 1;
		UniqueTrees[1] = 1;
		if (n < 2)
			return 1;
		for (int i = 2; i < UniqueTrees.length; i++) {
			for (int j = 0; j < i; j++) {
				UniqueTrees[i] += UniqueTrees[j] * UniqueTrees[i-1 - j];
			}
		}
		return UniqueTrees[n];
	}
}
