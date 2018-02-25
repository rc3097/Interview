package leetcode;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
	Stack<NestedInteger> stacks = new Stack<NestedInteger>();

	public NestedIterator(List<NestedInteger> nestedList) {
		for (int i = nestedList.size()-1; i >=0; i--) {
			stacks.push(nestedList.get(i));
		}
	}

	public Integer next() {
		NestedInteger current = stacks.pop();
		if (current.isInteger()) {
			return current.getInteger();
		} else {
			for (int i = current.getList().size()-1; i >=0; i--) {
				stacks.push(current.getList().get(i));
			}
			return next();
		}
	}

	@Override
	public void remove() {

	}

	public boolean hasNext() {
		return stacks.isEmpty();
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */
