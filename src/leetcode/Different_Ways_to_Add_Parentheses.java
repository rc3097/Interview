package leetcode;
import java.util.ArrayList;
import java.util.List;

public class Different_Ways_to_Add_Parentheses {
	private ArrayList<Integer> numsArrayList = new ArrayList<Integer>();
	private ArrayList<String> signStrings = new ArrayList<String>();
	private ArrayList<Integer>[][] dpSets;

	public List<Integer> diffWaysToCompute(String input) {
		if (input == null || input.equals("")) return null;
		int count = 0;
		int begin = 0;
		for (int i = 0; i < input.length(); i++) {
			String st = input.charAt(i) + "";
			if (st.equals("*")) {
				count++;
				numsArrayList.add(Integer.parseInt(input.substring(begin, i)));
				begin = i + 1;
				signStrings.add(st);
			} else if (st.equals("-")) {
				count++;
				numsArrayList.add(Integer.parseInt(input.substring(begin, i)));
				begin = i + 1;
				signStrings.add(st);
			} else if (st.equals("+")) {
				count++;
				numsArrayList.add(Integer.parseInt(input.substring(begin, i)));
				begin = i + 1;
				signStrings.add(st);
			}
		}
		numsArrayList.add(Integer.parseInt(input.substring(begin,
				input.length())));
		if (count==0) {
			return numsArrayList;
		};
		
		dpSets = new ArrayList[count + 1][count + 1];
		
		// initial value
		for (int i = 0; i < count + 1; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(numsArrayList.get(i));
			dpSets[i][i] = temp;
		}
		
		

		return recursiveToMake(0, count);
	}

	private ArrayList<Integer> recursiveToMake(int i, int j) {
		if (dpSets[i][j] == null) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int k = i; k < j; k++) {
				ArrayList<Integer> a = recursiveToMake(i, k);
				ArrayList<Integer> b = recursiveToMake(k + 1, j);
				for (int l = 0; l < a.size(); l++) {
					int anum = a.get(l);
					for (int l2 = 0; l2 < b.size(); l2++) {
						int bnum = b.get(l2);
						if (signStrings.get(k).equals("*")) {
							temp.add(anum * bnum);
						} else if (signStrings.get(k).equals("+")) {
							temp.add(anum + bnum);
						} else {
							temp.add(anum - bnum);
						}
					}
				}
			}
			return temp;
		} else {
			return dpSets[i][j];
		}
	}

}