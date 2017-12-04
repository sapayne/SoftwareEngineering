package application;

import Database.database;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class confirmationScreen {
	
	private GridPane confirm;
    database product = new database();

	
	public confirmationScreen() {
            
	//Sizing and spacing of the GUI
	confirm = new GridPane();
	confirm.setPadding(new Insets(10, 10, 10, 10));
	confirm.setVgap(8);
	confirm.setHgap(10);
	
	//Label that shows the user a message during checkout
	Label label1 = new Label("Thank You For Shopping With Us");
	GridPane.setConstraints(label1, 5, 5);
	
	Label label2 = new Label("Your Order has been processed");
	GridPane.setConstraints(label2, 5, 6);
	
	//Ok button that goes back to the home page
	Button button1 = new Button("Return to Homepage");
        button1.setOnAction(e -> {
                    //hides the login screen once login is successful
                    ((Node)e.getSource()).getScene().getWindow().hide();
                    Parent homeScreen = new homeScreen().getView();
                    Stage home = new Stage();
                    home.initOwner(button1.getScene().getWindow());
                    //display home page
                    Scene homeScene = new Scene(homeScreen, 1600, 900);
                    home.setScene(homeScene);
                    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

                    //set Stage boundaries to visible bounds of the main screen
                    home.setX(primaryScreenBounds.getMinX());
                    home.setY(primaryScreenBounds.getMinY());
                    home.setWidth(primaryScreenBounds.getWidth());
                    home.setHeight(primaryScreenBounds.getHeight());
                    home.show();
        });
	GridPane.setConstraints(button1, 5, 7);
	
	confirm.getChildren().addAll(label1, label2, button1);
        confirm.setStyle("-fx-background-color: white;");
	}
        public Parent getView(){
            return confirm;
        }
	
}
