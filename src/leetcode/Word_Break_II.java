package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Word_Break_II {

	ArrayList<String> resultlist = new ArrayList<String>();

	public List<String> wordBreak(String s, Set<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = false;
		}
		HashMap<Integer, HashSet<Integer>> route = new HashMap<Integer, HashSet<Integer>>();
		HashMap<Character, HashSet<String>> dictmap = new HashMap<Character, HashSet<String>>();
		Iterator<String> iterator = wordDict.iterator();
		while (iterator.hasNext()) {
			String word = iterator.next();
			if (dictmap.containsKey(word.charAt(0))) {
				HashSet<String> tempSet = dictmap.get(word.charAt(0));
				tempSet.add(word);
			} else {
				HashSet<String> tempSet = new HashSet<String>();
				tempSet.add(word);
				dictmap.put(word.charAt(0), tempSet);
			}
		}

		dp[0] = true;
		for (int i = 0; i < s.length(); i++) {
			if (dp[i] && dictmap.containsKey(s.charAt(i))) {
				HashSet<String> dictHashSet = dictmap.get(s.charAt(i));
				Iterator<String> iterator2 = dictHashSet.iterator();
				while (iterator2.hasNext()) {
					String word = iterator2.next();
					if (i + word.length() <= s.length()
							&& word.equals(s.substring(i, i + word.length()))) {
						dp[i + word.length()] = true;
						HashSet<Integer> pre = null;
						if (route.containsKey(i + word.length())) {
							pre = route.get(i + word.length());
						} else {
							pre = new HashSet<Integer>();
						}
						pre.add(i);
						route.put(i + word.length(), pre);
					}
				}
			}
		}
		if (dp[s.length()]) {
			DFS(route, s.length(), "", s);
			return resultlist;
		}
		return resultlist;

	}

	public void DFS(HashMap<Integer, HashSet<Integer>> route, int current,
			String result, String s) {
		if (current == 0) {
			resultlist.add(result.substring(0, result.length() - 1));
			return;
		}
		HashSet<Integer> hashSet = route.get(current);
		if (hashSet != null) {
			Iterator<Integer> iterator = hashSet.iterator();

			while (iterator.hasNext()) {
				int pre = iterator.next();
				DFS(route, pre, s.substring(pre, current) + " " + result, s);
			}
		} else {
			return;
		}
	}
}