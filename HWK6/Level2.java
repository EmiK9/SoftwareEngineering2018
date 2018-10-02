import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Level1 {
	
	int[][] grid = new int[25][25];
	final int dimensions = 25;
	
	public Level1(int dimensions) {}
	
	//Creates map by iterating through each square and coloring it green for land and blue for water
	public void drawMap(ObservableList<Node> root, int scale) {
		for (int x=0; x<dimensions; x++) {
			for (int y=0; y<dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREY);
				root.add(rect);
				grid[x][y] = 0;
			}
		}
	}
	
	//Sets the grid at (x, y) to 0
	public void setAt(int x, int y) {
		grid[x][y] = 0;
	}
	
	//Returns the int at (x, y) of grid
	public int getAt(double x, double y) {
		return grid[(int)x][(int)y];
	}
}
