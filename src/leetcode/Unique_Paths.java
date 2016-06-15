package leetcode;
public class Unique_Paths {
	public int uniquePaths(int m, int n) {
		long low = 1;
		int k = 0;
		if (m > n) {
			k = n;
		} else {
			k = m;
		}
		for (int i = m + n - k ; i <= m + n - 2; i++) {
			low *= i;
		}
		long high = 1;
		for (int i = 1; i <= k - 1; i++) {
			high *= i;
		}
		return (int) (low/high);
	}
}