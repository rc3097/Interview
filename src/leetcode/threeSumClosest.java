package leetcode;
import java.util.Arrays;


public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result=Integer.MAX_VALUE;
        int dist=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
			if (i!=0 && nums[i]==nums[i-1]) continue;
			for (int j = i+1; j < nums.length-1; j++) {
				if (j!=i+1 && nums[j]==nums[j-1]) {
					continue;
				}
				int sum=nums[i]+nums[j];
				for (int k = j+1; k < nums.length; k++) {
					if (k!=j+1 && nums[k]==nums[k-1]) {
						continue;
					}
					if (Math.abs(target-sum-nums[k])<dist) {
						dist=Math.abs(target-sum-nums[k]);
						result=sum+nums[k];
					}
				}
			}
		}
        return result;
    }
}