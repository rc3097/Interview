package amazon.elevatorSystem;

import java.util.*;

public class RequestProcessCenter implements Runnable {
	HashSet<Integer> queue = new HashSet();

	private Elevator elevator;
	private static RequestProcessCenter center;

	private RequestProcessCenter(Elevator elevator) {
		this.elevator = elevator;
	}

	public synchronized static RequestProcessCenter getInstance() {
		if (center == null) {
			center = new RequestProcessCenter(new Elevator("elevator 1"));
		}
		return center;
	}

	public void addRequest(Request req) {
		int cur = elevator.getCurrentFloor();
		System.out.println(req.getToFloor() + " Floor, please");
		if (req.getToFloor() == cur)
			return;
		queue.add(req.getToFloor());
	}

	public void run() {
		while (true) {
			if (queue.isEmpty())
				continue;
			Integer toFloor;
			if (elevator.isUp()) {
				toFloor = getUpClosetFloor(queue, elevator.getCurrentFloor());
				if (toFloor == null) {
					toFloor = getDownClosetFloor(queue,
							elevator.getCurrentFloor());
				}
			} else {
				toFloor = getDownClosetFloor(queue, elevator.getCurrentFloor());
				if (toFloor == null) {
					toFloor = getUpClosetFloor(queue,
							elevator.getCurrentFloor());
				}
			}
			elevator.moveToFloor(toFloor);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private Integer getUpClosetFloor(HashSet<Integer> queue, int cur) {
		Integer nextFloor = null;
		for (int floor : queue) {
			if (floor > cur) {
				nextFloor = (nextFloor == null) ? floor : nextFloor;
				nextFloor = (nextFloor - cur > floor - cur) ? floor : nextFloor;
			}
		}
		if (nextFloor != null)
			queue.remove(nextFloor);
		return nextFloor;
	}

	private Integer getDownClosetFloor(HashSet<Integer> queue, int cur) {
		Integer nextFloor = null;
		for (int floor : queue) {
			if (floor < cur) {
				nextFloor = (nextFloor == null) ? floor : nextFloor;
				nextFloor = (Math.abs(nextFloor - cur) > Math.abs(floor - cur)) ? floor : nextFloor;
			}
		}
		if (nextFloor != null)
			queue.remove(nextFloor);
		return nextFloor;
	}

	public static void main(String[] args) throws InterruptedException {
		RequestProcessCenter center = RequestProcessCenter.getInstance();
		new Thread(center).start();
		Random seed = new Random();
		for (int i = 0; i < 10; i++) {
			User.pressButton(seed.nextInt(30));
			Thread.sleep(3000);
		}
	}

}
