package application;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Quincy
 */
public class GUI extends Application {
    
    static String user = "dqsz@gsu.edu";
    static String password = "dqsz123";
    static String checkEmail, checkPass;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage loginStage) {
        
        //creating the homeScreen pane
        GridPane login = new GridPane();
        
        //creating the size for the homeScreen pane
        login.setMinSize(500,300);
        
        //creating the text for welcoming to the login screen
        Text text0 = new Text("Welcome to Nile");
        login.add(text0, 1,0);
        
        //creating the text area label for email
        Text text1 = new Text("Email ");
        login.add(text1, 0,4);
        
        //creating the text area label for password
        Text text2 = new Text("Password ");
        login.add(text2, 0,5);
        
        //creating textfield for email
        final TextField email = new TextField();
        email.setPromptText("email");
        login.add(email, 1,4);
        
        //creating the password textfield
        final PasswordField pass = new PasswordField();
        pass.setPromptText("password");
        login.add(pass, 1,5);
        
        //creating the login button after user inputs information
        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(80);
        login.add(loginButton, 1,8);
        loginButton.setId("loginButton");
        
        //Label to show if email and password are correct
        final Label fail = new Label();
        login.add(fail, 1,7);
        
        //Setting the padding  
        login.setPadding(new Insets(10, 10, 10, 10)); 
      
        //Setting the vertical and horizontal gaps between the columns 
        login.setVgap(5); 
        login.setHgap(5);
        
        //Alignment of the homeScreen
        login.setAlignment(Pos.CENTER);
        
        //Styling the nodes
        text0.setStyle("-fx-font: normal bold 36px 'times new roman' ");
        text1.setStyle("-fx-font: normal bold 24px 'times new roman' "); 
        text2.setStyle("-fx-font: normal bold 24px 'times new roman' ");
        fail.setStyle("-fx-font: normal bold 18px 'times new roman' ");
        loginButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        login.setStyle("-fx-background-color: beige;");
        
        //Scene
        Scene scene = new Scene(login);
        
        //Title for the login stage
        loginStage.setTitle("Login");
        
        //Sets the scene to the login stage
        loginStage.setScene(scene);
        
        //Displays the GUI
        loginStage.show();
        
        //closes all the windows when 'X' is pressed
        loginStage.setOnCloseRequest(e -> Platform.exit());
        
    loginButton.setOnAction(e-> {
        //Determines if email and password are correct
        checkEmail = email.getText().toString();
        checkPass = pass.getText().toString();
        if(checkEmail.equals(user) && checkPass.equals(password)){
        
        //hides the login screen once login is successful
        ((Node)e.getSource()).getScene().getWindow().hide();
        Parent homeScreen = new homeScreen().getView();
        Stage home = new Stage();
        home.initOwner(loginButton.getScene().getWindow());
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
        }
        else{
           fail.setText("Incorrect email and/or password");
           fail.setTextFill(Color.RED);
        }
        email.setText("");
        pass.setText("");
    
        });
}
}
    


