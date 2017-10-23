/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author qmorr
 */
public class MainController {
    @FXML
    private Label lblStatus;
    
    @FXML
    private TextField txtEmail;
    
    @FXML
    private TextField txtPassword;
    
    public void Login(ActionEvent event) throws Exception {
        if (txtEmail.getText().equals("dqsz@gsu.edu") && txtPassword.getText().equals("dqsz1234")){
            lblStatus.setText("Login Success.");
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage mainStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
            Scene scene = new Scene(root,600,400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            mainStage.setScene(scene);
            mainStage.show();
        }else{
            lblStatus.setText("Incorrect email and/or password.");
        }
    }
}
