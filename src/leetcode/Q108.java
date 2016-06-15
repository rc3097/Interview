package leetcode;
import java.util.Arrays;

public class Q108 {

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length==0) return null;
		int r = nums.length - 1;
		int l = 0;
		int mid = (l + r) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		if (mid!=0) root.left =sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
		if (mid+1<nums.length) root.right =sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));
		return root;
	}
}
