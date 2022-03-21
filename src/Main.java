
import gui.Main_Grid;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main Method For my system
 * @author BONGINKOSI
 *
 */
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
				
	}

	@Override
	public void start(Stage primary) throws Exception {
		
		//Initializing Graphic User Interface
		primary.setTitle("See Eye");
		Main_Grid layout = new Main_Grid(primary);
		layout.setStyle("-fx-background-image: url('./gui//Backround.jpg');"
				+ "-fx-width: 100%;"
				+ "-fx-height: 400px;"
				+ "-fx-background-size: 100% 100%;");
		Scene  scene = new Scene(layout,650,650);
		primary.setScene(scene);
		primary.show();
	}
}
