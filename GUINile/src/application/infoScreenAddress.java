package application;

import javafx.application.Application;
import static javafx.application.Application.launch;

import database.Product;
import database.database;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
*
* @author dzheng
*/

public class infoScreenAddress{
	private VBox vBox; 
	TableView<Product> table;
	TextField nameInput, numInput, dateInput;
    database product = new database();

	
	public infoScreenAddress() {
		
		
		TableColumn<Product, String> nameColumn = new TableColumn<>("Street Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("cardName"));
		
		TableColumn<Product, String> numColumn = new TableColumn<>("City");
		numColumn.setMinWidth(200);
		numColumn.setCellValueFactory(new PropertyValueFactory<>("cardNum"));
		
		TableColumn<Product, String> dateColumn = new TableColumn<>("Zip Code");
		dateColumn.setMinWidth(100);
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("cardExdate"));
		
		nameInput = new TextField();
		nameInput.setPromptText("Street Name");
		nameInput.setMinWidth(100);
		
		numInput = new TextField();
		numInput.setPromptText("City");
		numInput.setMinWidth(100);
		
		dateInput = new TextField();
		dateInput.setPromptText("Zip Code");
		dateInput.setMinWidth(100);
		
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addButtonClicked());
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteButtonClicked());

		
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10,10,10,10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(nameInput, numInput, dateInput, addButton, deleteButton);
		
		table = new TableView<>();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn, numColumn, dateColumn);
		
		vBox = new VBox();
		vBox.getChildren().addAll(table,hBox);
		
	}
	
	public void addButtonClicked() {
		Product product = new Product();
		product.setCardName(nameInput.getText());
		product.setCardNum(numInput.getText());
		product.setCardExdate(dateInput.getText());
		table.getItems().add(product);
		nameInput.clear();
		numInput.clear();
		dateInput.clear();
	}
	
	public void deleteButtonClicked() {
		ObservableList<Product> productSelected, allProducts;
		allProducts = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();
		
		productSelected.forEach(allProducts::remove);
	}
	
	public ObservableList<Product> getProduct(){
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("1234 Some Dudes Home", "Atlanta, GA", "30336"));
		products.add(new Product("6789 My Other House", "Buckhead, GA", "31265"));
		
		return products;
	}

	public Parent getView() {
		// TODO Auto-generated method stub
		return vBox;
	}
	
	
	
}
