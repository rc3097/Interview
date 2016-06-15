package leetcode;
public class RangeMax {
	private class ST {
		int max;
		int l, r;
		ST left, right;

		public ST(int l, int r, int max) {
			this.l = l;
			this.r = r;
			this.max = max;
		}
	}

	ST root = null;

	public RangeMax(int[] nums) {
		this.root = buildST(nums, 0, nums.length - 1);
	}

	private ST buildST(int[] nums, int start, int end) {
		// TODO Auto-generated method stub
		if (start == end) {
			ST root = new ST(start, end, nums[start]);
			return root;
		}
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		ST root = new ST(start, end, Integer.MIN_VALUE);
		root.left = buildST(nums, start, mid);
		root.right = buildST(nums, mid + 1, end);
		root.max = root.left.max;
		if (root.right != null) {
			root.max = Math.max(root.right.max, root.left.max);
		}
		return root;
	}

	public int getMax(int start, int end) {
		return getMaxST(root, start, end);
	}

	private int getMaxST(ST root, int start, int end) {
		if (start <= root.l && root.r <= end) {
			return root.max;
		}
		if (root.r < start || end < root.l)
			return Integer.MIN_VALUE;
		return Math.max(getMaxST(root.left, start, end),
				getMaxST(root.right, start, end));

	}

	public void update(int num, int i) {
		updateST(root, num, i);
	}

	private void updateST(ST root, int num, int i) {
		// TODO Auto-generated method stub
		if (root.l == i && root.r == i) {
			root.max = num;
			return;
		}
		if (i<root.l || root.r<i) return;
		updateST(root.left, num, i);
		updateST(root.right, num, i);
		root.max = Math.max(root.left.max, root.right.max);
	}
}
