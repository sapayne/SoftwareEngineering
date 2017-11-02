package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class confirmationScreen extends Application{
	
	static Stage window;
	Scene scene1;
	Scene scene2;
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	window = primaryStage;
	
	//Sizing and spacing of the GUI
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10, 10, 10, 10));
	grid.setVgap(8);
	grid.setHgap(10);
	
	//Label that shows the user a message during checkout
	Label label1 = new Label("Thank You For Shopping With Us");
	GridPane.setConstraints(label1, 10, 10);
	
	Label label2 = new Label("Your Order has been processed");
	GridPane.setConstraints(label2, 10, 11);
	
	//Ok button that goes back to the home page
	Button button1 = new Button("ok");
	GridPane.setConstraints(button1, 10, 12);
	button1.setOnAction(e -> window.setScene(scene2));
	
	grid.getChildren().addAll(label1, label2, button1);
	scene1 = new Scene(grid, 500, 500);
	
	//Place Holder for homepage
	Button button2 = new Button("Back to Confirmation Screen");
	button2.setOnAction(e -> window.setScene(scene1));
	
	StackPane layout2 = new StackPane();
	layout2.getChildren().add(button2);
	scene2 = new Scene(layout2, 500, 500);
	
	//the tile of the GUI
	//Shows the scene as scene1
	window.setScene(scene1);
	window.setTitle("Confirmation Screen");
	window.show();
	} 
	
}
