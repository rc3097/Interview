package uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=189515&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * 然后算法题，用的的hackerrank的code pair，leetcode原题anagram，楼主还让小哥介绍了一下什么是anagram然后开始写。
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, ArrayList<String>> strMap = new HashMap();
		Arrays.sort(strs);
		for (String str : strs) {
			char[] chMap = str.toCharArray();

			Arrays.sort(chMap);
			String newString = new String(chMap);
			ArrayList<String> subList = new ArrayList();
			if (strMap.containsKey(newString)) {
				subList = strMap.get(newString);
			}

			subList.add(str);
			strMap.put(newString, subList);
		}

		ArrayList<List<String>> res = new ArrayList();

		for (Map.Entry<String, ArrayList<String>> entry : strMap.entrySet()) {
			res.add(entry.getValue());
		}
		return res;

	}
}
