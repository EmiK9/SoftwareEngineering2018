import java.awt.Point;
import java.util.Observable;
import javafx.scene.image.ImageView;

public class Chip extends Observable {
	
	Point currentLocation;
	Map map;
	ImageView chipImageView;

	//Initializes chip at (x, y)
	public Chip(Map map, int x, int y) {
		currentLocation.setLocation(x, y);
		map.setAt(x, y);
	}
	
	//Returns the current location of the ship
	public Point getChipLocation() {
		return currentLocation;
	}
	
	//Increases chip's x coordinate by 1
	public void goRight() {
		if (currentLocation.getX()+1 <= 50 && map.getAt(currentLocation.getX()+1, currentLocation.getY()) > 0) {
			currentLocation.setLocation(currentLocation.getX()+1, currentLocation.getY());
		}
	}
	
	//Decreases chip's x coordinate by 1
	public void goLeft() {
		if (currentLocation.getX()-1 >= 0 && map.getAt(currentLocation.getX()-1, currentLocation.getY()) > 0) {
			currentLocation.setLocation(currentLocation.getX()-1, currentLocation.getY());
		}
	}
	
	//Increases chip's y coordinate by 1
	public void goUp() {
		if (currentLocation.getY()+1 <= 50 && map.getAt(currentLocation.getX(), currentLocation.getY()+1) > 0) {
			currentLocation.setLocation(currentLocation.getX(), currentLocation.getY()+1);
		}
	}
	
	//Decreases chip's y coordinate by 1
	public void goDown() {
		if (currentLocation.getY()-1 >= 0 && map.getAt(currentLocation.getX(), currentLocation.getY()-1) > 0) {
			currentLocation.setLocation(currentLocation.getX(), currentLocation.getY()-1);
		}
	}
}
