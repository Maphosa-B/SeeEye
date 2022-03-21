package gui;

//Imports
import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


/**
 * This class encapsulate Gui for collecting image and selecting animal
 * @author BONGINKOSI
 *
 */
public class Second_Gui extends GridPane {
	//UI Controllers
	private Button btnUploadImage = null;
	private Button btnExplore = null;
	private Button btnExit = null;
	private Button btnBack = null;
	private Label lblError = null;
	private Label lblUploaded = null;
	private ComboBox<String> cmbAnimals = null;
	private Label lblSelectAnimal = null;

	//Logic Variable
	private Stage myStage = null;
	private Image selectedImage = null;
	private File SelectedAnimalFile = null;

	/**
	 * Constructor
	 * @param stage
	 */
	public Second_Gui(Stage stage) {

		this.myStage =stage;
		lblError = new Label("Please upload an image");
		lblUploaded = new Label("Image has been uploaded");
		btnExplore = new Button("Explore");
		btnExit = new Button("Exit");
		btnBack = new Button("Back");
		btnUploadImage = new Button("Upload Image");
		cmbAnimals = new ComboBox<String>();
		lblSelectAnimal = new Label("Please Select An Animal:");
		cmbAnimals.getItems().addAll("Bat","Fly","Snake");
								
		//Grid Properties
		this.setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(10);
		
		//Controllers Properties
		cmbAnimals.setMaxWidth(60);
		cmbAnimals.setMinWidth(600);
		cmbAnimals.setMinHeight(30);
		cmbAnimals.getSelectionModel().selectFirst();
		lblSelectAnimal.setTextFill(Color.web("#e3e0d8"));
		lblError.setTextFill(Color.web("#780101"));
		lblUploaded.setTextFill(Color.web("#195912"));
		lblError.setVisible(false);
		lblUploaded.setVisible(false);
		btnExit.setMinHeight(30);
		btnExit.setMaxWidth(600);
		btnBack.setMinHeight(30);
		btnBack.setMaxWidth(600);
		btnExplore.setMinHeight(30);
		btnExplore.setMaxWidth(600);
		btnExplore.setDisable(true);
		btnExplore.setStyle("-fx-background-color: #676b4a; ");
		btnUploadImage.setMaxWidth(600);
		btnUploadImage.setMinHeight(30);
		btnUploadImage.setStyle("-fx-background-color: #676b4a; ");
		
		//Setting Position on The Grid
		setConstraints(lblSelectAnimal,0,0,2,1);
		setConstraints(cmbAnimals,0,1,2,1);
		setConstraints(lblError,0,2,2,1);
		setConstraints(btnExplore,1,3,1,1);
		setConstraints(btnUploadImage,0,3,1,1);		
		setConstraints(lblUploaded,0,4,2,1);
		setConstraints(btnBack,0,5,2,1);
		setConstraints(btnExit,0,6,2,1);
		
		//Adding controls to grid
		this.getChildren().addAll(lblSelectAnimal,cmbAnimals,btnExit,btnExplore,btnBack,btnUploadImage,lblError,lblUploaded);
		
		//Calling Button Action Events methods
		btnBack_Action();
		btnExit_Action();
		btnImageUploade_Action();
		btnExplore_Action();
	}
	
	/**
	 * Button event action method for encapsulation and code readability
	 */
	private void btnBack_Action()
	{
		btnBack.setOnAction(e->{
			//Changing a scene
			var layout = new Main_Grid(myStage);
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
	private void btnExit_Action()
	{
		btnExit.setOnAction(e->{
			System.exit(0);
		});
	}
	
	/**
	 * Button event action method for encapsulation and code readability
	 */
	private void btnImageUploade_Action()
	{
		btnUploadImage.setOnAction(e->{
			
			FileChooser chooser = new FileChooser();
		    chooser.setTitle("Open File");
		    chooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg"));
		    File file = chooser.showOpenDialog(new Stage());
		    
		    if (file != null) {
		    	this.SelectedAnimalFile = file;
		        btnExplore.setDisable(false);
		        lblUploaded.setVisible(true);
		        lblError.setVisible(false);	        
		        selectedImage =  new Image(file.toURI().toString(), 325, 325, false, false);
		      
		     }else
		     {
		    	lblError.setVisible(true);
		    	lblUploaded.setVisible(false);
		     }
		});
	}
	
	/**
	 * Button event action method for encapsulation and code readability
	 */
	private void btnExplore_Action()
	{
		btnExplore.setOnAction(e->{
			
			String selectedAnimal = cmbAnimals.getValue();
			Details_Gui layout = new Details_Gui(myStage,selectedImage,selectedAnimal,SelectedAnimalFile);
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
