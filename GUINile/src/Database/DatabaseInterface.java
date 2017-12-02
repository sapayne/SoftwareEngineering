package Database;

//written by Samuel Payne

public interface DatabaseInterface {
	//returns the number (range) of item names, whose names match the substring passed, doesn't return the item database index
	String[] searchBar(String name, int range);
	
	//returns a copy of the items' information that matched the substring passed, and number (range) of results allowed per page
	String[][] searchResults(String name, int range);
	
	//used to return the user's customer names, shipping address, billing address, and credit card
	String[] getUserInfo(String infoType); // enter "name", "ship", "bill", or "card" to get each respected data, returns false if one of the four strings is not used 
	
	//used to return the number (range) of previous orders' information to be displayed on the page
	String[][] getUserOrders(int index, int range); //returns null if there are no items left in the user's previous orders
	
	//used to test if the username and password match without giving straight access to the user and password classes
	boolean login(String username, String password); //returns false if the username and password don't match or if the username doesn't exist
	
	//used to create a new user, returns false if the user already exists
	boolean add(String username, String password); 

	//used to add a new item, returns false if the item already exists, doesn't allow for the same item at multiple prices
	boolean add(String name, String brand, double price, int stock, String category, double weight, String image, String description); 

	//used if for when an item is bought, the stock of that item decreases unless the item doesn't have enough stock, then it returns false
	boolean subtract(String name, int amountToSubtract);
}
