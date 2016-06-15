package leetcode;
import java.util.HashMap;

public class LongestSubstringwithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		char[] charr = s.toCharArray();
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		int max = 0;
		int start = 0;
		for (int i = 0; i < charr.length; i++) {
			if (charMap.containsKey(charr[i]) || charMap.size() < k) {
				charMap.put(charr[i], i);
				max = Math.max(max, i - start + 1);
			} else {
				charMap.put(charr[i], i);
				for (int j = start; k < charMap.size(); j++) {
					if (charMap.get(charr[j]) == j) {
						charMap.remove(charr[j]);
						start = j+1;
						break;
					}
				}
				max = Math.max(max, i - start + 1);
			}
		}
		return max;
	}
}
