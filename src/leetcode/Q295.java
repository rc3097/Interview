package leetcode;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Q295 {
	static class MedianFinder {
		PriorityQueue<Integer> maxheap;
		PriorityQueue<Integer> minheap;
		public MedianFinder() {
	        // 新建最大堆
	        minheap = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
	            public int compare(Integer i1, Integer i2){
	                return i2 - i1;
	            }
	        });
	        // 新建最小堆
	        maxheap = new PriorityQueue<Integer>();
		}
		// offers a number into the data structure.
		public void addNum(int num) {
			if (maxheap.isEmpty()) {
				maxheap.offer(num);
			} else if (num > maxheap.peek()) {
				maxheap.offer(num);
				if (maxheap.size() - minheap.size() > 1) {
					minheap.offer(maxheap.poll());
				}
			} else if (minheap.isEmpty()) {
				minheap.offer(num);
			} else if (num < minheap.peek()) {
				minheap.offer(num);
				if (minheap.size() - maxheap.size() > 0) {
					maxheap.offer(minheap.poll());
				}
			} else {
				if (maxheap.size() - minheap.size() > 0)
					minheap.offer(num);
				else
					maxheap.offer(num);
			}
		}

		// Returns the median of current data stream
		public double findMedian() {
			int l = minheap.size() + maxheap.size();
			return (l % 2 == 0) ? ((minheap.peek() + maxheap.peek()) * 1.0 / 2)
					: (maxheap.peek());
		}
	};

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(1);
		mf.addNum(2);

		System.out.println(mf.findMedian());

	}
	// Your MedianFinder object will be instantiated and called as such:
	// MedianFinder mf = new MedianFinder();
	// mf.offerNum(1);
	// mf.findMedian();
}
