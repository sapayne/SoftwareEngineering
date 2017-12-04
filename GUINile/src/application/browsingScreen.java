package application;

import Database.database;
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
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author qmorr
 */
public class browsingScreen {
    private GridPane browse;
    private HBox hb;
    private HBox hb2;
    private HBox hb3;
    private HBox hb4;
    database product = new database();

    
    
    public browsingScreen(){
        browse = new GridPane();
		browse.setPadding(new Insets(10, 10, 10, 10));
		browse.setVgap(12);
		browse.setHgap(10);
		
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
                String[] items = {"television", "shoes", "macbook", "iron", "crib", "grill", "hsrry potter", "norton", "Star Wars", "colored pencils", "procesor", "oil"};
                TextFields.bindAutoCompletion(searchBar, items);
                searchBar.setOnKeyPressed(e-> {
                    if(e.getCode().equals(KeyCode.ENTER)){
                        if (searchBar.getText().equals("macbook")){
                            //hides the login screen once login is successful
                    ((Node)e.getSource()).getScene().getWindow().hide();
                    Parent itemTemp = new itemTemplate().getView();
                    Stage item = new Stage();
                    item.initOwner(searchBar.getScene().getWindow());
                    //display home page
                    
                    Scene itemScene = new Scene(itemTemp, 1600, 900);
                    item.setScene(itemScene);
                    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

                    //set Stage boundaries to visible bounds of the main screen
                    item.setX(primaryScreenBounds.getMinX());
                    item.setY(primaryScreenBounds.getMinY());
                    item.setWidth(primaryScreenBounds.getWidth());
                    item.setHeight(primaryScreenBounds.getHeight());
                    item.show();
                        };
                    }
                });
                
                searchBar.setPrefWidth(700);
                searchBar.setPromptText("search");
		GridPane.setConstraints(searchBar, 2, 0);
		
		//The search button
		Button searchButton = new Button("Search");
                searchButton.setOnAction(e-> {
                   if (searchBar.getText().equals("macbook")){
                            //hides the login screen once login is successful
                    ((Node)e.getSource()).getScene().getWindow().hide();
                    Parent itemTemp = new itemTemplate().getView();
                    Stage item = new Stage();
                    item.initOwner(searchButton.getScene().getWindow());
                    //display home page
                    
                    Scene itemScene = new Scene(itemTemp, 1600, 900);
                    item.setScene(itemScene);
                    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

                    //set Stage boundaries to visible bounds of the main screen
                    item.setX(primaryScreenBounds.getMinX());
                    item.setY(primaryScreenBounds.getMinY());
                    item.setWidth(primaryScreenBounds.getWidth());
                    item.setHeight(primaryScreenBounds.getHeight());
                    item.show();
                        };
                });
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
                
                Text browseh = new Text("Browsing History");
                browseh.setFont(Font.font ("Verdana", 24));
                browse.add(browseh, 2, 10);
                
                ImageView imageView1 = new ImageView(new Image("https://store.storeimages.cdn-apple.com/4974/as-images.apple.com/is/image/AppleInc/aos/published/images/M/AC/MACBOOKPRO/MACBOOKPRO?wid=1879&hei=1061&fmt=jpeg&qlt=95&op_sharpen=0&resMode=bicub&op_usm=0.5,0.5,0,0&iccEmbed=0&layer=comp&.v=6xyk93"));
                Button image1 = new Button();
                image1.setGraphic(imageView1);
                imageView1.setFitWidth(250);
                imageView1.setFitHeight(150);
                
                ImageView imageView2 = new ImageView(new Image("https://store.storeimages.cdn-apple.com/4974/as-images.apple.com/is/image/AppleInc/aos/published/images/a/lu/alu/silver/alu-silver-sport-fog-2up?wid=470&hei=556&fmt=png-alpha&qlt=95&.v=1506624085308"));
                Button image2 = new Button();
                image2.setGraphic(imageView2);
                imageView2.setFitWidth(250);
                imageView2.setFitHeight(150);
                
                ImageView imageView3 = new ImageView(new Image("https://cdn.wccftech.com/wp-content/uploads/2017/08/Intel-Coffee-Lake-Core-i7-8700K.png"));
                Button image3 = new Button();
                image3.setGraphic(imageView3);
                imageView3.setFitWidth(250);
                imageView3.setFitHeight(150);
                
                ImageView imageView4 = new ImageView(new Image("http://jerryneutron.com/wp-content/uploads/2016/11/logitechgpro1.jpg"));
                Button image4 = new Button();
                image4.setGraphic(imageView4);
                imageView4.setFitWidth(250);
                imageView4.setFitHeight(150);
                
                hb = new HBox(image1, image2, image3, image4);
                hb.setSpacing(10);
                GridPane.setConstraints(hb, 2, 11);
                
                ImageView imageView5 = new ImageView(new Image("https://www.containerstore.com/catalogimages/252328/10047828Duchess5HkOverdoorRackBrz_60.jpg?width=1200&height=1200&align=center"));
                Button image5 = new Button();
                image5.setGraphic(imageView5);
                imageView5.setFitWidth(250);
                imageView5.setFitHeight(150);
                
                ImageView imageView6 = new ImageView(new Image("https://recyclenation.com/wp-content/uploads/2015/01/iStock_000015921027Medium.jpg"));
                Button image6 = new Button();
                image6.setGraphic(imageView6);
                imageView6.setFitWidth(250);
                imageView6.setFitHeight(150);
                
                ImageView imageView7 = new ImageView(new Image("https://target.scene7.com/is/image/Target/50343077?wid=520&hei=520&fmt=pjpeg"));
                Button image7 = new Button();
                image7.setGraphic(imageView7);
                imageView7.setFitWidth(250);
                imageView7.setFitHeight(150);
                
                ImageView imageView8 = new ImageView(new Image("https://images.samsclubresources.com/is/image/samsclub/0088133400961_A?$img_size_380x380$"));
                Button image8 = new Button();
                image8.setGraphic(imageView8);
                imageView8.setFitWidth(250);
                imageView8.setFitHeight(150);
                
                hb2 = new HBox(image5, image6, image7, image8);
                hb2.setSpacing(10);
                GridPane.setConstraints(hb2, 2, 12);
                
                ImageView imageView9 = new ImageView(new Image("http://cdn.pocket-lint.com/r/s/970x/assets/images/142246-phones-feature-best-iphone-x-cases-protect-your-new-apple-device-image2-xtreomy7gh.jpg"));
                Button image9 = new Button();
                image9.setGraphic(imageView9);
                imageView9.setFitWidth(250);
                imageView9.setFitHeight(150);
                
                ImageView imageView10 = new ImageView(new Image("https://m.media-amazon.com/images/S/aplus-media/vc/0377e23f-ae6c-41cd-9ffd-edb364cb7d96._SR285,285_.jpg"));
                Button image10 = new Button();
                image10.setGraphic(imageView10);
                imageView10.setFitWidth(250);
                imageView10.setFitHeight(150);
                
                ImageView imageView11 = new ImageView(new Image("https://mobileimages.lowes.com/product/converted/047362/047362324276.jpg"));
                Button image11 = new Button();
                image11.setGraphic(imageView11);
                imageView11.setFitWidth(250);
                imageView11.setFitHeight(150);
                
                ImageView imageView12 = new ImageView(new Image("https://images-na.ssl-images-amazon.com/images/I/919wyzlfPPL._SL1500_.jpg"));
                Button image12 = new Button();
                image12.setGraphic(imageView12);
                imageView12.setFitWidth(250);
                imageView12.setFitHeight(150);
                
                hb3 = new HBox(image9, image10, image11, image12);
                hb3.setSpacing(10);
                GridPane.setConstraints(hb3, 2, 13);
                
                ImageView imageView13 = new ImageView(new Image("https://target.scene7.com/is/image/Target/14782249?wid=520&hei=520&fmt=pjpeg"));
                Button image13 = new Button();
                image13.setGraphic(imageView13);
                imageView13.setFitWidth(250);
                imageView13.setFitHeight(150);
                
                ImageView imageView14 = new ImageView(new Image("https://s1.cdn.autoevolution.com/images/news/gallery/how-to-change-your-oil_3.png"));
                Button image14 = new Button();
                image14.setGraphic(imageView14);
                imageView14.setFitWidth(250);
                imageView14.setFitHeight(150);
                
                ImageView imageView15 = new ImageView(new Image("https://slimages.macysassets.com/is/image/MCY/products/2/optimized/2927532_fpx.tif?op_sharpen=1&wid=400&hei=489&fit=fit,1&$filterlrg$"));
                Button image15 = new Button();
                image15.setGraphic(imageView15);
                imageView15.setFitWidth(250);
                imageView15.setFitHeight(150);
                
                ImageView imageView16 = new ImageView(new Image("http://prodimage.images-bn.com/pimages/9780545162074_p0_v2_s1200x630.jpg"));
                Button image16 = new Button();
                image16.setGraphic(imageView16);
                imageView16.setFitWidth(250);
                imageView16.setFitHeight(150);
                
                hb4 = new HBox(image13, image14, image15, image16);
                hb4.setSpacing(10);
                GridPane.setConstraints(hb4, 2, 14);
                
                browse.getChildren().addAll(homeButton, categoryBox,searchBar, searchButton, browHist,
				todayDeal, giftCard, sellButton, helpButton, langSelect, yourAcc,
				ordersButton, cartButton, hb, hb2, hb3, hb4);
                
                browse.setStyle("-fx-background-color: beige;");
    }
    public Parent getView(){
        return browse;
    }
}
