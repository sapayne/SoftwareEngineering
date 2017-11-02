package application;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class checkoutScreen extends Application {
	Stage window;
	
	
	public static void main(String[] args){
		launch(args);
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		window.setTitle("Checkout Screen");
		
		//Size and spacing of the GUI
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//title of the GUI
		Label pageTitle = new Label ("Checkout Screen");
		GridPane.setConstraints(pageTitle, 3, 0);
		
		//Displays the shipping address and name of buyer
		
		Label shipAdd = new Label("Name/Address");
		GridPane.setConstraints(shipAdd,  1 ,  1 );
		
		//allows the user to choose from a list of names
		ChoiceBox<String> nameBox = new ChoiceBox<>();
		nameBox.getItems().add("Dudes Name");	
		nameBox.getItems().add("Dudes Wife");	
		nameBox.getItems().add("Dudes Kid");	
		nameBox.getItems().add("Dudes Kid 2");	
		nameBox.getItems().add("Dudes Kid 3");	
		GridPane.setConstraints(nameBox,  2 ,  1 );
		
		//allows the user to choose from a list of addresses
		ChoiceBox<String> shipBox = new ChoiceBox<>();
		shipBox.getItems().add("1234 Somewhere Dr" 
				+ " Nowhere, GA 12345"
				+ " United States");
		shipBox.getItems().add("4321 Somewhere Dr" 
				+ " Nowhere, GA 12345"
				+ " United States");
		shipBox.getItems().add("9876 My Other House" 
				+ " Nowhere, GA 99999"
				+ " United States");
		shipBox.getItems().add("5678 My Apartment St" 
				+ " Nowhere, GA 12789"
				+ " United States");
		shipBox.getItems().add("1235 Somewhere Dr" 
				+ " Nowhere, GA 12345"
				+ " United States");
		GridPane.setConstraints(shipBox,  3 ,  1 );
		
		//Displays the card used and billing address 
		Label payMethod = new Label("Payment Method");
		GridPane.setConstraints(payMethod,  1 ,  2 );
		
		// List of Cards on file
		ChoiceBox<String> cardBox = new ChoiceBox<>();
		cardBox.getItems().add("VISA ending in 9999");	
		cardBox.getItems().add("AMEX ending in 1001");	
		cardBox.getItems().add("DISC ending in 1234");	
		cardBox.getItems().add("VISA ending in 7894");	
		cardBox.getItems().add("MAST ending in 4567");	
		GridPane.setConstraints(cardBox,  2 ,  2 );
		
		//List of Billing Addresses on file
		ChoiceBox<String> billBox = new ChoiceBox<>();
		billBox.getItems().add("1234 Somewhere Dr" 
				+ " Nowhere, GA 12345"
				+ " United States");
		billBox.getItems().add("4321 Somewhere Dr" 
				+ " Nowhere, GA 12345"
				+ " United States");
		billBox.getItems().add("9876 My Other House" 
				+ " Nowhere, GA 99999"
				+ " United States");
		billBox.getItems().add("5678 My Apartment St" 
				+ " Nowhere, GA 12789"
				+ " United States");
		billBox.getItems().add("1235 Somewhere Dr" 
				+ " Nowhere, GA 12345"
				+ " United States");
		GridPane.setConstraints(billBox,  3 ,  2 );
		
		// Displays items and shipping on the GUI
		Label itemandShip = new Label("Items and Shipping");
		GridPane.setConstraints(itemandShip,  1 ,  3 );
		
		//List of Shipping Speeds
		ChoiceBox<String> shiptypeBox = new ChoiceBox<>();
		shiptypeBox.getItems().add("Fast AF");
		shiptypeBox.getItems().add("Fast");
		shiptypeBox.getItems().add("Kinda Fast");
		shiptypeBox.getItems().add("Slow");
		shiptypeBox.getItems().add("Really Slow");
		GridPane.setConstraints(shiptypeBox, 2, 3);
		
		//The name of item bought and the price 
		Label itemBought = new Label ("(MacBook Air 13 in) $2,296.00 Qty: 1");
		GridPane.setConstraints(itemBought, 3, 3);
		
		//The Place Order Button 
		Button placeOrder = new Button("Place Order");
		GridPane.setConstraints(placeOrder, 4, 1);
		
		//Labels for the details of the order 
		Label orderDetail = new Label("Order Summary");
		GridPane.setConstraints(orderDetail, 4, 2);
		
		Label itemDetail = new Label("item: ");
		GridPane.setConstraints(itemDetail, 4, 3);
		
		Label shipDetail = new Label("shipping: ");
		GridPane.setConstraints(shipDetail, 4, 4);
		
		Label subDetail = new Label("subtotal: ");
		GridPane.setConstraints(subDetail, 4, 5);
		
		Label taxDetail = new Label("tax: ");
		GridPane.setConstraints(taxDetail, 4, 6);
		
		Label totalDetail = new Label("total: ");
		GridPane.setConstraints(totalDetail, 4, 7);
		
		//Cost of item, shipping, subtotal, and tax 
		Label itemCost = new Label("$2,295.00 ");
		GridPane.setConstraints(itemCost, 5, 3);
		
		Label shipCost = new Label("$9.99 ");
		GridPane.setConstraints(shipCost, 5, 4);
		
		Label subCost = new Label("$2,304.99 ");
		GridPane.setConstraints(subCost, 5, 5);
		
		Label taxCost = new Label("$138.30");
		GridPane.setConstraints(taxCost, 5, 6);
		
		Label totalCost = new Label("$2,443.29 ");
		GridPane.setConstraints(totalCost, 5, 7);
		
		//adds all the buttons, drop down menus, and labels to the grid
		grid.getChildren().addAll(pageTitle, shipAdd, nameBox, shipBox, payMethod, cardBox, 
				billBox, itemandShip, shiptypeBox, itemBought, placeOrder, orderDetail, 
				itemDetail, shipDetail, subDetail, taxDetail, totalDetail, itemCost,
				shipCost, subCost, taxCost, totalCost);
		
		//sets the size of the scene and adds the grid to the scene
		Scene scene = new Scene(grid, 1000, 300);
		window.setScene(scene);
		window.show();
		
		
	}

}
