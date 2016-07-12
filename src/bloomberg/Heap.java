package bloomberg;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import utils.BTreePrinter;
import utils.TreeNode;

/*
 * 
 ��ӡ ͦnice��һֱ��ʾ������ûˢ�����Ƶ� ƽʱ��heapҲֱ�ӵ�library ��ز����˺�������lintcode������: http://www.lintcode.com/en/problem/heapify/
 �����ȫ����Ҫ������һ���������� ����һ��heap��binary tree.
 heapify֮��ҪŪ��һ��binary tree �ⲽ�Ƚϼ򵥣�recursion�Ϳ����ˡ�
 http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=194871&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */

public class Heap {
	public TreeNode heapify(int[] nums) {
		if (nums.length == 0)
			return null;
		for (int i = nums.length / 2; i >= 0; i--) {
			heapify(nums,i);
		}
		return buildTreeNode(nums, 0);
	}

	private TreeNode buildTreeNode(int[] nums, int k) {
		if (k >= nums.length) {
			return null;
		}
		TreeNode root = new TreeNode(nums[k]);
		root.left = buildTreeNode(nums, 2 * k + 1);
		root.right = buildTreeNode(nums, 2 * k + 2);
		return root;
	}

	public void heapify(int[] nums, int k) {
		while (k < nums.length && k != -1) {
			int target = -1;
			if (2 * k + 1 < nums.length && nums[k] < nums[2 * k + 1])
				target = 2 * k + 1;
			if (2 * k + 2 < nums.length && nums[k] < nums[2 * k + 2])
				target = (2 * k + 1 >= nums.length || nums[2 * k + 2] > nums[2 * k + 1]) ? 2 * k + 2
						: target;
			if (target != -1) {
				swap(nums, k, target);
			}
			k = target;
		}
	}

	private void swap(int[] nums, int k, int target) {
		int temp = nums[k];
		nums[k] = nums[target];
		nums[target] = temp;
	}

	public static void main(String[] args) {
		Heap q = new Heap();
		TreeNode heap = q.heapify(new int[]{1,2,3,4,5,6,7,8,9});
		BTreePrinter.printNode(heap);
	}

}
