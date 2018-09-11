package homework3;
import java.util.Observable;
import java.util.Observer;

public class Strategy implements Observer {
	
	int distance;
	int speed;
	String name;
	
	public Strategy() {}
	
	public void setSpeed(int s) {
		speed = s;
	}
	
	public void resetDistance() {
		distance = 0;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void update(Observable o, Object arg) {}
	
}
