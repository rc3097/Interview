package leetcode;
public class Q260 {
	public static int[] singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++)
			result ^= nums[i];
		int index = 1;
		int refer = 1;
		while ((result & refer) == 0) {
			index++;
			refer = refer << 1;
		}
		int num1 = 0, num2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & refer) != 0) {
				num1 ^= nums[i];
			} else {
				num2 ^= nums[i];
			}
		}
		return (new int[] { num1, num2 });
	}
	public static void main(String[] args) {
		int[] result = singleNumber(new int[]{1,-2,-2,1,3,1,1,-3});
		System.out.println(result);
	}
}