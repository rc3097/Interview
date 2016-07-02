package amazon.elevatorSystem;

public class RequestProcessCenter implements Runnable {
	HashSet<Integer> upQueue = new HashSet();
	HashSet<Integer> downQueue = new HashSet();

	private Elevator elevator;
	private RequestProcessCenter center;
	private RequestProcessCenter(Elevator elevator) {
		this.elevator = elevator;
	}

	public synchronized RequestProcessCenter getInstance(){
		if (this.center == null) {
			this.center = new RequestProcessCenter(new Elevator("elevator 1"));
		} 
		return this.center;
	}

	public void addRequest(Request req) {
		int cur = elevator.getCurrentFloor();
		System.out.println(req.getToFloor()+" Floor, please");
		if (req.getToFloor()==cur) return;
		if (req.getToFloor()> cur) {
			upQueue.add(req.getToFloor());
		} else {
			downQueue.add(getToFloor());
		}
	}

	public void run() {
		while (True) {
			if (upQueue.isEmpty() && downQueue.isEmpty()) continue;
			if (elevator.isUp()) {
				Integer toFloor = getUpClosetFloor(upQueue, elevator.getCurrentFloor());
				if (toFloor==null) {
					toFloor = getDownClosetFloor(downQueue, elevator.getCurrentFloor());
				}
			} else {
				Integer toFloor = getDownClosetFloor(downQueue, elevator.getCurrentFloor());
				if (toFloor==null) {
					toFloor = getUpClosetFloor(upQueue, elevator.getCurrentFloor());
				}
			}
			elevator.moveToFloor(toFloor);
			Thread.sleep(2);
		}
	}

	private Integer getUpClosetFloor(HashSet<Integer> queue, int cur) {
		Integer nextFloor = null;
		for (int floor: queue) {
			if (floor> cur) {
				nextFloor= (nextFloor== null)?floor:nextFloor;
				nextFloor =  (nextFloor-cur>floor - cur)? floor: nextFloor;
			}
		}
		return nextFloor;
	}

	private Integer getDownClosetFloor(HashSet<Integer> queue, int cur) {
		Integer nextFloor = null;
		for (int floor: queue) {
			if (floor<cur) {
				nextFloor = (nextFloor==null)? floor: nextFloor;
				nextFloor= (nextFloor-cur>floor - cur)? floor:nextFloor;
			}
		}
		return nextFloor;
	}
  
}
