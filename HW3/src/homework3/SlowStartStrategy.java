package homework3;
import java.util.Observable;

public class SlowStartStrategy extends Strategy {
	
	public SlowStartStrategy() {}
	
	public void update(Observable o, long arg) {
		double time = arg / 1000000000; //Convert nanoseconds to seconds
		double speedSec = distance / 3600; //Convert miles/hour to miles/second
		if (distance < 6) { //If in first six miles add 75% speed
			distance += (speedSec * 0.75) / time;
		} else if (distance < 9) { //In the next 3 miles add 90% speed
			distance += (speedSec * 0.90) / time;
		} else { //At the end add full speed
			distance += speedSec / time;
		}
	}
}
