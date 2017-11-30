package Database;

//written by Samuel Payne

import java.util.ArrayList;

public class database implements DatabaseInterface{	
	private BPlusTree itemTree, userTree, passwordTree;
	private itemInformation item, currentIndexItem;
	private Node currentNode;
	private int size, itemAdjustmentFactor, userAdjustmentFactor, passwordAdjustmentFactor, itemAdjustmentIndex, userAdjustmentIndex, passwordAdjustmentIndex;
	private String category; //currently not used
	/* saves which user is currently logged in, does this because we don't want to return the user object to the
	 * UI as that would put security at risk, so instead the information is copied into a 2d array and then 
	 * passed to the user (the person currently using the application.
	 */
	private user currentUser; 
	
	
	ArrayList<itemInformation> itemDatabase = new ArrayList<itemInformation>();
	ArrayList<user> userDatabase = new ArrayList<user>();
	ArrayList<Password> passwordDatabase = new ArrayList<Password>();
	
	/* searches the b+ tree for similarly typed names as an auto-correct styled feature, returns the items who's
	 * names match the most to the string entered, this method is meant to be called every time a character is
	 * appended to or subtracted from the string present in the search bar
	 */ 
	public String[][] searchResults(String name, int range) {
		// all the similar string checking code is in the returnSimilar function in the BPlusTree class
		Node[] nodeArray = itemTree.returnSimilar(name, range);
		String[][] item = new String[range][nodeArray.length];
		for(int i = 0; i < nodeArray.length; i++) {
			item[i] = itemInfo(nodeArray[i].getIndex());
		}
		return item;	
	}
	
	//returns the names of the items that closely match the name of the item entered
	public String[] searchBar(String name, int range){
		Node[] nodeArray = itemTree.returnSimilar(name, range);
		String[] item = new String[range];
		for(int i = 0; i < range; i++) {
			item[i] = nodeArray[i].getName();
			//item[1][i] = nodeArray[i].getIndex();
		}
		return item;
	}
	
	// retrieves the item info and returns a copy of it as a string array
	private String[] itemInfo(String index) {
		int itemIndex = Integer.parseInt(index.substring(3, index.length()));
		itemInformation itemInfo = itemDatabase.get(itemIndex);
		String[] item = new String[9];
		item[0] = itemInfo.getName();
		item[1] = itemInfo.getBrand();
		item[2] = itemInfo.getDescription();
		item[3] = itemInfo.getImage();
		item[4] = "" + itemInfo.getPrice();
		item[5] = "" + itemInfo.getWeight();
		item[6] = "" + itemInfo.getStock();
		item[7] = "" + itemInfo.getPopularity();
		item[8] = "" + itemInfo.getNumReviewed();
		return item;
	}
	
	public String[] getUserInfo(String infoType) {
		if(currentUser != null) {
			switch (infoType) {
				case "name":
					return getUserNames();
				case "ship":
					return getShipping();
				case "bill":
					return getBilling();
				case "card":
					return getCards();
			}
		}
		return null;
	}
	
	public String[][] getUserOrders(int index, int range) {
		return getOrders(index,range);
	}
	
	//TODO finish all the get info functions 
	private String[] getUserNames() {
		int i = 0;
		String[] usernames;
		while(currentUser.getName(i) != null) {
			i++;
		}
		i++;
		usernames = new String[i];
		for(int j = 0; j < i; j++) {
			usernames[j] = currentUser.getName(j);
		}
		return null;
	}
	
	private String[] getShipping() {
		return null;
	}
	
	private String[] getBilling() {
		return null;
	}

	private String[] getCards() {
		return null;
	}
	
	private String[][] getOrders(int index, int range) {
		if(currentUser != null && (index > -1 || range > 0)) {
			return currentUser.getPreviousOrder(index, range);
		}
		return null;
	}

	//since it returns all the user info, we don't want to give whomever the ability to access the data
	private user searchUser(String name) {
		Node[] nodeArray = userTree.returnSimilar(name, 1);
		return getUser(nodeArray[0].getIndex());
	}
	
	private void addPassword(String password) {
		// if the password doesn't exist then make a new password object
		Password currentPassword = new Password(password);
		// grabs the size of the database as that will become the index at which the password will exist after adding it to the database
		int passwordIndex = passwordDatabase.size();
		// adds password Object to the end of the database 
		passwordDatabase.add(currentPassword);
		// adds the password to the passwordTree and where it's located in the password database
		passwordTree.add(password, "" + passwordIndex);
	}
	
	// returns the index at which the password can be found in the passwordDatabase
	private int searchPassword(String password) {
		Node passwordToTest = passwordTree.searchTree(password);
		if(password.compareTo(passwordToTest.getName()) == 0) {
			return Integer.parseInt(passwordToTest.getIndex());
		}
		return -1;
	}
	
	// returns true if the username uses the password enter
	private boolean matches(String password, user User) {
		Password passwordToTest = passwordDatabase.get(User.getPassword());
		return passwordToTest.checkPassword(password);
	}
	
	// checks if the username and password match the user's name and password
	public boolean login(String username, String password) {
		user User = searchUser(username);
		if(User != null && matches(password, User)) {
			currentUser = User;
			return true;
		}
		return false;
	}
	
