package bloomberg;

import java.util.Arrays;
import java.util.Comparator;

/*
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=190899&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * next permutation. 
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = nums.length-1; j > i; j--) {
				if (nums[i] < nums[j]) {
					swap(nums, i, j);
					Arrays.sort(nums,i+1,nums.length);
					return;
				}
			}
		}
		Arrays.sort(nums);
	}


	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{4,2,0,2,3,2,0};
		NextPermutation np = new NextPermutation();
		np.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
