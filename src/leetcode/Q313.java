package leetcode;
import java.util.ArrayList;

public class Q313 {
	public static int nthSuperUglyNumber(int n, int[] primes) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		results.add(1);
		int[] count = new int[primes.length];

		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			ArrayList<Integer> samemin = new ArrayList<Integer>();
			for (int j = 0; j < primes.length; j++) {
				if (min >= results.get(count[j]) * primes[j]) {
					if (min == results.get(count[j]) * primes[j]) {
						samemin.add(j);
						continue;
					}

					min = results.get(count[j]) * primes[j];
					samemin.clear();
					samemin.add(j);
				}
			}

			results.add(min);

			for (int j = 0; j < samemin.size(); j++) {
					count[samemin.get(j)]++;
			}

		}

		return results.get(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(nthSuperUglyNumber(10, new int[] { 2, 7, 13, 19 }));
	}
}
