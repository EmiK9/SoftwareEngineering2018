import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanMap {
	
	boolean[][] oceanGrid = new boolean[25][25];
	final int dimensions = 25;
	
	public OceanMap(int dimensions, int islandCount) {}
	
	//Creates map by iterating through each square and coloring it green for land and blue for water
	public void drawMap(ObservableList<Node> root, boolean[][] islandGrid, int scale) {
		for (int x=0; x<dimensions; x++) {
			for (int y=0; y<dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (islandGrid[x][y] == true) {
					rect.setFill(Color.GREEN);
					root.add(rect);
					oceanGrid[x][y] = true;
				}
				else {
					rect.setFill(Color.PALETURQUOISE);
					root.add(rect);
					oceanGrid[x][y] = false;
				}
			}
		}
	}
	
	//Sets the oceanGrid at (x, y) to true
	public void setAt(int x, int y) {
		oceanGrid[x][y] = true;
	}
	
	//Returns the boolean at (x, y) of oceanGrid
	public boolean getAt(double x, double y) {
		return oceanGrid[(int)x][(int)y];
	}
}
