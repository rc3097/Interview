package leetcode;
import java.util.Stack;

public class Q84 {
	public int largestRectangleArea(int[] heights) {
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
