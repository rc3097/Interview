package leetcode;
import java.util.ArrayList;
import java.util.List;

public class Q119 {
	public static List<Integer> getRow(int rowIndex) {
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
	public static void main(String[] args) {
		System.out.println(getRow(3));
	}

}