package gui;


//Imports
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Main page gui
 * @author BONGINKOSI
 *
 */
public class Main_Grid extends GridPane {
	//UI Controllers
	private  Button btnStart = null;
	private Button btnExit = null;
	private Label lblDetails = null;
	private Stage myStage = null;
	private Second_Gui layout = null;

	
	//Logic Variables
	Socket socket = null;
	
	/**
	 * Constructor
	 * @param s
	 */
	public Main_Grid(Stage s) {
		//Getting A Stage
		myStage = s;
		
		//Grid Properties
		this.setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(10);
			
		//Initializing Details
		btnStart = new Button("Explore");
		btnExit = new Button("Exit");
				
				
		lblDetails = new Label();
		lblDetails.setMinHeight(100);
		lblDetails.setFocusTraversable(false);
		lblDetails.setWrapText(true);
		lblDetails.setStyle("-fx-font-alignment: center;");
		lblDetails.setTextFill(Color.web("#676b4a"));
		lblDetails.setFont(new Font(18.0));
		lblDetails.setText("Let's explore a world through different species eyes!!");

		
		//Controllers Initial Settings
		btnStart.setMaxWidth(600);
		btnStart.setMaxHeight(600);
		btnStart.setMinHeight(30);
		btnStart.setStyle("-fx-background-color: #676b4a; ");
		btnExit.setMinHeight(30);
		btnExit.setMaxWidth(600);
		lblDetails.setMaxWidth(600);
		
		//Grid Positions
		setConstraints(lblDetails, 0,0);
		setConstraints(btnStart, 0,2);
		setConstraints(btnExit, 0,4);
		
		//Adding elements to layout
		this.getChildren().addAll(lblDetails,btnStart,btnExit);
		
		//Activating private buttons actions
		btnStart_Action();
		btnExit_Action();
		
	}
	
	/**
	 * Button event action method for encapsulation and code readability
	 */
	private void btnStart_Action()
	{	
		btnStart.setOnAction(e->{
						
			try {
				//Connecting to socket
				socket = new Socket("localhost",5000);
				
				layout = new Second_Gui(myStage);
				layout.setStyle("-fx-background-image: url('./gui//Backround.jpg');"
						+ "-fx-width: 100%;"
						+ "-fx-height: 400px;"
						+ "-fx-background-size: 100% 100%;");
				
				System.out.println("Connection has been established on port: "+socket.getPort());
				
				//Changing a scene
			 	Scene s = new Scene(layout,650,650);
				myStage.setScene(s);
				myStage.show();	
			
				
			} catch (UnknownHostException e1) {
				System.err.println("Unable to establich connection due to invalid host name");
			} catch (IOException e1) {
				System.err.println("There was some technical errors, connection cannot be stablished");
			}
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
}
