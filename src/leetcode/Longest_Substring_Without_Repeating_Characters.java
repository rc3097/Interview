package leetcode;
public class Longest_Substring_Without_Repeating_Characters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int a[] = new int[130];
		for (int i=0;i<130;i++) a[i]=-1;
		int lastrepeat = -1;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (a[(int) s.charAt(i)] > lastrepeat)
				lastrepeat = a[(int) s.charAt(i)];
			if (max < i - lastrepeat)
				max = i - lastrepeat;
			a[(int) s.charAt(i)] = i;
		}
		return max;
	}
}
