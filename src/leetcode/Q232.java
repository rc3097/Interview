package leetcode;
import java.util.Stack;

public class Q232 {
	static class MyQueue {
		Stack<Integer> queue = new Stack<Integer>();

		// Push element x to the back of queue.
		public void push(int x) {
			queue.push(x);
		}

		// Removes the element from in front of queue.
		public void pop() {
			Stack<Integer> tempqueue = new Stack<Integer>();
			int qsize = queue.size();
			for (int i = 0; i < qsize; i++) {
				tempqueue.push(queue.pop());
			}
			tempqueue.pop();
			qsize = tempqueue.size();
			for (int i = 0; i < qsize; i++) {
				queue.push(tempqueue.pop());
			}
		}

		// Get the front element.
		public int peek() {
			Stack<Integer> tempqueue = new Stack<Integer>();
			int qsize = queue.size();
			for (int i = 0; i < qsize; i++) {
				tempqueue.push(queue.pop());
			}
			int front = tempqueue.peek();
			qsize = tempqueue.size();
			for (int i = 0; i < qsize; i++) {
				queue.push(tempqueue.pop());
			}
			return front;
		}

		// Return whether the queue is empty.
		public boolean empty() {
			return queue.isEmpty();
		}
	}
	public static void main(String[] args) {
		MyQueue myqueue = new MyQueue();
		myqueue.push(1);
		myqueue.push(2);
		System.out.println(myqueue.peek());
		System.out.println(myqueue.peek());
		myqueue.pop();
		myqueue.pop();
	}
}
