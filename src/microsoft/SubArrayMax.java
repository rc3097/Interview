package microsoft;

/*
 * 给你一个array,问subarray最大sum。subarray是连续的。例：[-8,9,-7,1,2], 答案为5， subarray为 [9,-7,1,2]
 * http://www.1point3acres.com/bbs/thread-192097-1-1.html
 */
public class SubArrayMax {
	public int findMax(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] sums = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			sums[i] = (i == 0 ? 0 : sums[i - 1]) + nums[i];
		int[] mins = new int[nums.length];
		int max = sums[0];
		for (int i = 1; i < nums.length; i++) {
			mins[i] = Math.min(mins[i - 1], sums[i - 1]);
			max = Math.max(max, sums[i] - mins[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		SubArrayMax q = new SubArrayMax();

		System.out.println(q.findMax(new int[] { -8, 9, -7, 1, 2 }));
	}
}
