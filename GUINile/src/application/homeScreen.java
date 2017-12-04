package application;

import Database.database;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author qmorr
 */
public class homeScreen {
    private GridPane home;
    private HBox hb;
    private HBox hb2;
    database product = new database();

    
    public homeScreen() {
        
        //sizing and spacing of the GUI
		home = new GridPane();
		home.setPadding(new Insets(10, 10, 10, 10));
		home.setVgap(12);
		home.setHgap(10);
		
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
                String[] items = {"hello", "shoes", "computers"};
                
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
                
		//TODO this isn't a to do it's just to show you what two lines you need to write to grab the images, fileName won't always be hard coded
				String fileName = "Belkin.jpg";
                Image img = product.loadImage(fileName,500,500); //filename, width, height
                
                ImageView imageView1 = new ImageView(img);
                Button image1 = new Button();
                image1.setGraphic(imageView1);
                imageView1.setFitWidth(1000);
                imageView1.setFitHeight(200);
                GridPane.setConstraints(image1, 2, 10);
                
                Text browse = new Text("Recently Viewed Items");
                browse.setFont(Font.font ("Verdana", 18));
                home.add(browse, 2, 11);
                
                ImageView imageView2 = new ImageView(new Image("https://store.storeimages.cdn-apple.com/4974/as-images.apple.com/is/image/AppleInc/aos/published/images/M/AC/MACBOOKPRO/MACBOOKPRO?wid=1879&hei=1061&fmt=jpeg&qlt=95&op_sharpen=0&resMode=bicub&op_usm=0.5,0.5,0,0&iccEmbed=0&layer=comp&.v=6xyk93"));
                Button image2 = new Button();
                image2.setGraphic(imageView2);
                imageView2.setFitWidth(250);
                imageView2.setFitHeight(150);
                
                
                ImageView imageView3 = new ImageView(new Image("https://store.storeimages.cdn-apple.com/4974/as-images.apple.com/is/image/AppleInc/aos/published/images/a/lu/alu/silver/alu-silver-sport-fog-2up?wid=470&hei=556&fmt=png-alpha&qlt=95&.v=1506624085308"));
                Button image3 = new Button();
                image3.setGraphic(imageView3);
                imageView3.setFitWidth(250);
                imageView3.setFitHeight(150);
                
                ImageView imageView4 = new ImageView(new Image("https://cdn.wccftech.com/wp-content/uploads/2017/08/Intel-Coffee-Lake-Core-i7-8700K.png"));
                Button image4 = new Button();
                image4.setGraphic(imageView4);
                imageView4.setFitWidth(250);
                imageView4.setFitHeight(150);
                
                ImageView imageView5 = new ImageView(new Image("http://jerryneutron.com/wp-content/uploads/2016/11/logitechgpro1.jpg"));
                Button image5 = new Button();
                image5.setGraphic(imageView5);
                imageView5.setFitWidth(250);
                imageView5.setFitHeight(150);
                
                ImageView imageView6 = new ImageView(new Image("https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RWbGIB?ver=5d58&q=60&m=6&h=423&w=752&b=%23FF171717&f=jpg&o=f"));
                Button image6 = new Button();
                image6.setGraphic(imageView6);
                imageView6.setFitWidth(250);
                imageView6.setFitHeight(150);
                
                ImageView imageView7 = new ImageView(new Image("https://images-na.ssl-images-amazon.com/images/I/91wN%2BdYA9dL._AC_SX430_.jpg"));
                Button image7 = new Button();
                image7.setGraphic(imageView7);
                imageView7.setFitWidth(250);
                imageView7.setFitHeight(150);
                
                ImageView imageView8 = new ImageView(new Image("https://s.aolcdn.com/hss/storage/midas/f4ae086a2e446e01781baee1c703b95a/205656532/Belkin.jpg"));
                Button image8 = new Button();
                image8.setGraphic(imageView8);
                imageView8.setFitWidth(250);
                imageView8.setFitHeight(150);
                
                ImageView imageView9 = new ImageView(new Image("https://i.ytimg.com/vi/M_bub9QlI_U/maxresdefault.jpg"));
                Button image9 = new Button();
                image9.setGraphic(imageView9);
                imageView9.setFitWidth(250);
                imageView9.setFitHeight(150);
                
                hb = new HBox(image2, image3, image4, image5);
                hb.setSpacing(10);
                GridPane.setConstraints(hb, 2, 12);
                
                Text newItems = new Text("New Items for You");
                newItems.setFont(Font.font ("Verdana", 20));
                home.add(newItems, 2, 13);
                
                hb2 = new HBox(image6, image7, image8, image9);
                hb2.setSpacing(10);
                GridPane.setConstraints(hb2, 2, 14);
                
                home.setStyle("-fx-background-color: beige;");
                home.getChildren().addAll(homeButton, categoryBox,searchBar, searchButton, browHist,
				todayDeal, giftCard, sellButton, helpButton, langSelect, yourAcc,
				ordersButton, cartButton, image1,  hb, hb2);
        
    }
    
    public Parent getView(){
        return home;
    }
}