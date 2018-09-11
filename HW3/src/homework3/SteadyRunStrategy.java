package homework3;
import java.util.Observable;

public class SteadyRunStrategy extends Strategy {
	
	public SteadyRunStrategy() {}
	
	public void update(Observable o, long arg) {
		double time = arg / 1000000000; //Convert nanoseconds to seconds
		double speedSec = distance / 3600; //Convert miles/hour to miles/second
		distance += (speedSec * 0.80) / time; //Add 80% speed for entire race
	}
}
