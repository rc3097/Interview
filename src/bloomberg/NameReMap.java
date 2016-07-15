package bloomberg;

import java.util.*;
import java.util.Map.Entry;

public class NameReMap {
	public ArrayList<Map.Entry<Integer, String>> reMap(
			HashMap<Integer, String> map) {
		ArrayList<Map.Entry<Integer, String>> res = new ArrayList();
		for (Map.Entry<Integer,String> entry : map.entrySet())
			res.add(entry);
		Collections.sort(res, new Comparator<Map.Entry<Integer,String>>() {
			@Override
			public int compare(Entry<Integer, String> o1,
					Entry<Integer, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		return res;
	}
}