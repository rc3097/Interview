package snapchat;

import java.util.*;

public class CountOfSmallNumbersAfterSelf {
	class Node {
		int count = 0;
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}
	}

	public ArrayList<Integer> countSmaller_BST(int[] nums) {
		ArrayList<Integer> res = new ArrayList();

		if (nums.length < 1)
			return res;
		res.add(0);
		Node root = new Node(nums[nums.length - 1]);
		for (int i = nums.length - 2; i >= 0; i--) {
			res.add(insertNode(root, nums[i]));
		}
		Collections.reverse(res);
		return res;
	}

	private int insertNode(Node root, int target) {
		if (root == null)
			return 0;
		int count = 0;
		if (root.val > target) {
			count = insertNode(root.left, target) + root.count + 1;
			if (root.left == null)
				root.left = new Node(target);
		} else if (root.val < target) {
			root.count++;
			count = insertNode(root.right, target);
			if (root.right == null)
				root.right = new Node(target);
		}
		return count;
	}

	int[] count;

	public int[] countSmaller_MS(int[] nums) {
		count = new int[nums.length];
		int[] indexes = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			indexes[i] = i;
		mergeSort(nums, indexes, 0, nums.length - 1);
		return count;
	}

	private void mergeSort(int[] nums, int[] indexes, int start, int end) {
		if (start >= end)
			return;
		int mid = (start + end) / 2;
		mergeSort(nums, indexes, start, mid);
		mergeSort(nums, indexes, mid + 1, end);
		merge(nums, indexes, start, end);
	}

	private void merge(int[] nums, int[] indexes, int start, int end) {
		int mid = (start + end) / 2;
		int[] newindexes = new int[end - start + 1];
		int leftindex = start;
		int rightindex = mid + 1;
		int index = 0;
		while (index < newindexes.length) {
			if ((leftindex < mid + 1 && nums[indexes[leftindex]] < nums[indexes[rightindex]])
					|| (rightindex > end)) {
				newindexes[index++] = indexes[leftindex];
				if (end >= rightindex) {
					count[indexes[leftindex]] += count[indexes[rightindex]] + 1;
				}
				leftindex++;
			} else {
				newindexes[index++] = indexes[rightindex];
				rightindex++;
			}
		}

		for (int i = 0; i < newindexes.length; i++) {
			indexes[i + start] = newindexes[i];
		}
	}

	public static void main(String[] args) {
		CountOfSmallNumbersAfterSelf q = new CountOfSmallNumbersAfterSelf();
		System.out.println(q.countSmaller_BST(new int[] { 120, 200, 400, 300,
				500 }));
		System.out.println(Arrays.toString(q.countSmaller_MS(new int[] { 120,
				200, 400, 300, 500 })));

	}
}