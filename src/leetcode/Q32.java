package leetcode;
import java.util.Stack;

public class Q32 {
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')' && !stack.isEmpty()
					&& s.charAt(stack.peek()) == '(') {
				stack.pop();
				if (stack.isEmpty()) {
					max = Math.max(max, i + 1);
				} else {
					max = Math.max(max, i - stack.peek());
				}

			} else {
				stack.push(i);
			}
		}
		return max;
	}
}