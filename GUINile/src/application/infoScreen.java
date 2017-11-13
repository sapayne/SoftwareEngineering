package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class infoScreen {
	private GridPane info;
	
	
	public infoScreen(){
            
		//Sizing and spacing of the GUi
		info = new GridPane();
		info.setPadding(new Insets(10, 10, 10, 10));
		info.setVgap(8);
		info.setHgap(10);
	
	//Title of the GUI
	Label pageTitle = new Label ("NILE - Personal Info");
	GridPane.setConstraints(pageTitle, 3, 0);
	
	//List of Addresses on File	
	Label shipLabel = new Label("Shipping Info");
	GridPane.setConstraints(shipLabel,  0 ,  1 );
	
	TextField shipInput1 = new TextField("Home");
	GridPane.setConstraints(shipInput1, 1, 1);
	
	TextField shipInput2 = new TextField();
        shipInput2.setPromptText("empty");
	GridPane.setConstraints(shipInput2, 2, 1);
	
	TextField shipInput3 = new TextField();
        shipInput3.setPromptText("empty");
	GridPane.setConstraints(shipInput3, 3, 1);
	
	TextField shipInput4 = new TextField();
        shipInput4.setPromptText("empty");
	GridPane.setConstraints(shipInput4, 4, 1);
	
	TextField shipInput5 = new TextField();
        shipInput5.setPromptText("empty");
	GridPane.setConstraints(shipInput5, 5, 1);
	
	//List of Credit Cards on File
	Label billingLabel = new Label ("Billing Info");
	GridPane.setConstraints(billingLabel, 0, 2);
	
	TextField billingInput1 = new TextField("Home");
	GridPane.setConstraints(billingInput1, 1, 2);
	
	TextField billingInput2 = new TextField();
        billingInput2.setPromptText("empty");
	GridPane.setConstraints(billingInput2, 2, 2);
	
	TextField billingInput3 = new TextField();
        billingInput3.setPromptText("empty");
	GridPane.setConstraints(billingInput3, 3, 2);
	
	TextField billingInput4 = new TextField();
        billingInput4.setPromptText("empty");
	GridPane.setConstraints(billingInput4, 4, 2);
	
	TextField billingInput5 = new TextField();
        billingInput5.setPromptText("empty");
	GridPane.setConstraints(billingInput5, 5, 2);
	
	//List of Payment Methods on File
	Label payLabel = new Label("Payment Info");
	GridPane.setConstraints(payLabel, 0, 3);
	
	TextField payInput1 = new TextField("Visa 9999");
	GridPane.setConstraints(payInput1, 1, 3);
	
	TextField payInput2 = new TextField();
        payInput2.setPromptText("empty");
	GridPane.setConstraints(payInput2, 2, 3);
	
	TextField payInput3 = new TextField();
        payInput3.setPromptText("empty");
	GridPane.setConstraints(payInput3, 3, 3);
	
	TextField payInput4 = new TextField();
        payInput4.setPromptText("empty");
	GridPane.setConstraints(payInput4, 4, 3);
	
	TextField payInput5 = new TextField();
        payInput5.setPromptText("empty");
	GridPane.setConstraints(payInput5, 5, 3);
	
	//ok button to confirm all settings
	Button okButton = new Button("ok");
        okButton.setOnAction(e-> {
            ((Node)e.getSource()).getScene().getWindow().hide();
        });
	GridPane.setConstraints(okButton, 7, 5);
	
	//buttons to add and delete information
	Button addShip = new Button("add");
	GridPane.setConstraints(addShip, 6, 1);
	
	Button deleteShip = new Button("delete");
	GridPane.setConstraints(deleteShip, 7, 1);
	
	Button addBill = new Button("add");
	GridPane.setConstraints(addBill, 6, 2);
	
	Button deleteBill = new Button("delete");
	GridPane.setConstraints(deleteBill, 7, 2);
	
	Button addPay = new Button("add");
	GridPane.setConstraints(addPay, 6, 3);
	
	Button deletePay = new Button("delete");
	GridPane.setConstraints(deletePay, 7, 3);
	
	
	// adds all of these to the grid
	info.getChildren().addAll(pageTitle, shipLabel, shipInput1,  shipInput2, shipInput3, shipInput4, 
			shipInput5, billingLabel, billingInput1, billingInput2, billingInput3, billingInput4, 
			billingInput5, payLabel, payInput1, payInput2, payInput3, payInput4, payInput5, addShip,
			deleteShip, addBill, deleteBill, addPay, deletePay, okButton);
	
	
	info.setStyle("-fx-background-color: white;");
		
	}
        public Parent getView(){
            return info;
        }
	
}
