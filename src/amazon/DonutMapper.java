package amazon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DonutMapper {
	public String[][] matchDonuts(String[][] donutConstrainPairs, String[][] candidateConstraintPairs) {
		ArrayList<String[]> reslist = new ArrayList<String[]>();
		HashMap<String, HashSet<String> > donutMap = new HashMap<String,HashSet<String>>();
		
		buildMap(donutMap,donutConstrainPairs);
		for (String[] candidate: candidateConstraintPairs) {
			if (candidate.length!=2) continue;
			String name = candidate[0];
			String type = candidate[1];
			if (donutMap.containsKey(type)) {
				add2reslist(reslist, name, type, donutMap);
			} else if (type.equals("*")) {
				for (String t: donutMap.keySet()) {
					add2reslist(reslist, name, t, donutMap);
				}
			}
		}
		String[][] res = new String[reslist.size()][2];
		
		for (int i =0; i< reslist.size();i++ ) {
			res[i] = reslist.get(i); 
		}
		return res;
		
	}
	
	private void add2reslist(ArrayList<String[]> reslist, String name,String type, HashMap<String, HashSet<String>> donutMap) {
		for (String donut:donutMap.get(type)) {
			reslist.add(new String[]{name,donut});
		}
	}

	private void buildMap(HashMap<String, HashSet<String>> donutMap, String[][] donutConstrainPairs) {
		for (String[] donut: donutConstrainPairs) {
			if (donut.length!=2) continue;
			String type = donut[1];
			String donutlist = donut[0];
			HashSet<String> sets =  new HashSet<String>();
			if (donutMap.containsKey(type)) 
				sets = donutMap.get(type);
			sets.add(donutlist);
			donutMap.put(type, sets);
		}
	}
	public static void main(String[] args) {
		DonutMapper dm = new DonutMapper();
		String[][] res = dm.matchDonuts(new String[][]{{"cruller","vegan"},{"beignet","chocolate"}}, new String[][]{{"jose","vegan"},{"john","chocolate"},{"mary","*"}});
		System.out.println(Arrays.deepToString(res));
		res = dm.matchDonuts(new String[][]{{"cruller","vegan"},{"beignet","coffee"}}, new String[][]{{"rob","vegan"},{"rob","coffee"}});
		System.out.println(Arrays.deepToString(res));
		res = dm.matchDonuts(new String[][]{{"cruller","vegan"},{"beignet","coffee"}}, new String[][]{{},{}});
	}
}