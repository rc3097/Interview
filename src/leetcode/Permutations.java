package leetcode;
import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
		results.add(new ArrayList<Integer>());
		
		for (int num : nums) {
			ArrayList<List<Integer>> newest = new ArrayList<List<Integer>>(); 
			for (List<Integer> list : results) {
				for (int i = 0; i < list.size()+1; i++) {
					ArrayList<Integer> T = new ArrayList<Integer>(list);
					T.add(i,num);
					newest.add(T);
				}
			}
			results = newest;
		}
		
		return results;
	}
}