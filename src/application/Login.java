/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author qmorr
 */
public class Login extends Application {

    
    @Override
    public void start(Stage loginStage) {
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
            Scene scene = new Scene(root,600,400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            loginStage.setScene(scene);
            loginStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
