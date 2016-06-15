package leetcode;
public class Q53 {
	public static int maxSubArray(int[] nums) {
		int[] sums = new int[nums.length+1];
		sums[0] = 0;
		for (int i = 1; i < nums.length+1; i++)
			sums[i] = sums[i - 1] + nums[i-1];
		int min = 0;
		int sum = sums[1];
		for (int i =1; i < sums.length; i++) {
			if (sums[i]-min > sum)
				sum = sums[i]-min;
			if (min > sums[i])
				min = sums[i];
		}
		return sums.length==1? sums[0]:sum;
	}
	public static void main(String[] args) {
//		System.out.println(maxSubArray(new int[]{1,2}));
		System.out.println(maxSubArray(new int[]{1}));
	}
}
