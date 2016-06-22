package uber;

import java.util.ArrayList;
import java.util.HashMap;

public class ConsecutiveSubsequences {
	public int countSubArray(int[] nums, int k) {
		HashMap<Integer, ArrayList<Integer>> sumMap = new HashMap();
		int[] sums = new int[nums.length + 1];
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		sumMap.put(k, temp);
		int res =0 ;
		for (int i = 0; i < nums.length; i++) {
			sums[i+1] =  sums[i] + nums[i];
			int mod = sums[i+1] %k;
			temp = new ArrayList<Integer>();
			if (sumMap.containsKey(k-mod)) {
				temp = sumMap.get(k-mod);
			} 
			res += temp.size();
			temp.add(i+1);
			sumMap.put(k-mod, temp);
		}
		return res;
	}
	
	public static void main(String[] args) {
		ConsecutiveSubsequences q = new ConsecutiveSubsequences();
		System.out.println(q.countSubArray(new int[]{1,2,3,4,1}, 3));
		System.out.println(q.countSubArray(new int[]{1,2,1,2,1,2}, 2));
		System.out.println(q.countSubArray(new int[]{}, 2));
	}
}
