package application;

import javafx.application.Application;
import static javafx.application.Application.launch;

import Database.Product;
import Database.database;
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

public class infoScreenPay {
	
	database product = new database();
	private VBox vBox;
	TableView<String> table;
	TextField nameInput, numInput;


	public infoScreenPay(){
		
		TableColumn<String, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("infoType"));
		
		TableColumn<String, String> numColumn = new TableColumn<>("Number");
		numColumn.setMinWidth(200);
		numColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
		
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);
		
		numInput = new TextField();
		numInput.setPromptText("Number");
		numInput.setMinWidth(100);
		
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addButtonClicked());
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteButtonClicked());

		
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10,10,10,10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(nameInput, numInput, addButton, deleteButton);
		
		table = new TableView<>();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn, numColumn);
		
		vBox = new VBox();
		vBox.getChildren().addAll(table,hBox);
		
	}
	
	
	public void addButtonClicked() {
		product.addUserInfo(nameInput.getText(), numInput.getText());
		table.getItems();
		nameInput.clear();
		numInput.clear();
	}
	
	public void deleteButtonClicked() {
		ObservableList<String> productSelected, allProducts;
		allProducts = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();
		
		productSelected.forEach(allProducts::remove);
	}
	
	public ObservableList<String> getProduct(){
		ObservableList<String> list = FXCollections.observableArrayList();
		String [] name = product.getUserInfo("name");
		for(int i = 0; i < name.length; i ++) {
			list.add(name[i]);
		}
		
		
		return list;
	}

	public Parent getView() {
		// TODO Auto-generated method stub
		return vBox;
	}
	
	
	
}
