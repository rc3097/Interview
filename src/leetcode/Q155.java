package leetcode;
import java.util.Stack;

public class Q155 {
	static class MinStack {
		Stack<Node> stacks = new Stack<Node>();
		int min = Integer.MAX_VALUE;

		public void push(int x) {
			min = Math.min(min, x);
			Node newnode = new Node(x, min);
			stacks.push(newnode);
		}

		public void pop() {
			stacks.pop();
			if (!stacks.isEmpty())
				min = stacks.peek().min;
			else 
				min = Integer.MAX_VALUE;
		}

		public int top() {
			return stacks.peek().value;
		}

		public int getMin() {
			return min;
		}

		class Node {
			int min, value;

			public Node(int value, int min) {
				this.value = value;
				this.min = min;
			}
		}
	}

	public static void main(String[] args) {
		MinStack mStack = new MinStack();
		mStack.push(2);
		mStack.push(0);
		System.out.println(mStack.getMin());
		mStack.pop();
		System.out.println(mStack.getMin());
	}
}