package amazon.elevatorSystem;

public class Elevator {
	private static Elevator instance = null;
	private static Object lock = new Object();
	private int currentFloor;
	private String name;
	private boolean isUp;
	private int maxFloor;
	private int minFloor;

	public Elevator(String name) {
		this.name = name;
		isUp = true;
		currentFloor = 0;
		maxFloor = 34;
		minFloor = 0;
	}
	
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	public boolean isUp() {
		return isUp;
	}

	public void moveToFloor(Integer toFloor) {
		if (toFloor==null) return;
		if (currentFloor<toFloor) isUp =  true;
		else isUp = false;
		currentFloor = toFloor;
		System.out.println("Now it is "+currentFloor+" Floor!");
	}

	public int getMaxFloor() {
		return maxFloor;
	}

	public int getMinFloor() {
		return minFloor;
	}

}
