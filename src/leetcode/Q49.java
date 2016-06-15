package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Q49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, ArrayList<String>> strMap = new HashMap<String, ArrayList<String>>();
		ArrayList<String> groups = new ArrayList<String>();
		for (String string : strs) {
			char[] strarr = new char[string.length()];
			strarr= string.toCharArray();
			Arrays.sort(strarr);
			String reorders = new String(strarr);
			ArrayList<String> strlist;
			if (strMap.containsKey(reorders)) {
				strlist = strMap.get(reorders);
			} else {
				strlist = new ArrayList<String>();
				groups.add(reorders);
			}
			strlist.add(string);
			strMap.put(reorders, strlist);
		}

		ArrayList<List<String>> results = new ArrayList<List<String>>();
		for (String group : groups) {
			ArrayList<String> subgroups = strMap.get(group);
			Collections.sort(subgroups);
			results.add(subgroups);
		}
		
		return results;
	}
}