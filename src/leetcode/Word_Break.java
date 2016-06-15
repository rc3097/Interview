package leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Word_Break {
	HashMap<Character, Set<String>> stringMap;

	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		stringMap = new HashMap<Character, Set<String>>();
		Iterator<String> iterator = wordDict.iterator();
		while (iterator.hasNext()) {
			String temp = iterator.next();
			if (!stringMap.containsKey(temp.charAt(0))) {
				HashSet<String> tempset = new HashSet<String>();
				tempset.add(temp);
				stringMap.put(temp.charAt(0), tempset);
			} else {
				Set<String> tempset = stringMap.get(temp.charAt(0));
				tempset.add(temp);
				// stringMap.put(temp.charAt(0),tempset);
			}
		}
		dp[0] = true;
		for (int i = 0; i < s.length(); i++) {
			if (dp[i]) {
				if (stringMap.containsKey(s.charAt(i))) {
					iterator = stringMap.get(s.charAt(i)).iterator();
					while (iterator.hasNext()) {
						String dict = iterator.next();
						if (i + dict.length() <= s.length()) {
							String temp = s.substring(i, i + dict.length());
							if (stringMap.get(s.charAt(i)).contains(temp)) {
								dp[i + dict.length()] = dp[i + dict.length()]
										|| dp[i];
							}
						}
					}
				}
			}
		}
		return dp[s.length()];
	}
}