package leetcode;
import java.util.ArrayList;
import java.util.List;


public class Q118 {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> results =new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
			results.add(getRow(i));
		}
        return results;
    }
	public List<Integer> getRow(int rowIndex) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		rowIndex ++;
		for (int i = 0; i < rowIndex; i++) {
			int pre = 0;
			for (int j = 0; j < results.size(); j++) {
				int temp = results.get(j);
				results.set(j, pre + results.get(j));
				pre = temp;
			}
			results.add(1);
		}
		return results;
	}
}
