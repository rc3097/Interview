package leetcode;
public class Search_a_2D_Matrix_II {
	public int[][] matrix;
	public int target;
	public int leftline;
	public int rightline;
	public int leftcolumn, rightcolumn;
	public int length;
	public boolean found = false;

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null)
			return false;
		this.matrix = matrix;
		this.target = target;
		this.length = matrix[0].length - 1;
		leftline=0;
		rightline=matrix.length-1;
		for (int i =0; i<(length+1)/2;i++){
			if (found) return true;
			leftcolumn = i;
			rightcolumn=length-i;
			if (searchright(leftline, rightline) && searchleft(leftline,rightline)) {
				
			} else {
				return false;
			}
		}
		if (found) return true;
		leftcolumn=length/2;
		if (searchleft(leftline,rightline)) {
			if (found)  return true;
		}
		
		return false;
	}

	public boolean searchleft(int l, int r) {
		if (matrix[r][leftcolumn] <= target) {
			rightline = r;
			if (matrix[r][leftcolumn] == target) {
				found=true;
			}
			return true;
		}
		if (matrix[l][leftcolumn] > target)
			return false;
		else if (r - l == 1) {
			if (matrix[r][leftcolumn] == target
					|| matrix[l][leftcolumn] == target) {
				found = true;
				return true;
			}
			rightline = l;
			return true;
		} else {
			int mid = (l + r) / 2;
			if (matrix[mid][leftcolumn] < target) {
				return searchleft(mid, r);
			} else {
				return searchleft(l, mid);
			}
		}
	}

	public boolean searchright(int l, int r) {
		if (matrix[l][rightcolumn] >= target) {
			leftline = l;
			if (matrix[l][rightcolumn] == target) {
				found=true;
			}
			return true;
		}
		if (matrix[r][rightcolumn] < target)
			return false;
		else if (r - l == 1) {
			if (matrix[r][rightcolumn] == target
					|| matrix[l][rightcolumn] == target) {
				found = true;
				return true;
			}
			leftline = r;
			return true;
		} else {
			int mid = (l + r) / 2;
			if (matrix[mid][rightcolumn] < target) {
				return searchright(mid, r);
			} else {
				return searchright(l, mid);
			}
		}
	}
}
