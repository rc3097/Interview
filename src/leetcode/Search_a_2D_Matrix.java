package leetcode;
public class Search_a_2D_Matrix {
	public int[][] matrix;
	public int target;
	public int length;
	public int line;

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix==null) return false;
		this.matrix = matrix;
		this.length = matrix[0].length - 1;
		this.target = target;
		if (searchregoin(0, matrix.length - 1, 0, matrix.length - 1)) {
			return search(0, length);
		}
		return false;
	}

	public boolean search(int l, int r) {
		if (r < l)
			return false;

		int mid = (l + r) / 2;
		if (matrix[line][mid] == target) {
			return true;
		}

		if (r == l)
			return false;

		if (matrix[line][mid] < target) {
			return search(mid + 1, r);
		} else {
			return search(l, mid - 1);
		}
	}

	public boolean searchregoin(int ll, int lr, int rl, int rr) {
		if (ll > rr)
			return false;
		if (matrix[ll][0] > target || matrix[rr][length] < target) {
			return false;
		} else {
			if (ll - lr <= 1 && rr - rl <= 1) {
				if (matrix[ll][0] <= target && target <= matrix[ll][length]) {
					line = ll;
				} else {
					line = lr;
				}
				return true;
			}
			int lmid = (ll + lr) / 2;
			int rmid = (rl + rr) / 2;
			if (matrix[lmid][0] == target || matrix[rmid][length] == target) {
				line = rmid;
				return true;
			}
			if (matrix[lmid][0] > target) {
				return searchregoin(ll, lmid - 1, rl, rmid - 1);
			} else if (matrix[rmid][length] < target) {
				return searchregoin(lmid + 1, lr, rmid + 1, rr);
			} else if (matrix[lmid][0] < target
					&& matrix[rmid][length] > target) {
				line=rmid;
				return true;
			}
		}
		return false;
	}
}