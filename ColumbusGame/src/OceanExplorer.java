import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OceanExplorer extends Application {
	
	boolean[][] islandMap = new boolean[25][25];
	Pane root;
	final int dimensions = 10;
	final int islandCount = 10;
	final int scalingFactor = 50;
	Image shipImage;
	ImageView shipImageView;
	ImageView pshipImageView1;
	ImageView pshipImageView2;
	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	PirateShip pship1;
	PirateShip pship2;

	public void main(String[] args) {
		launch(args);
	}

	//Starts the game by creating the map with random islands, creating the ship at (0, 0),
	//creating two pirate ships at random locations, and starting the event handler
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage oceanStage) throws Exception {
		oceanMap = new OceanMap(dimensions, islandCount);
		
		root = new AnchorPane();
		randomizeIslands();
		oceanMap.drawMap((ObservableList<Node>) root, islandMap, scalingFactor);
		
		ship = new Ship(oceanMap);
		loadShipImage();
		pship1 = new PirateShip(oceanMap);
		loadPirateShipImage1();
		pship2 = new PirateShip(oceanMap);
		loadPirateShipImage2();
		
		Scene scene = new Scene(root, 500, 500);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Columbus Game");
		oceanStage.show();
		startSailing();
		
	}	
	
	//Function for randomizing "Trues" in islandMap
	public void randomizeIslands() {
		int count = 0;
		while (count < islandCount) {
			int x = ThreadLocalRandom.current().nextInt(0, 25+1);
			int y = ThreadLocalRandom.current().nextInt(0, 25+1);;
			if (islandMap[x][y] != true) {
				islandMap[x][y] = true;
				count++;
			}
		}
	}

	//Loads ship images onto screen
	public void loadShipImage() {
		Image shipImage = new Image("images\\ColumbusShip.png", 50, 50, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().x*scalingFactor);
		shipImageView.setY(ship.getShipLocation().y*scalingFactor);
	}
	
	public void loadPirateShipImage1() {
		Image shipImage = new Image("images\\PirateShip.png", 50, 50, true, true);
		pshipImageView1 = new ImageView(shipImage);
		pshipImageView1.setX(pship1.getShipLocation().x*scalingFactor);
		pshipImageView1.setY(pship1.getShipLocation().y*scalingFactor);
	}
	
	public void loadPirateShipImage2() {
		Image shipImage = new Image("images\\PirateShip.png", 50, 50, true, true);
		pshipImageView2 = new ImageView(shipImage);
		pshipImageView2.setX(pship2.getShipLocation().x*scalingFactor);
		pshipImageView2.setY(pship2.getShipLocation().y*scalingFactor);
	}
	
	//Handles key event for ship and updates pirate ship locations as the ship moves
	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {
					case RIGHT:
						ship.goEast();
						break;
					case LEFT:
						ship.goWest();
						break;
					case UP:
						ship.goNorth();
						break;
					case DOWN:
						ship.goSouth();
						break;
					default:
						break;
				}
				pship1.update(ship, 0);
				pship2.update(ship, 0);
				shipImageView.setX(ship.getShipLocation().x*scalingFactor);
				shipImageView.setY(ship.getShipLocation().y*scalingFactor);
				pshipImageView1.setX(pship1.getShipLocation().x*scalingFactor);
				pshipImageView1.setY(pship1.getShipLocation().y*scalingFactor);
				pshipImageView2.setX(pship2.getShipLocation().x*scalingFactor);
				pshipImageView2.setY(pship2.getShipLocation().y*scalingFactor);
			}
		});
	}
}
