package utils;

public interface Subject {
	public void registerObservers(Observer o);
	public void unregisterObservers(Observer o);
	public void notifyObservers();
}
