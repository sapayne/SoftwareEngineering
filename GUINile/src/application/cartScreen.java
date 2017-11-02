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

public class cartScreen extends Application {
	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//The title of the GUI
		window = primaryStage;
		window.setTitle("cartScreen");
		
		//sizing and spacing of the GUI
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//The drop down menu for selecting cateogory
		ChoiceBox<String> categoryBox = new ChoiceBox<>();
		categoryBox.getItems().add("Electronics");
		categoryBox.getItems().add("Books");
		categoryBox.getItems().add("Movies");
		categoryBox.getItems().add("Clothes");
		categoryBox.getItems().add("Outdoors");
		categoryBox.getItems().add("Appliances");
		categoryBox.getItems().add("Automotives");
		categoryBox.getItems().add("Arts and Crafts");
		categoryBox.getItems().add("Babies");
		categoryBox.getItems().add("Software and Games");
		GridPane.setConstraints(categoryBox, 0, 0);
		
		//The search bar 
		TextField searchBar = new TextField("search");
		GridPane.setConstraints(searchBar, 1, 0);
		
		//The search button
		Button searchButton = new Button("Search");
		GridPane.setConstraints(searchButton, 2, 0);
		
		//Row of Buttons and drop down for the task bar on the Nile 
		Button browHist = new Button("Browsing History");
		GridPane.setConstraints(browHist, 0, 1);
		
		Button todayDeal = new Button("Today's Deal");
		GridPane.setConstraints(todayDeal, 1, 1);
		
		Button giftCard = new Button("Gift Card");
		GridPane.setConstraints(giftCard, 2, 1);
		
		Button sellButton = new Button("Sell");
		GridPane.setConstraints(sellButton, 3, 1);
		
		Button helpButton = new Button("Help");
		GridPane.setConstraints(helpButton, 4, 1);
		
		//Allows the user to select from a number of languages
		ChoiceBox<String> langSelect = new ChoiceBox<>();
		langSelect.getItems().add("English");
		langSelect.getItems().add("Chinese");
		langSelect.getItems().add("Japanese");
		langSelect.getItems().add("Korean");
		langSelect.getItems().add("Vietnamese");
		langSelect.getItems().add("British English");
		langSelect.getItems().add("French");
		langSelect.getItems().add("German");
		langSelect.getItems().add("Italian");
		langSelect.getItems().add("Spanish");
		GridPane.setConstraints(langSelect, 5, 1);
		
		Button yourAcc = new Button("Your Account");
		GridPane.setConstraints(yourAcc, 6, 1);
		
		Button ordersButton = new Button("Orders");
		GridPane.setConstraints(ordersButton, 7, 1);
		
		Button cartButton = new Button("Cart");
		GridPane.setConstraints(cartButton, 8, 1);
		
				//Label for price and Quantity
				Label priceLabel = new Label("Price");
				GridPane.setConstraints(priceLabel, 4, 2);
				
				Label quantityLabel = new Label("Quantity");
				GridPane.setConstraints(quantityLabel, 6, 2);
				
				//Shows the the products in the cart 
				Label productInfo1 = new Label("(MacBook Pro 15 in)");
				GridPane.setConstraints(productInfo1, 0, 3);
				
				Label productInfo2 = new Label("Apple Watch Series 3");
				GridPane.setConstraints(productInfo2, 0, 4);
				
				Label productInfo3 = new Label("(MacBook Pro 13 in)");
				GridPane.setConstraints(productInfo3, 0, 5);
				
				//Prices of the products in the cart
				Label productPrice1 = new Label("$2,295.00");
				GridPane.setConstraints(productPrice1, 4, 3);
				
				Label productPrice2 = new Label("$429.00");
				GridPane.setConstraints(productPrice2, 4, 4);
				
				Label productPrice3 = new Label("$1999.00");
				GridPane.setConstraints(productPrice3, 4, 5);
				
				//Drop down for select quantity
				ChoiceBox<String> quantitySelect1 = new ChoiceBox<>();
				quantitySelect1.getItems().add("1");
				quantitySelect1.getItems().add("2");
				quantitySelect1.getItems().add("3");
				quantitySelect1.getItems().add("4");
				quantitySelect1.getItems().add("5");
				GridPane.setConstraints(quantitySelect1, 6, 3);
				
				ChoiceBox<String> quantitySelect2 = new ChoiceBox<>();
				quantitySelect2.getItems().add("1");
				quantitySelect2.getItems().add("2");
				quantitySelect2.getItems().add("3");
				quantitySelect2.getItems().add("4");
				quantitySelect2.getItems().add("5");
				GridPane.setConstraints(quantitySelect2, 6, 4);
				
				ChoiceBox<String> quantitySelect3 = new ChoiceBox<>();
				quantitySelect3.getItems().add("1");
				quantitySelect3.getItems().add("2");
				quantitySelect3.getItems().add("3");
				quantitySelect3.getItems().add("4");
				quantitySelect3.getItems().add("5");
				GridPane.setConstraints(quantitySelect3, 6, 5);
				
				//Delete Button for products in the cart
				Button deleteButton1 = new Button("delete");
				GridPane.setConstraints(deleteButton1, 7, 3);

				Button deleteButton2 = new Button("delete");
				GridPane.setConstraints(deleteButton2, 7, 4);
				
				Button deleteButton3 = new Button("delete");
				GridPane.setConstraints(deleteButton3, 7, 5);
				
				//Save for Later button for products in cart
				Button saveButton1 = new Button("save");
				GridPane.setConstraints(saveButton1, 8, 3);

				Button saveButton2 = new Button("save");
				GridPane.setConstraints(saveButton2, 8, 4);
				
				Button saveButton3 = new Button("save");
				GridPane.setConstraints(saveButton3, 8, 5);
				
				//checkout button that will take user to the checkout screen
				Button checkoutButton = new Button("Checkout");
				GridPane.setConstraints(checkoutButton, 8, 6);


			//adds all of the buttons, labels, and drop down menus to the grid
		grid.getChildren().addAll(categoryBox,searchBar, searchButton, browHist,
				todayDeal, giftCard, sellButton, helpButton, langSelect, yourAcc,
				ordersButton, cartButton, priceLabel, quantityLabel, productInfo1, 
				productInfo2, productInfo3, productPrice1, productPrice2, productPrice3,
				quantitySelect1, quantitySelect2, quantitySelect3, deleteButton1,
				deleteButton2, deleteButton3, saveButton1, saveButton2, saveButton3,
				checkoutButton);
		
		//gets the size of the scene and put the grid on the scene
		Scene scene = new Scene(grid, 1000, 300);
		window.setScene(scene);
		window.show();
		
		
		
		
	}
	
}
