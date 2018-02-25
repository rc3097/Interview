package leetcode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

public class Q284 {
	class PeekingIterator implements Iterator<Integer> {

	    Iterator<Integer> iterator;
	    private Integer integer;

	    public PeekingIterator(Iterator<Integer> iterator) {
	        // initialize any member here.
	        this.iterator = iterator;
	        if (iterator.hasNext()) {
	            integer = iterator.next();
	        }

	    }

	    // Returns the next element in the iteration without advancing the iterator.
	    public Integer peek() {
	        return integer;
	    }

	    // hasNext() and next() should behave the same as in the Iterator interface.
	    // Override them if needed.
	    public Integer next() {
	        Integer temp = integer;
	        integer = iterator.hasNext() ? iterator.next() : null; 
	        return temp;
	    }

		@Override
		public void remove() {

		}

		public boolean hasNext() {
	        return integer!=null;
	    }
	}
}
