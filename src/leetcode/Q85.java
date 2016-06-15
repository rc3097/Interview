package leetcode;
import java.util.Stack;

public class Q85 {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] heights = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[j][i] == '0') {
					heights[i][j] = 0;
				} else {
					heights[i][j] = (i == 0) ? 1 : heights[i-1][j] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, largestRectangleArea(heights[i]));
		}
		return max;
	}

	private int largestRectangleArea(int[] heights) {
		if (heights.length == 0)
			return 0;
		Stack<Integer> indexstack = new Stack<Integer>();
		indexstack.add(0);
		int max = 0;
		for (int i = 1; i < heights.length; i++) {
			while (!indexstack.isEmpty()
					&& heights[i] < heights[indexstack.peek()]) {
				int index = indexstack.pop();
				int result = indexstack.isEmpty() ? i * heights[index] : (i
						- indexstack.peek() - 1)
						* heights[index];
				if (result > max) {
					max = result;
				}
			}
			indexstack.add(i);
		}
		int i = heights.length;
		while (!indexstack.isEmpty()) {
			int index = indexstack.pop();
			int result = indexstack.isEmpty() ? i * heights[index] : (i
					- indexstack.peek() - 1)
					* heights[index];
			max = Math.max(max, result);
		}
		return max;
	}
}
