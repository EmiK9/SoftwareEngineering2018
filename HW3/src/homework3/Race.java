package homework3;
import java.util.Arrays;
import java.util.Observable;

public class Race extends Observable{
	Strategy[] horseStrategies = new Strategy[4];
	String[] horseNames = new String[4];
	int[] horseSpeeds = new int[4];
	long startTime;
	
	public Race() {}
	
	public void enrollHorse(String name, int position, int speed, Strategy o) {
		horseStrategies[position] = o; //Adds strategies to strategy array
		horseStrategies[position].setSpeed(speed); //Sets each strategy object's speed
		horseNames[position] = name; //Adds names to name array
		horseSpeeds[position] = speed; //Adds speeds to speed array in case strategy is changed
	}
	
	public void changeStrategy(String name, Strategy o) {
		int index = Arrays.asList(horseNames).indexOf(name); //Can replace a strategy for a horse
		horseStrategies[index] = o;
		horseStrategies[index].setSpeed(horseSpeeds[index]); //Need to reset the speed for the new strategy
	}
	
	public void startRace() {
		for (Strategy horse : horseStrategies) { //Sets all horse distances to 0
			horse.resetDistance();
		}
		startTime = System.nanoTime(); //Initializes time
		runRace();
	}
	
	public void runRace() {
		String winner = null;
		Boolean racing = true;
		while (racing==true) { //Race continues until a horse has run 10 miles
			for (int i=0; i<horseStrategies.length; i++) { //Iterate through each horse
				horseStrategies[i].update(this, System.nanoTime()-startTime); //Update each strategy observer
				int distance = horseStrategies[i].getDistance();
				if (distance >= 10) { //If a horse reaches 10 miles, race is over and it wins
					racing = false;
					winner = horseNames[i];
					break;
				} else {
					System.out.println(horseNames[i]+" has run "+distance+" miles");
				}
			}
		}
		announceWinner(winner);
	}
	
	public void announceWinner(String winner) { //Prints out winning horse
		System.out.println("Winner is "+winner);
	}
}
