import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ThreadLocalRandom;

public class PirateShip implements Observer {

	OceanMap oceanMap;
	Point currentLocation;
	Point shipLocation;
	
	//Initializes pirate ship location to random point that is not already occupied
	public PirateShip(OceanMap oceanMap) {
		int x = 0, y = 0;
		currentLocation.setLocation(0, 0);
		while (oceanMap.getAt(currentLocation.getX(), currentLocation.getY())) {
			x = ThreadLocalRandom.current().nextInt(0, 25+1);
			y = ThreadLocalRandom.current().nextInt(0, 25+1);;
			currentLocation.setLocation(x, y);
		}
		oceanMap.setAt(x, y);
	}
	
	//Moves the pirate ship when the ship is updated
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Ship) {
			shipLocation = ((Ship)o).getShipLocation();
			movePirate();
		}
	}
	
	//Returns the current location of the pirate ship
	public Point getShipLocation() {
		return currentLocation;
	}
	
	//Pirate ship will move closer to ship in each axis direction if possible
	public void movePirate() {
		if (shipLocation.getX() > currentLocation.getX()) {
			currentLocation.setLocation(currentLocation.getX()+1, currentLocation.getY());
		}
		else if (shipLocation.getX() < currentLocation.getX()) {
			currentLocation.setLocation(currentLocation.getX()-1, currentLocation.getY());
		}
		if (shipLocation.getY() > currentLocation.getY()) {
			currentLocation.setLocation(currentLocation.getX(), currentLocation.getY()+1);
		}
		else if (shipLocation.getY() < currentLocation.getY()) {
			currentLocation.setLocation(currentLocation.getX(), currentLocation.getY()-1);
		}
	}
}