	// searches similar items within a category and returns them to be used as a way to suggest common items
	// based on a users previous searches
	public itemInformation[] searchCategory(String name, int range) {
		return null;
	}
	
	// adds a new user to the user database
	public boolean add(String username, String password) {
		currentNode = userTree.searchTree(username);
		Password currentPassword;
		int passwordIndex;
		
		if(currentNode == null) {
			// finds the index where the password exists in the passwordDatabase by using the password b+ tree
			passwordIndex = searchPassword(password);
			
			if(passwordIndex > -1) {	//if the password's index is greater than -1 then the password exists
				currentPassword = passwordDatabase.get(passwordIndex);	//gets the password object at the index 
				currentPassword.incQuantity();	//increases the quantity meaning multiple people can use the same exact password
			} else {
				addPassword(password);
			}
			// creates a new user with the email entered and then stores the index where the user's password is locate in the password database 
			user newUser = new user(username, passwordIndex);
			// grabs the size of the user database before adding it as that will be the index where the user is located 
			size = userDatabase.size();
			userDatabase.add(newUser);
			userTree.add(newUser.getUserName(), "" + size);
			return true;
		} 
		return false;
	}
	
	// adds a new item to the item database
	public boolean add(String name, String brand, double price, int stock, String category, double weight, String image, String description) {
		itemInformation newItem = new itemInformation(name, brand, price, stock, category, weight, 0, image, 0, description, 0);
		currentNode = itemTree.searchTree(name);
		//search to see if the item exists in the database, if so add the quantity passed to the stock, if the 
		//item doesn't exist add it to the database.
		if(currentNode == null) {
			/* the size is retrieved before the add function, because the add function also increases the size, 
			 * so instead of subtracting 1 from the size to get the correct index, we can save on one operation 
			 * by just assigning the value. 
			 */
			size = itemDatabase.size();
			itemDatabase.add(newItem);
			category = "itm";
			/* category + size will eventually allow for multiple category databases, but for now since the databases 
			 * are small then storing all the items in one database should be fine.
			 */
			itemTree.add(name, category + size); 
			return true;
		} else {
			int itemIndex = Integer.parseInt(currentNode.getIndex().substring(3, currentNode.getIndex().length()));
			//grab the already present item's values and add the current item's values to the current item.
			//only stock, numberSold, popularity change, and number reviewed
			currentIndexItem = itemDatabase.get(itemIndex);
			currentIndexItem.setStock(currentIndexItem.getStock() + item.getStock());
			// only updates the popularity if the item being passed already has a rating associated with it
			if(item.getPopularity() != 0) {
				// calculates the overall popularity
				double popularity = newItem.getPopularity() * newItem.getNumReviewed() + currentIndexItem.getPopularity() * currentIndexItem.getNumReviewed();
				int totalReviewed = newItem.getNumReviewed() + currentIndexItem.getNumReviewed();
				currentIndexItem.setPopularity(popularity/totalReviewed);
				currentIndexItem.setNumReviewed(totalReviewed);
			}
			currentIndexItem.setNumberSold(currentIndexItem.getNumberSold() + newItem.getNumberSold());
			return false;
		}
	}
	
	// TODO
	// return value is based on if the user could buy the amount of product they wanted
	public boolean subtract(String index, int amountToSubtract) {
		// later plan to change this to a switch statement as there will be multiple categories for the item 
		// database, which will later allow for multiple database files.
		if(index.substring(0, 3).compareTo("itm") == 0) {
			int itemIndex = Integer.parseInt(index.substring(3, index.length()));
			item = itemDatabase.get(itemIndex);
			if(amountToSubtract <= item.getStock()) {
				item.setStock(item.getStock() - amountToSubtract);
				item.setNumberSold(item.getNumberSold() + amountToSubtract);
				/* don't need the code below because if the item was deleted then the previousOrders couldn't work
				 * properly when going to the item page to look at the description and other elements that aren't 
				 * displayed on the previous orders page.
				 * 				
				if(item.getStock() == 0) {
					delete("item",itemIndex);
				}
				*/
				return true;
			} else {
				return false;
			}
		} else {
			
		}
		return false;
	}
	
	// updates the popularity of an item
	public void reviewItem(String itemName, int numOfStars) {
		Node currentItem = itemTree.searchTree(itemName);
		String itemIndex = currentItem.getIndex();
		itemInformation item = itemDatabase.get(Integer.parseInt(itemIndex.substring(3, itemIndex.length())));
		double popularity = item.getPopularity() * item.getNumReviewed() + numOfStars;
		int totalReviewed = item.getNumberSold() + 1;
		item.setPopularity(popularity/totalReviewed);
		item.setNumReviewed(totalReviewed);
	}
	
	// currently not used as even when an item gets to zero, there will be a need to reference it for 
	// previousOrders in the item database
	/*
	private boolean delete(String category,int index) {
		switch(category) {
		case "item":
			itemDatabase.remove(index);
			return true;
		case "user":
			userDatabase.remove(index);
		default:
			return false;
		}
	}
	*/
	protected itemInformation getItem(String index) {
		int itemIndex = Integer.parseInt(index.substring(3, index.length()));
		return itemDatabase.get(itemIndex);
	}
	
	private user getUser(String index) {
		int userIndex = Integer.parseInt(index.substring(3, index.length()));
		return userDatabase.get(userIndex);
	}
}
