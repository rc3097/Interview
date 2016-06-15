package leetcode;
import javax.security.auth.x500.X500Principal;

public class Q75 {
	public static void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int index = 0;
		while (right >= index && right >= left) {
			if (nums[index] == 0) {
				int tmp = nums[left];
				nums[left] = 0;
				nums[index] = tmp;
				index++;
				left++;
			} else if (nums[index] == 1) {
				index++;
			} else {
				int tmp = nums[right];
				nums[right] = 2;
				nums[index] = tmp;
				right--;
			}
		}
		System.out.println(nums);
	}
	public static void main(String[] args) {
		int [] nums = {2,0,1,2};
		sortColors(nums);
	}
}