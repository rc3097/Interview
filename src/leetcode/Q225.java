package leetcode;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;


public class Q225 {
	Queue<Integer> myQueue = new LinkedList<Integer>();
    public void push(int x) {
    	myQueue.add(x);
    	for (int i = 1; i < myQueue.size(); i++) {
			myQueue.add(myQueue.poll());
		}
    }

    // Removes the element on top of the stack.
    public void pop() {
        myQueue.poll();
    }

    // Get the top element.
    public int top() {
        return myQueue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return myQueue.isEmpty();
    }
}
