package leetcode;
public class NumArray2 {
	int[] bis;
	int[] nums;

	public NumArray2(int[] nums) {
		this.nums = new int[nums.length + 1];
		bis = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			update(i, nums[i]);
		}
	}

	void update(int i, int val) {
		int diff = val - nums[i];
		nums[i] = val;
		for (int j = i + 1; j < bis.length; j += (-j) & j) {
			bis[j] += diff;
		}
	}

	public int sumRange(int i, int j) {
		return sum(j) - sum(i-1);
	}

	private int sum(int i) {
		int sum = 0;
		for (int j = i + 1; j > 0; j -= (-j) & j) {
			sum += bis[j];
		}
		return sum;
	}
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);