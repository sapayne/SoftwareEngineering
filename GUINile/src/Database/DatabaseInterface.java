package Database;

import javafx.scene.image.Image;

//written by Samuel Payne

public interface DatabaseInterface {
	//returns the number (range) of item names, whose names match the substring passed, doesn't return the item database index
	String[] searchBar(String name, int range);
	
	//returns a copy of the items' information that matched the substring passed, and number (range) of results 
	//allowed per page
	//returns a 2d array where the range is the number of rows and the number of columns is always a static 
	//9 columns being - name, brand, description, image, price, weight, quantity, popularity, numReviewed
	String[][] searchResults(String name, int range);
	
	//pass the name of the item and the quantity you want to buy
	boolean addItemToCart(String name, int quantity);
	
	//pass the index can be found by using the getItemCart method
	boolean removeItemFromCart(int index);
	
	//returns the current item cart of the user
	String[][] getItemCart();
	
	//used to return the user's customer names, shipping address, billing address, and credit card
	// enter "name", "ship", "bill", or "card" to get each respected data, returns false if one of the four strings is not used 
	String[] getUserInfo(String infoType); 
	
	//used to return the number (range) of previous orders' information to be displayed on the page
	//returns null if there are no items left in the user's previous orders
	String[][] getUserOrders(int index, int range); 
	
	//used to add user info such as customer names, shipping addresses, billing addresses, and credit cards
	// enter "name", "ship", "bill", or "card" for infoType, and then the info you're adding for info
	//returns false if you are unable to enter anymore info for that field
	boolean addUserInfo(String infoType, String info);
	
	//adds the item just bought to the users previous orders array
	//returns false if you tried to buy more quantity than there is available
	boolean addUserOrder(String customerName, String itemName, double price, int quantity);
	
	//allows the user to remove "name", "ship", "bill", "card" from their user info based on the index; 
	//the getUserInfo will return the information in order, and from there the index could be passed using the 
	//index that the info is located in from the string array that the getUserInfo returns
	boolean removeUserInfo(String infoType, int index);
	
	//used to test if the username and password match without giving straight access to the user and password classes
	//returns false if the username and password don't match or if the username doesn't exist
	boolean login(String username, String password); 
	
	//used change the current user's password
	boolean changePassword(String newPassword, String oldPassword);
	
	//used to stop displaying the current users info 
	boolean logout();
	
	//only an option if the user is logged in, and then the user needs to re-enter their password
	//boolean deleteAccount(String password); //returns false if the password didn't match or the user wasn't logged in
	
	//used to create a new user, returns false if the user already exists
	//when adding the new user (signing up) also ask the user for their name and call the addName function
	boolean add(String username, String password); 

	//used to add a new item, returns false if the item already exists, doesn't allow for the same item at multiple prices
	boolean add(String name, String brand, String category, String description, String image, double price, double weight, int stock); 

	//updates the popularity of an item by what the user rated it as
	void reviewItem(String itemName, int numOfStars);
	
	//pass the filename of the image you want to retrieve along with the size, example loadImage("Belkin.jpg",500,500)
	//however the filename will be given to the user through the searchResults function which returns a 2d array
	//of size [range][9] and the 4th column (index 3) will be where all the image filenames of the items will be found
	Image loadImage(String fileName, int width, int height);
	
	//will load the databases when the system starts up
	//has to be called when the program starts up
	boolean readDatabases(); 
	
	//will write the databases when the systems shuts down
	//has to be called right before the program stops running as to not lose data
	void writeDatabases(); 
	
}
