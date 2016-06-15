package leetcode;
public class Q303 {
	static class NumArray {
		int[] sums;

		public NumArray(int[] nums) {
			if (nums.length == 0)
				return;
			sums = new int[nums.length];
			sums[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				sums[i] = nums[i] + sums[i - 1];
			}
		}

		public int sumRange(int i, int j) {
			if (i!=0)
				return sums[j] - sums[i-1];
			else {
				return sums[j];
			}
		}
	}
	
	public static void main(String[] args) {
		 NumArray numArray = new NumArray(new int[]{-2,0,3,-5,2,-1});
		 System.out.println(numArray.sumRange(0, 2));
		 System.out.println(numArray.sumRange(2, 5));
		 System.out.println(numArray.sumRange(0, 5));
	}
}
