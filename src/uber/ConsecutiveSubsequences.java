package uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ConsecutiveSubsequences {
	public long countSubArray(int[] nums, long k) {
		HashMap<Long, ArrayList<Long>> sumMap = new HashMap();
		long[] sums = new long[nums.length + 1];
		ArrayList<Long> temp = new ArrayList<Long>();
		temp.add((long) 1);
		sumMap.put(k, temp);
		long res =0 ;
		for (int i = 0; i < nums.length; i++) {
			sums[i+1] =  sums[i] + nums[i];
			long mod = sums[i+1] %k;
			temp = new ArrayList<Long>();
			if (sumMap.containsKey(k-mod)) {
				temp = sumMap.get(k-mod);
			} 
			res += temp.size();
			temp.add((long) (i+1));
			sumMap.put(k-mod, temp);
		}
		return res;
	}
	
	public static void main(String[] args) {
		ConsecutiveSubsequences q = new ConsecutiveSubsequences();
		// System.out.println(q.countSubArray(new int[]{1,2,3,4,1}, 3));
		// System.out.println(q.countSubArray(new int[]{1,2,1,2,1,2}, 2));
		// System.out.println(q.countSubArray(new int[]{}, 2));

		Scanner in  = new Scanner(System.in);
		for (int i =0; i<in.nextInt();i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] nums = new int[n];
			for (int j =0;j<n;j++) 
				nums[j] = in.nextInt();
			System.out.println(q.countSubArray(nums, k));
		}
	}
}
