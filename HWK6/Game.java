ooimport java.util.concurrent.ThreadLocalRandom;
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

public class Game extends Application {
	
	int[][] map = new int[25][25];
	Pane root;
	final int dimensions = 10;
	final int scalingFactor = 50;
	Image chipImage;
	ImageView chipImageView;
	Level1 level1;
	Level2 level2;
	Scene scene;
	Chip chip;

	public void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {
		level1 = new Level1(dimensions);
		
		root = new AnchorPane();
		level1.drawMap((ObservableList<Node>) root, scalingFactor);
		
		chip = new Chip(map);
		loadChipImageDown();
		
		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.setTitle("Chip Game");
		stage.show();
		walk();
		
	}

	//Loads chip images onto screen
	public void loadChipImageRight() {
		Image chipImage = new Image("textures\\chipRight.png", 50, 50, true, true);
		chipImageView = new ImageView(chipImage);
		chipImageView.setX(chip.getChipLocation().x*scalingFactor);
		chipImageView.setY(chip.getChipLocation().y*scalingFactor);
	}
	
	public void loadChipImageLeft() {
		Image chipImage = new Image("textures\\chipLeft.png", 50, 50, true, true);
		chipImageView = new ImageView(chipImage);
		chipImageView.setX(chip.getChipLocation().x*scalingFactor);
		chipImageView.setY(chip.getChipLocation().y*scalingFactor);
	}
	
	public void loadChipImageUp() {
		Image chipImage = new Image("textures\\chipUp.png", 50, 50, true, true);
		chipImageView = new ImageView(chipImage);
		chipImageView.setX(chip.getChipLocation().x*scalingFactor);
		chipImageView.setY(chip.getChipLocation().y*scalingFactor);
	}
	
	public void loadChipImageDown() {
		Image chipImage = new Image("textures\\chipDown.png", 50, 50, true, true);
		chipImageView = new ImageView(chipImage);
		chipImageView.setX(chip.getChipLocation().x*scalingFactor);
		chipImageView.setY(chip.getChipLocation().y*scalingFactor);
	}
	
	//Handles key event for chip
	private void walk() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {
					case RIGHT:
						chip.goRight();
						chipImageView.setX(chip.getChipLocation().x*scalingFactor);
						chipImageView.setY(chip.getChipLocation().y*scalingFactor);
						loadChipImageRight();
						break;
					case LEFT:
						chip.goLeft();
						chipImageView.setX(chip.getChipLocation().x*scalingFactor);
						chipImageView.setY(chip.getChipLocation().y*scalingFactor);
						loadChipImageLeft();
						break;
					case UP:
						chip.goUp();
						chipImageView.setX(chip.getChipLocation().x*scalingFactor);
						chipImageView.setY(chip.getChipLocation().y*scalingFactor);
						loadChipImageUp();
						break;
					case DOWN:
						chip.goDown();
						chipImageView.setX(chip.getChipLocation().x*scalingFactor);
						chipImageView.setY(chip.getChipLocation().y*scalingFactor);
						loadChipImageDown();
						break;
					default:
						break;
				}
			}
		});
	}
}
