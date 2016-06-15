package leetcode;
public class LongestSubstringwithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstring2Distinct(String s) {
		char[] charr = s.toCharArray();
		int difference = 0;
		int max = 1;
		int start = 0;
		for (int i = 1; i < charr.length; i++) {
			if (charr[i] == charr[i - 1]) {
				max = Math.max(max, i - start+1);
			} else {
				if (charr[start] != charr[i]
						&& ( difference==0 || charr[difference - 1] != charr[i])) {
					start = difference;
				}
					
				difference = i;
				max = Math.max(max, i - start+1);
			}
		}
		return max;
	}
}
