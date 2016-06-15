package leetcode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class Minimum_Window_Substring {
	public String minWindow(String s, String t) {
		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();

		for (int i = 0; i < t.length(); i++) {
			if (tMap.containsKey(t.charAt(i))) {
				tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
			} else {
				tMap.put(t.charAt(i), 1);
			}
		}
		int begin = 0;
		int end = -1;
		String result = "";
		int min = Integer.MAX_VALUE;
		int nummatch = 0;
		while (end < s.length() - 1) {
			end++;
			char current = s.charAt(end);
			if (tMap.containsKey(current)) {
				if (sMap.containsKey(current)) {
					sMap.put(current, sMap.get(current) + 1);
				} else {
					sMap.put(current, 1);
				}

				if (sMap.get(current) <= tMap.get(current)) {
					nummatch++;
				}
				if (nummatch >= t.length()
						&& sMap.get(current) >= tMap.get(current)) {
					while (end >= begin) {
						if (tMap.containsKey(s.charAt(begin))) {
							if (sMap.get(s.charAt(begin)) > tMap.get(s
									.charAt(begin))) {
								sMap.put(s.charAt(begin),
										sMap.get(s.charAt(begin)) - 1);
							} else {
								begin++;
								break;
							}
						}
						begin++;
					}
					begin--;
					if (end - begin < min) {
						result = s.substring(begin, end + 1);
						min = end - begin;
					}
				}

			}
		}
		return result;
	}
}
