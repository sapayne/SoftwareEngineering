/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Quincy
 */
public class GUI extends Application {
    
    String user = "dqsz@gsu.edu";
    String password = "dqsz123";
    String checkEmail, checkPass;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage loginStage) {
        
        //creating the grid pane
        GridPane login = new GridPane();
        
        //creating the size for the grid pane
        login.setMinSize(500,300);
        
        //creating the text for welcoming to the login screen
        Text text0 = new Text("Welcome to Nile");
        login.add(text0, 1,0);
        
        //creating the text area label for email
        Text text1 = new Text("Email ");
        login.add(text1, 0,4);
        
        //creating the text area label for password
        Text text2 = new Text("Password ");
        login.add(text2, 0,5);
        
        //creating textfield for email
        final TextField email = new TextField();
        email.setPromptText("email");
        login.add(email, 1,4);
        
        //creating the password textfield
        final PasswordField pass = new PasswordField();
        pass.setPromptText("password");
        login.add(pass, 1,5);
        
        //creating the login button after user inputs information
        Button loginButton = new Button("Login");
        login.add(loginButton, 1,8);
        loginButton.setId("loginButton");
        
        //Label to show if email and password are correct
        final Label fail = new Label();
        login.add(fail, 1,7);
        
        //Setting the padding  
        login.setPadding(new Insets(10, 10, 10, 10)); 
      
        //Setting the vertical and horizontal gaps between the columns 
        login.setVgap(5); 
        login.setHgap(5);
        
        //Alignment of the grid
        login.setAlignment(Pos.CENTER);
        
        //Styling the nodes
        text0.setStyle("-fx-font: normal bold 36px 'times new roman' ");
        text1.setStyle("-fx-font: normal bold 24px 'times new roman' "); 
        text2.setStyle("-fx-font: normal bold 24px 'times new roman' ");  
        login.setStyle("-fx-background-color: WHITE;");
        
        //Scene
        Scene scene = new Scene(login);
        
        //Title for the login stage
        loginStage.setTitle("Login");
        
        //Sets the scene to the login stage
        loginStage.setScene(scene);
        
        //Displays the GUI
        loginStage.show();
        
        //closes all the windows when 'X' is pressed
        loginStage.setOnCloseRequest(e -> Platform.exit());
        
    loginButton.setOnAction(new EventHandler<ActionEvent>(){
    public void handle(ActionEvent event) {
        //Determines if email and password are correct
        checkEmail = email.getText().toString();
        checkPass = pass.getText().toString();
        if(checkEmail.equals(user) && checkPass.equals(password)){
        
        
        //hides the login screen once login is successful
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage home = new Stage();
        
        //Title of page
        home.setTitle("Home Page");
        
        //Stage dimensions
        home.setWidth(1010);
        home.setHeight(700);
        
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 550, 250);
        
        //creating the textfield for the search bar
        TextField searchBar = new TextField();
        searchBar.setPromptText("search");
        AnchorPane.setTopAnchor(searchBar, 5.0);
        AnchorPane.setLeftAnchor(searchBar, 300.0);
        AnchorPane.setRightAnchor(searchBar, 150.0);
        
        //creating the category select drop down box when a category is selected
        String blank = new String("            ");
        String electronics = new String("Electronics");
        String appliances = new String("Appliances");
        String automotive = new String("Automotive");
        String games = new String("Games");
        String baby = new String("Baby");
        String arts = new String("Arts & Crafts");
        String books = new String("Books");
        String movies = new String("Movies");
        String clothes = new String("Clothes");
        String outdoors = new String("Outdoors");
        Separator separator = new Separator();
        
        Label catSelect = new Label("Category Select:");
        catSelect.setStyle("-fx-font: normal bold 26px");
        
        ObservableList<?> categories = FXCollections.observableArrayList(blank, electronics, separator, appliances, separator, automotive, separator, games, separator, baby, separator, arts, separator, books, separator, movies, separator, clothes, separator, outdoors);
        
        ChoiceBox<?> choiceBox = new ChoiceBox<>(categories);
        AnchorPane.setTopAnchor(choiceBox, 5.0);
        AnchorPane.setLeftAnchor(choiceBox, 150.0);
        AnchorPane.setRightAnchor(choiceBox, 700.0);
        
        AnchorPane.setTopAnchor(catSelect, 10.0);
        AnchorPane.setLeftAnchor(catSelect, 60.0);
        AnchorPane.setRightAnchor(catSelect, 650.0);
        
        //creating the menu bar
        MenuBar menuBar = new MenuBar();
        AnchorPane.setTopAnchor(menuBar, 30.0);
        AnchorPane.setLeftAnchor(menuBar, 1.0);
        AnchorPane.setRightAnchor(menuBar, 1.0);
        
        //creating a search button
        Button searchIcon = new Button("🔎");
        searchIcon.setMinWidth(10.0);
        searchIcon.setPrefWidth(10.0);
        searchIcon.setMaxWidth(10.0);
        AnchorPane.setTopAnchor(searchIcon, 5.0);
        AnchorPane.setLeftAnchor(searchIcon, 850.0);
        AnchorPane.setRightAnchor(searchIcon, 100.0);
        
        
        //creating the different menu options
        Menu browsingHistoryMenu = new Menu("Browsing History");
        Menu dealsMenu = new Menu("Today's Deals");
        Menu sellMenu = new Menu("Sell");
        Menu helpMenu = new Menu("Help");
        Menu langSelectMenu = new Menu("Language Select");
        Menu yourAccountMenu = new Menu("Your Account");
        Menu ordersMenu = new Menu("Orders");
        Menu cartMenu = new Menu("Cart");
        
        //creating the menuItems for certain parts of the menu
        MenuItem english = new MenuItem("English");
        MenuItem spanish = new MenuItem("Español");
        MenuItem french = new MenuItem("français");
        MenuItem german = new MenuItem("Deutsche");
        MenuItem arabic = new MenuItem("عربى");
        MenuItem chinese = new MenuItem("中文");
        MenuItem hindi = new MenuItem("हिंदी");
        
        MenuItem prevOrdersItem = new MenuItem("Recent Orders");
        
        MenuItem addressItem = new MenuItem("Your Addresses");
        MenuItem managePay = new MenuItem("Manage Payment Options");
        
        
        //display the menu with designated menuItems
        menuBar.getMenus().addAll(browsingHistoryMenu, dealsMenu, sellMenu, helpMenu, langSelectMenu, yourAccountMenu, ordersMenu, cartMenu);
        langSelectMenu.getItems().addAll(english, spanish, french, german, arabic, chinese, hindi);
        ordersMenu.getItems().addAll(prevOrdersItem);
        yourAccountMenu.getItems().addAll(addressItem, managePay);
        root.getChildren().addAll(menuBar, searchBar, catSelect, choiceBox, searchIcon);
        
        //display home page
        home.setScene(scene);
        home.show();
        }
        else{
           fail.setText("Incorrect email and/or password");
           fail.setTextFill(Color.RED);
        }
        email.setText("");
        pass.setText("");
    }
});
}
}
    


