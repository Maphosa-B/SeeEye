package gui;

//Imports
import java.io.File;
import animals_logic.logic;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This class contains gui logic to display logic results
 * @author BONGINKOSI
 *
 */
public class Details_Gui extends GridPane {
	//Controllers
	private ImageView humanEye = null;
	private ImageView animalEye = null;
	private Image humanImage = null;
	private Image animalImage = null;
	private Label lblHumanView = null;
	private Label lblAnimalView = null;
	private Button btnBack = null;
	private Button btnExit = null;
	private Stage myStage = null;
	private Button btnMoreDetails = null;
	
	
	//Logic Variables
	private String animal = null;
	private File SelectedAnimalFile = null;
	private logic animalImageRequest = null;
	private String details = "";
	
	
	/**
	 * Constructor
	 */
	public Details_Gui(Stage myStage,Image image,String SelectedAnimal,File SelectedAnimalFile ) {
		//Instantiating Logic Variables
		this.myStage = myStage;	
		this.animal = SelectedAnimal;
		this.SelectedAnimalFile = SelectedAnimalFile;
		
		//Grid Properties
		setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(10);
		
	
		//Instantiating Controllers
		animalImageRequest = new  logic(SelectedAnimal,SelectedAnimalFile);
		humanEye = new ImageView();
		animalEye = new ImageView();
		btnMoreDetails = new Button("More Details");
		btnBack = new Button("Back");
		btnExit = new Button("Exit");
		var objAnimal = animalImageRequest.getAnimalView();
		humanImage = image;
		animalImage = objAnimal.image;
		details = objAnimal.Info;
		
		lblAnimalView = new Label(this.animal+" Vision:");
		lblHumanView = new Label("Human Vision:");
		
		//Controllers Properties
		humanEye.setImage(image);
		animalEye.setImage(animalImage);
		humanEye.setFitHeight(300);
		humanEye.setFitWidth(300);
		humanEye.setRotate(0);
		animalEye.setFitHeight(300);
		animalEye.setFitWidth(300);
		btnMoreDetails.setMaxWidth(620);
		btnExit.setMaxWidth(620);
		btnBack.setMaxWidth(620);
		btnMoreDetails.setStyle("-fx-background-color: #676b4a;");

		btnMoreDetails.setMinHeight(30);
		btnBack.setMinHeight(30);
		btnExit.setMinHeight(30);
		
		lblAnimalView.setTextFill(Color.web("#676b4a"));
		lblHumanView.setTextFill(Color.web("#676b4a"));
		
		
		
		
		 
		 if(SelectedAnimal.toUpperCase().equals("SNAKE"))
		 {
			 ColorAdjust colorAdjust = new ColorAdjust();
			 colorAdjust.setContrast(0.1);
			 colorAdjust.setHue(0);
			 colorAdjust.setBrightness(-0.1);
			 colorAdjust.setSaturation(100);
			 animalEye.setEffect(colorAdjust);
		 }
		
		
		setConstraints(lblHumanView,0,0);
		setConstraints(humanEye,0,1);
		setConstraints(lblAnimalView,1,0);
		setConstraints(animalEye,1,1);
		setConstraints(btnMoreDetails,0,2,2,1);
		setConstraints(btnBack,0,3,2,1);
		setConstraints(btnExit,0,4,2,1);
	
		this.getChildren().addAll(lblAnimalView,humanEye,lblHumanView,animalEye,btnMoreDetails,btnBack,btnExit);
		
		
		//Calling Private Methods of button actions
		btnExit_Action();
		btnBack_Action();
		btnMoreDetails_Action();
	}	
	
	/**
	 * Button event action method for encapsulation and code readability
	 */
	private void btnExit_Action()
	{
		btnExit.setOnAction(e->{
			System.exit(0);
		});
	}
	
	/**
	 * Button event action method for encapsulation and code readability
	 */
	private void btnBack_Action()
	{
		btnBack.setOnAction(e->{
			//Changing a scene
			var layout = new Second_Gui(myStage);
			layout.setStyle("-fx-background-image: url('./gui//Backround.jpg');"
					+ "-fx-width: 100%;"
					+ "-fx-height: 400px;"
					+ "-fx-background-size: 100% 100%;");
			
		 	Scene s = new Scene(layout,650,650);
			myStage.setScene(s);
			myStage.show();	
		});
	}
	
	/**
	 * Button event action method for encapsulation and code readability
	 */
	private void btnMoreDetails_Action()
	{
		btnMoreDetails.setOnAction(e->{
			More_Details layout = new More_Details(myStage,humanImage,this.animal,SelectedAnimalFile,details);
			layout.setStyle("-fx-background-image: url('./gui//Backround.jpg');"
					+ "-fx-width: 100%;"
					+ "-fx-height: 400px;"
					+ "-fx-background-size: 100% 100%;");
			
			//Changing a scene
		 	Scene s = new Scene(layout,650,650);
			myStage.setScene(s);
			myStage.show();	
		});
	}
}

