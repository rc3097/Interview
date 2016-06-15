package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Isomorphic_Strings {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() < 1)
			return true;
		HashMap<String, ArrayList<Integer>> smap = new HashMap<String, ArrayList<Integer>>();
		HashMap<String, ArrayList<Integer>> tmap = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < s.length(); i++) {
			if (smap.containsKey(s.charAt(i) + "")) {
				ArrayList<Integer> temp = smap.get(s.charAt(i) + "");
				temp.add(i);
				smap.put(s.charAt(i) + "", temp);
			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				smap.put(s.charAt(i) + "", temp);
			}
			if (tmap.containsKey(t.charAt(i) + "")) {
				ArrayList<Integer> temp = tmap.get(t.charAt(i) + "");
				temp.add(i);
				tmap.put(t.charAt(i) + "", temp);
			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				tmap.put(t.charAt(i) + "", temp);
			}
		}
		
		Iterator iter = smap.entrySet().iterator(); 
		while (iter.hasNext()) { 
		    Map.Entry entry = (Map.Entry) iter.next(); 
		    String key = (String) entry.getKey(); 
		    ArrayList<Integer> val = (ArrayList<Integer>) entry.getValue(); 
		    if (!smap.get(s.charAt(val.get(0))+"").equals(tmap.get(t.charAt(val.get(0))+""))) {
				return false;
			}
		} 
		
		
		return true;
	}
}