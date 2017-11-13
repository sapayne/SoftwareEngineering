package application;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class cartScreen {
	private GridPane window;
	
	public cartScreen() {
                        
                 //sizing and spacing of the GUI
                        window = new GridPane();
                        window.setPadding(new Insets(10, 10, 10, 10));
                        window.setVgap(8);
                        window.setHgap(10);
		
                        //Label of the category selection
                        Button homeButton = new Button("Home");
                        homeButton.setPrefWidth(80);
                        homeButton.setOnAction(e-> {
                            //hides the login screen once login is successful
                            ((Node)e.getSource()).getScene().getWindow().hide();
                            Parent homeScreen = new homeScreen().getView();
                            Stage home = new Stage();
                            home.initOwner(homeButton.getScene().getWindow());
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
                        GridPane.setConstraints(homeButton, 0, 0);
                
                        //creating the category select drop down box when a category is selected
                        String blank = "All";
                        String electronics = "Electronics";
                        String appliances = "Appliances";
                        String automotive = "Automotive";
                        String games = "Software & Games";
                        String baby = "Baby";
                        String arts = "Arts & Crafts";
                        String books = "Books";
                        String movies = "Movies";
                        String clothes = "Clothes";
                        String outdoors = "Outdoors";
                        Separator separator = new Separator();
        
                        ObservableList<?> categories = FXCollections.observableArrayList(blank, separator, electronics, 
                            separator, appliances, separator, automotive, separator, games, separator, baby, 
                            separator, arts, separator, books, separator, movies, separator, 
                            clothes, separator, outdoors);
        
                        ChoiceBox<?> categoryBox = new ChoiceBox<>(categories);
                        categoryBox.getSelectionModel().selectFirst();
                        GridPane.setConstraints(categoryBox, 1, 0);
                        //creating the textfield for the search bar
                        TextField searchBar = new TextField();
                        searchBar.setPrefWidth(700);
                        searchBar.setPromptText("search");
                        GridPane.setConstraints(searchBar, 2, 0);
		
                        //The search button
                        Button searchButton = new Button("Search");
                        searchButton.setPrefWidth(70);
                        GridPane.setConstraints(searchButton, 3, 0);
		
                        //Row of Buttons and drop down for the task bar on the Nile 
                        Button browHist = new Button("Browsing History");
                        browHist.setOnAction(e-> {
                    //hides the login screen once login is successful
                    ((Node)e.getSource()).getScene().getWindow().hide();
                    Parent browseScreen = new browsingScreen().getView();
                    Stage browse = new Stage();
                    browse.initOwner(browHist.getScene().getWindow());
                    //display home page
                    
                    Scene browseScene = new Scene(browseScreen, 1600, 900);
                    browse.setScene(browseScene);
                    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

                    //set Stage boundaries to visible bounds of the main screen
                    browse.setX(primaryScreenBounds.getMinX());
                    browse.setY(primaryScreenBounds.getMinY());
                    browse.setWidth(primaryScreenBounds.getWidth());
                    browse.setHeight(primaryScreenBounds.getHeight());
                    browse.show();
                });
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
                        langSelect.getSelectionModel().selectFirst();
                        GridPane.setConstraints(langSelect, 5, 1);
		
                        Button yourAcc = new Button("Your Account");
                        yourAcc.setOnAction(e-> {
                        ((Node)e.getSource()).getScene().getWindow().hide();
                        Parent view = new accountScreen().getView();
                        //display home page
                        Scene scene = new Scene(view, 1600, 900);
                        Stage stage = new Stage();
                        stage.initOwner(yourAcc.getScene().getWindow());
                        stage.setScene(scene);
                        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

                        //set Stage boundaries to visible bounds of the main screen
                        stage.setX(primaryScreenBounds.getMinX());
                        stage.setY(primaryScreenBounds.getMinY());
                        stage.setWidth(primaryScreenBounds.getWidth());
                        stage.setHeight(primaryScreenBounds.getHeight());
                        
                        stage.show();
                    
                         });
                        GridPane.setConstraints(yourAcc, 6, 1);
		
                        Button ordersButton = new Button("Orders");
                        GridPane.setConstraints(ordersButton, 7, 1);
		
                        Button cartButton = new Button("Cart");
                        cartButton.setOnAction(e-> {
                        //hides the login screen once login is successful
                        ((Node)e.getSource()).getScene().getWindow().hide();
                        Parent window = new cartScreen().getView();
                        Stage cart = new Stage();
                        cart.initOwner(cartButton.getScene().getWindow());
                        //gets the size of the scene and put the grid on the scene
                        Scene scene = new Scene(window, 1600, 900);
                        cart.setScene(scene);
                        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

                        //set Stage boundaries to visible bounds of the main screen
                        cart.setX(primaryScreenBounds.getMinX());
                        cart.setY(primaryScreenBounds.getMinY());
                        cart.setWidth(primaryScreenBounds.getWidth());
                        cart.setHeight(primaryScreenBounds.getHeight());
                        cart.show();
                        });
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
                                quantitySelect1.getSelectionModel().selectFirst();
				GridPane.setConstraints(quantitySelect1, 6, 3);
				
				ChoiceBox<String> quantitySelect2 = new ChoiceBox<>();
				quantitySelect2.getItems().add("1");
				quantitySelect2.getItems().add("2");
				quantitySelect2.getItems().add("3");
				quantitySelect2.getItems().add("4");
				quantitySelect2.getItems().add("5");
                                quantitySelect2.getSelectionModel().selectFirst();
				GridPane.setConstraints(quantitySelect2, 6, 4);
				
				ChoiceBox<String> quantitySelect3 = new ChoiceBox<>();
				quantitySelect3.getItems().add("1");
				quantitySelect3.getItems().add("2");
				quantitySelect3.getItems().add("3");
				quantitySelect3.getItems().add("4");
				quantitySelect3.getItems().add("5");
                                quantitySelect3.getSelectionModel().selectFirst();
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
                                checkoutButton.setOnAction(e-> {   
                                            Parent checkout = new checkoutScreen().getView();
                                            Scene check = new Scene(checkout, 800, 500);
                                            Stage checkStage = new Stage();
                                            checkStage.initOwner(checkoutButton.getScene().getWindow());
                                            checkStage.setScene(check);
                                            checkStage.show();
                                });
				GridPane.setConstraints(checkoutButton, 8, 6);


			//adds all of the buttons, labels, and drop down menus to the grid
		window.getChildren().addAll(homeButton, categoryBox,searchBar, searchButton, browHist,
				todayDeal, giftCard, sellButton, helpButton, langSelect, yourAcc,
				ordersButton, cartButton, priceLabel, quantityLabel, productInfo1, 
				productInfo2, productInfo3, productPrice1, productPrice2, productPrice3,
				quantitySelect1, quantitySelect2, quantitySelect3, deleteButton1,
				deleteButton2, deleteButton3, saveButton1, saveButton2, saveButton3,
				checkoutButton);  
                
                window.setStyle("-fx-background-color: beige;");
}
            public Parent getView(){
                return window;
            }
}
