package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class fourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		Arrays.sort(num);
		HashMap<Integer, List<String[]>> pair = new HashMap<Integer, List<String[]>>();
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int sum = num[i] + num[j];
				String[] tempStrings = new String[2];
				tempStrings[0] = num[i] + "@" + i;
				tempStrings[1] = num[j] + "@" + j;
				if (!pair.containsKey(sum)) {
					List<String[]> tempList = new ArrayList<String[]>();
					tempList.add(tempStrings);
					pair.put(sum, tempList);
				} else {
					List<String[]> tempList = pair.get(sum);
					tempList.add(tempStrings);
					pair.put(sum, tempList);
				}
			}
		}

		Iterator iterator = pair.keySet().iterator();
		int halftarget = target / 2;
		Set<Set<String>> sets = new HashSet<Set<String>>();
		while (iterator.hasNext()) {
			int first2 = (Integer) iterator.next();
			if (first2 > halftarget)
				continue;
			if (!pair.containsKey(target - first2))
				continue;
			List<String[]> firstpair = pair.get(first2);
			List<String[]> lastpair = pair.get(target - first2);
			for (int i = 0; i < firstpair.size(); i++) {
				for (int j = 0; j < lastpair.size(); j++) {
					Set<String> tempset = new HashSet<String>();
					tempset.add(firstpair.get(i)[0]);
					tempset.add(firstpair.get(i)[1]);
					tempset.add(lastpair.get(j)[0]);
					tempset.add(lastpair.get(j)[1]);
					sets.add(tempset);
				}
			}
		}

		iterator = sets.iterator();
		Set<Set<Integer>> tempintHashSet = new HashSet<Set<Integer>>();
		while (iterator.hasNext()) {
			Set<String> tempset = (Set<String>) iterator.next();
			if (tempset.size() != 4)
				continue;
			String[] st = tempset.toArray(new String[tempset.size()]);
			for (int i = 0; i < st.length; i++) {
				st[i] = st[i].split("@")[0];
			}
			List<Integer> intlist = new ArrayList<Integer>();
			Integer[] tempint = new Integer[4];
			for (int i = 0; i < tempint.length; i++) {
				tempint[i] = Integer.parseInt(st[i]);
			}
			Arrays.sort(tempint);
			Set<Integer> repeatIntegers=new HashSet<Integer>();
			repeatIntegers.add(tempint[0]);
			repeatIntegers.add(tempint[1]);
			repeatIntegers.add(tempint[2]);
			repeatIntegers.add(tempint[3]);
			if (!tempintHashSet.contains(repeatIntegers)) {
				intlist.add(tempint[0]);
				intlist.add(tempint[1]);
				intlist.add(tempint[2]);
				intlist.add(tempint[3]);
				tempintHashSet.add(repeatIntegers);
				result.add(intlist);
			}
		}

		return result;
	}
}