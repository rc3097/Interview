package facebook;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageofAnInputStream {
	Queue<Integer> queue = new LinkedList<Integer>();
	private int windowSize;
	private int sum;
	
	public MovingAverageofAnInputStream(int windowSize) {
		this.windowSize = windowSize;
	}
	public double movingAverage(int num) {
		sum+=num;
		queue.add(num);
		if (queue.size()>windowSize) 
			sum -= queue.poll();
		return Double.valueOf(String.format("%.2f", 1.0*sum/queue.size()));
	}
	
	public static void main(String[] args) {
		MovingAverageofAnInputStream q = new MovingAverageofAnInputStream(3);
		
		System.out.println(q.movingAverage(1));
		System.out.println(q.movingAverage(1));
		System.out.println(q.movingAverage(2));
		System.out.println(q.movingAverage(3));
		System.out.println(q.movingAverage(3));
		System.out.println(q.movingAverage(4));
		System.out.println(q.movingAverage(4));
		System.out.println(q.movingAverage(4));
		System.out.println(q.movingAverage(5));
	}
	
}
