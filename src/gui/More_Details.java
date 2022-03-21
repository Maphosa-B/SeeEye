package gui;

//Imports
import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * More detain Gui
 * @author BONGINKOSI
 *
 */
public class More_Details extends GridPane {
	private Stage myStage = null;
	private Image image = null;
	private String animal = null;
	private Button btnBack = null;
	private Button btnExit = null;
	private TextArea txtDetails = null;
	private Label lblTitle = null;
	private File SelectedAnimalFile = null;

	
	/**
	 * Constructor
	 */
	public More_Details(Stage myStage,Image image,String Animal, File SelectedAnimalFile, String Details) {
		//Grid Properties
		setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(10);
		

		
		//Instantiating Variables
		this.myStage = myStage;
		this.image = image;
		this.animal = Animal;
		this.SelectedAnimalFile = SelectedAnimalFile;

		
		btnBack = new Button("Back");
		btnExit = new Button("Exit");
		lblTitle = new Label(this.animal+" Vision Backround Details");
		txtDetails = new TextArea(Details);
		lblTitle.setTextFill(Color.web("#676b4a"));
		lblTitle.setStyle("-fx-font-weight: bold");
		lblTitle.setFont(new Font(18.0));
		
		
		
		btnBack.setMaxWidth(600);
		btnExit.setMaxWidth(600);
		btnBack.setMinWidth(600);
		btnExit.setMinHeight(30);
		btnBack.setMinHeight(30);
		txtDetails.setMinHeight(400);
		txtDetails.setDisable(true);
		txtDetails.setEditable(false);
		txtDetails.setWrapText(true);
		
		setConstraints(lblTitle,0,0,1,1);
		setConstraints(txtDetails,0,3,1,1);
		setConstraints(btnBack,0,5,1,1);
		setConstraints(btnExit,0,6,1,1);
		
		this.getChildren().addAll(lblTitle,txtDetails,btnBack,btnExit);
		
		//Buttons action methods
		btnBackAction();
		btnExit_Action();
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
	private void btnBackAction()
	{
		btnBack.setOnAction(e->{
			Details_Gui layout = new Details_Gui(myStage,image,animal,SelectedAnimalFile);
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


