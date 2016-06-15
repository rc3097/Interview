package leetcode;
public class Minimum_Path_Sum {
	public int minPathSum(int[][] grid) {
		if (grid == null) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] min = normalize(grid);
		for (int i = 1; i < min.length; i++) {
			for (int j = 1; j < min[i].length; j++) {
				if (min[i-1][j]<min[i][j-1]) {
					min[i][j]=min[i-1][j]+grid[i][j];
				} else {
					min[i][j]=min[i][j-1]+grid[i][j];
				}
			}
		}
		return (min[m-1][n-1]);
	}

	public int[][] normalize(int[][] grid) {
		int[][] min = grid;
		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			sum += grid[i][0];
			min[i][0] = sum;
		}
		sum = 0;
		for (int i = 0; i < grid[0].length; i++) {
			sum += grid[0][i];
			min[0][i] = sum;
		}
		return min;
	}
}
