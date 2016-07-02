package amazon.elevatorSystem;

public class User {
	public static void pressButton(int toFloor) {
		Request req = new Request(toFloor);
		RequestProcessCenter center = RequestProcessCenter.getInstance();
		center.addRequest(req);
	}
}
