package application;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import database.database;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author qmorr
 */
public class SignUp {
    private GridPane sign;
    database product = new database();

    
    public SignUp() {
        sign = new GridPane();
        sign.setAlignment(Pos.CENTER);
        sign.setPadding(new Insets(10, 10, 10, 10));
        sign.setVgap(12);
	sign.setHgap(10);
        
        Label fnameL = new Label("First Name");
        sign.add(fnameL, 0, 0);
        TextField fname = new TextField();
        sign.add(fname, 1, 0);
        
        Label lnameL = new Label("Last Name");
        sign.add(lnameL, 0, 1);
        TextField lname = new TextField();
        sign.add(lname, 1, 1);
        
        Label emailL = new Label("Email");
        sign.add(emailL, 0, 3);
        TextField email = new TextField();
        sign.add(email, 1, 3);
        
        Label passL = new Label("Password");
        sign.add(passL, 0, 4);
        PasswordField pass = new PasswordField();
        sign.add(pass, 1, 4);
                
        Button btn = new Button();
        btn.setText("Sign Up");
        btn.setOnAction(e-> {
            if(fname.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, sign.getScene().getWindow(), 
            "Form Error!", "Please enter a valid first name");
            return;
        }
            if(lname.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, sign.getScene().getWindow(), 
            "Form Error!", "Please enter a valid last name");
            return;
        }
        if(email.getText().isEmpty() || !email.getText().contains("@") || !email.getText().contains(".")) {
            showAlert(Alert.AlertType.ERROR, sign.getScene().getWindow(), 
            "Form Error!", "Please enter a valid email");
            return;
        }
        if(pass.getText().isEmpty() || pass.getText().contains(" ")) {
            showAlert(Alert.AlertType.ERROR, sign.getScene().getWindow(), 
            "Form Error!", "Please enter a valid password");
            return;
        }
        
        product.add(email.toString(), pass.toString());


        showAlert(Alert.AlertType.CONFIRMATION, sign.getScene().getWindow(), 
        "Registration Successful!", "Welcome " + fname.getText());
            
            //hides the login screen once login is successful
            ((Node)e.getSource()).getScene().getWindow().hide();
            Parent homeScreen = new homeScreen().getView();
            Stage home = new Stage();
            home.initOwner(btn.getScene().getWindow());
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
        btn.setAlignment(Pos.BOTTOM_RIGHT);
        sign.add(btn, 1, 5);
        
    }
    
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    public Parent getView(){
        return sign;
    }
}