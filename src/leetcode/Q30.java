package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Q30 {
	public static List<Integer> findSubstring(String s, String[] words) {
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0; i < words.length; i++)
			if (wordMap.containsKey(words[i])) {
				int val = wordMap.get(words[i]);
				wordMap.put(words[i], ++val);
			} else
				wordMap.put(words[i], 1);
		int len = words[0].length();
		for (int i = 0; i < s.length() - len * words.length + 1; i++) {
			String headstring = s.substring(i, i + len);
			if (wordMap.containsKey(headstring)) {
				HashMap<String, Integer> tempHashMap = (HashMap<String, Integer>) wordMap
						.clone();
				int index = i;
				for (int j = 0; j < words.length
						&& tempHashMap.containsKey(headstring); j++) {
					int val = tempHashMap.get(headstring);
					val--;
					tempHashMap.put(headstring, val);
					if (val < 0)
						break;
					index += len;
					if (index + len>s.length()) break;
					headstring = s.substring(index, index + len);
				}
				boolean isfull = true;
				for (Entry<String, Integer> entry : tempHashMap.entrySet()) {
					int val = entry.getValue();
					if (val != 0) {
						isfull = false;
						break;
					}
				}
				if (isfull)
					results.add(i);
			}
		}
		return results;
	}

	public static void main(String[] args) {
		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] {
				"word","good","best","good" }));
	}
}
