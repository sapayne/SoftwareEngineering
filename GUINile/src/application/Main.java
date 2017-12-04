package application;

import database.database;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	
	Stage window;
	Scene scene1;
	Scene scene2;
    database product = new database();

	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	window = primaryStage;
	
	Label label1 = new Label("Thank You For Shopping With Us");
	Label label2 = new Label("Your Order has been processed");
	Button button1 = new Button("Ok");
	button1.setOnAction(e -> window.setScene(scene2));
	
	VBox layout1 = new VBox(100);
	layout1.getChildren().addAll(label1, label2, button1);
	scene1 = new Scene(layout1, 500, 500);
	
	//Place Holder for homepage
	Button button2 = new Button("Back");
	button2.setOnAction(e -> window.setScene(scene1));
	
	StackPane layout2 = new StackPane();
	layout2.getChildren().add(button2);
	scene2 = new Scene(layout2, 500, 500);
	
	window.setScene(scene1);
	window.setTitle("Confirmation Screen");
	window.show();
	} 
	
}
