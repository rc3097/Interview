package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Q218 {
	private class Height {
		int index = 0;
		int height = 0;

		public Height(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}

	public List<int[]> getSkyline(int[][] buildings) {
		ArrayList<Height> heights = new ArrayList<Height>();
		for (int i = 0; i < buildings.length; i++) {
			Height h1 = new Height(buildings[i][0], buildings[i][2]);
			Height h2 = new Height(buildings[i][1], -buildings[i][2]);
			heights.add(h1);
			heights.add(h2);
		}

		Collections.sort(heights, new Comparator<Height>() {
			public int compare(Height o1, Height o2) {
				// TODO Auto-generated method stub
				if (o1.index != o2.index) {
					return o1.index - o2.index;
				}
				return o2.height - o1.height;
			}
		});

		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(10,new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return -Integer.compare(o1, o2);
			}
		});
		ArrayList<int[]> results = new ArrayList<int[]>();
		maxheap.offer(0);
		for (Height h : heights) {
			if (h.height > 0) {
				if (maxheap.isEmpty() || maxheap.peek() < h.height) {
					results.add(new int[] { h.index, h.height });
					System.out.println(h.index+";"+h.height);
				}
				maxheap.offer(h.height);
			} else {
				if (maxheap.peek() == -h.height) {
					maxheap.poll();
					if (maxheap.peek() != -h.height) {
						results.add(new int[] { h.index, maxheap.peek() });
						System.out.println(h.index+";"+maxheap.peek());
					}
				} else {
					maxheap.remove(-h.height);
				}
			}
		}
		return results;
	}
}