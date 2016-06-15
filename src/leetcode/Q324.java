package leetcode;
import java.util.Arrays;

public class Q324 {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int median = (nums.length-1) / 2;
		int[] results = new int[nums.length];
		int j = median;
		int index = 0;
		for (int i = nums.length - 1; i >= median && j >= 0; i--) {
			results[index++] = nums[j--];
			if (index < nums.length)
				results[index++] = nums[i];
		}
		
		for (int i = 0; i < results.length; i++) {
			nums[i]=results[i];
		}
	}

}
