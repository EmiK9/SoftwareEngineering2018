package homework3;
import java.util.Observable;

public class EarlySprintStrategy extends Strategy {
	
	public EarlySprintStrategy() {}
	
	public void update(Observable o, long arg) {
		double time = arg / 1000000000; //Convert nanoseconds to seconds
		double speedSec = distance / 3600; //Convert miles/hour to miles/second
		if (distance < 2) { //If in first two miles add full speed
			distance += speedSec / time;
		} else { //Otherwise add 75% speed
			distance += (speedSec * 0.75) / time;
		}
	}
}
