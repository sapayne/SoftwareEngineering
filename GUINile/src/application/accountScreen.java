/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.application.Application;
import static javafx.application.Application.launch;
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
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author qmorr
 */
public class accountScreen  {
    private GridPane view;
    
    public accountScreen() {
        
        view = new GridPane();
		view.setPadding(new Insets(10, 10, 10, 10));
		view.setVgap(8);
		view.setHgap(10);
		
                //Label of the home button
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
                        
                        Button recentOrders = new Button("Recent Orders");
                        recentOrders.setStyle("-fx-font-size: 24px");
                        recentOrders.setMinWidth(300);
                        recentOrders.setMinHeight(150);
                        GridPane.setConstraints(recentOrders, 2, 4);
                        
                        Button payOptions = new Button("Payment Options");
                        payOptions.setStyle("-fx-font-size: 24px");
                        payOptions.setMinWidth(300);
                        payOptions.setMinHeight(150);
                        payOptions.setOnAction(e-> {
                            Parent info = new infoScreen().getView();
                            Scene scene = new Scene(info, 1000, 500);
                            Stage infoStage = new Stage();
                            infoStage.initOwner(payOptions.getScene().getWindow());
                            infoStage.setScene(scene);
                            infoStage.show();
                        });
                        GridPane.setConstraints(payOptions, 3, 4);
                        
                        Button addresses = new Button("Your Addresses");
                        addresses.setStyle("-fx-font-size: 24px");
                        addresses.setMinWidth(300);
                        addresses.setMinHeight(150);
                        addresses.setOnAction(e-> {
                            Parent info = new infoScreen().getView();
                            Scene scene = new Scene(info, 1000, 500);
                            Stage infoStage = new Stage();
                            infoStage.initOwner(addresses.getScene().getWindow());
                            infoStage.setScene(scene);
                            infoStage.show();
                        });
                        GridPane.setConstraints(addresses, 2, 5);
                        
                        Button giftCards = new Button("Gift Cards");
                        giftCards.setStyle("-fx-font-size: 24px");
                        giftCards.setMinWidth(300);
                        giftCards.setMinHeight(150);
                        GridPane.setConstraints(giftCards, 3, 5);
        
                        view.getChildren().addAll(homeButton, categoryBox,searchBar, searchButton, browHist,
				todayDeal, giftCard, sellButton, helpButton, langSelect, yourAcc,
				ordersButton, cartButton, recentOrders, payOptions, addresses, giftCards);
        view.setStyle("-fx-background-color: beige;");
        
    }
    public Parent getView(){
        return view;
    }

    /**
     * @param args the command line arguments
     */
    
    
}
