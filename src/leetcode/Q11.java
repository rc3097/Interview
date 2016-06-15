package leetcode;
public class Q11 {
	public int maxArea(int[] height) {
		int n = height.length;
		int left = 0;
		int right = n - 1;

		int max = Math.min(height[right], height[left]) * (right - left );
		while (left < right) {
			if (height[right] > height[left]) {
				left++;
			} else if (height[right] < height[left]) {
				right--;
			} else {
				left++;
				right--;
			}
			max = Math.max(max, Math.min(height[left], height[right])*(right - left ));
		}
		
		return max;
	}
}