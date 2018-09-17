import java.awt.Point;
import java.util.Observable;
import javafx.scene.image.ImageView;

public class Ship extends Observable {
	
	Point currentLocation;
	OceanMap oceanMap;
	ImageView shipImageView;

	//Initializes ship at (0, 0)
	public Ship(OceanMap oceanMap) {
		currentLocation.setLocation(0, 0);
		oceanMap.setAt(0, 0);
	}
	
	//Returns the current location of the ship
	public Point getShipLocation() {
		return currentLocation;
	}
	
	//Increases the ship's x coordinate by 1
	public void goEast() {
		if (currentLocation.getX()+1 <= 50 && !oceanMap.getAt(currentLocation.getX()+1, currentLocation.getY())) {
			currentLocation.setLocation(currentLocation.getX()+1, currentLocation.getY());
		}
	}
	
	//Decreases the ship's x coordinate by 1
	public void goWest() {
		if (currentLocation.getX()-1 >= 0 && !oceanMap.getAt(currentLocation.getX()-1, currentLocation.getY())) {
			currentLocation.setLocation(currentLocation.getX()-1, currentLocation.getY());
		}
	}
	
	//Increases the ship's y coordinate by 1
	public void goNorth() {
		if (currentLocation.getY()+1 <= 50 && !oceanMap.getAt(currentLocation.getX(), currentLocation.getY()+1)) {
			currentLocation.setLocation(currentLocation.getX(), currentLocation.getY()+1);
		}
	}
	
	//Decreases the ship's y coordinate by 1
	public void goSouth() {
		if (currentLocation.getY()-1 >= 0 && !oceanMap.getAt(currentLocation.getX(), currentLocation.getY()-1)) {
			currentLocation.setLocation(currentLocation.getX(), currentLocation.getY()-1);
		}
	}
}
