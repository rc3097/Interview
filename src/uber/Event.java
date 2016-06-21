package uber;


import java.util.ArrayList;

import utils.Observer;
import utils.Subject;

public class Event implements Subject{
	ArrayList<Observer> listeners = new ArrayList<Observer>();

	@Override
	public void notifyObservers() {
		for (Observer o: listeners) 
			o.update();
	}

	@Override
	public void registerObservers(Observer o) {
		listeners.add(o);
	}

	@Override
	public void unregisterObservers(Observer o) {
		listeners.remove(o);
		
	}

}
