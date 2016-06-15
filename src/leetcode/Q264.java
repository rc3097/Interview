package leetcode;
import java.util.HashSet;

import javax.imageio.stream.IIOByteBuffer;

public class Q264 {
	public int nthUglyNumber(int n) {
		int[] dp;
		HashSet<Integer> numset = new HashSet<Integer>();
		dp = new int[n];
		dp[0] = 1;
		int two = 0, three = 0, five = 0;
		int two_num = 2, three_num = 3, five_num = 5;

		for (int i = 1; i < n; i++) {
			if (two_num < three_num && two_num < five_num) {
				if (!numset.contains(two_num)) {
					dp[i] = two_num;
					numset.add(two_num);
				} else {
					i--;
				}
				two++;
				two_num = dp[two] * 2;
			} else if (three_num < five_num) {
				if (!numset.contains(three_num)) {
					dp[i] = three_num;
					numset.add(three_num);
				} else {
					i--;
				}
				three++;
				three_num = dp[three] * 3;
			} else if (two_num >= five_num) {
				if (!numset.contains(five_num)) {
					dp[i] = five_num;
					numset.add(five_num);
				} else {
					i--;
				}
				five++;
				five_num = dp[five] * 5;
			}
		}
		return dp[n - 1];
	}

}