package Database;

//written by Samuel Payne

import java.util.ArrayList;

public class database implements DatabaseInterface{	
	private BPlusTree itemTree, userTree, passwordTree;
	private itemInformation item, currentIndexItem;
	private Node currentNode;
	private Order currentOrder;
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
		itemInformation itemInfo = getItem(index);
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
	
	//TODO make it so the user is logged in to add data (name, shipping, billing, and credit card info)
	
	//returns false if the user was unable to add user information or the correct info type was passed
	public boolean addInfo(String infoType, String info) {
		if(currentUser != null) {
			switch(infoType) {
			case "name":
				return addName(info);
				
			case "ship":
				return addShipping(info);
				
			case "bill":
				return addBilling(info);
				
			case "card":
				return addCard(info);
				
			}
		}
		return false;
	}
	
	//TODO
	public boolean addUserOrder(String customerName, String itemName, String brand, String image, double price, int quantity) {
		if(currentUser != null && currentUser.hasName(customerName)) {
			currentNode = itemTree.searchTree(itemName);
			String index = currentNode.getIndex();
			currentUser.addOrder(customerName, currentIndexItem, quantity, index);
			//return addOrder(customerName);
		}
		return false;
	}
	
	//returns false if the name already exists or no more names can be added
	private boolean addName(String name) {
		return currentUser.addName(name);
	}
	
	//returns false if the shipping address already exists or no more addresses can be added
	private boolean addShipping(String shipping) {
		return currentUser.addShipping(shipping);
	}
	
	//returns false if the billing address already exists or no more addresses can be added
	private boolean addBilling(String billing) {
		return currentUser.addBilling(billing);
	}
	
	//returns false if the card already exists or no more cards can be added
	private boolean addCard(String card) {
		return currentUser.addCreditCard(card);
	}
	
	private boolean addOrder(String customerName, itemInformation item, int quantity, String index) {
		if(quantity <= getItem(index).getStock()) {
			
		}
		return false;
	}
	
	//returns false if the user is unable to remove user data
	public boolean removeUserInfo(String infoType, int index) {
		if(currentUser != null) {
			switch(infoType) {
			case "name":
				return removeName(index);
				
			case "ship":
				return removeShipping(index);
				
			case "bill":
				return removeBilling(index);
				
			case "card":
				return removeCard(index);
			}
		}
		return false;
	}
	
	//returns false if the name at the index wasn't unable to be removed, must have one name present at all time
	private boolean removeName(int index) {
		return currentUser.removeName(index);
	}
	
	//returns false if the shipping address at the index couldn't be removed, either because the wrong index was passed or no more addresses could be removed
	private boolean removeShipping(int index) {
		return currentUser.removeShipping(index);
	}
	
	//returns false if the billing address at the index couldn't be removed, either because the wrong index was passed or no more addresses could be removed
	private boolean removeBilling(int index) {
		return currentUser.removeBilling(index);
	}
	
	//returns false if the card at the index couldn't be removed, either because the worng index was passed or no more cards could be removed
	private boolean removeCard(int index) {
		return currentUser.removeCreditCard(index);
	}
	
	//returns the users information based of the string passed, returns false if one of the four strings wasn't used
	public String[] getUserInfo(String infoType) {
		if(currentUser != null) {
			switch (infoType) {
				case "name":
					return getNames();
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
	
	/* returns the users previous orders if the user is logged in and the index and range are not illegal numbers
	 * returns null if one of the conditions fail or the user has no previous orders
	 */
	public String[][] getUserOrders(int index, int range) {
		if(currentUser != null && (index > -1 || range > 0)) {
			return getOrders(index,range);
		}
		return null;
	}
	
	//returns all the names the user has entered
	private String[] getNames() {
		int size = currentUser.getNameSize();
		String[] usernames = new String[size];
		for(int i = 0; i < size; i++) {
			usernames[i] = currentUser.getName(i);
		}
		return null;
	}
	
	private String[] getShipping() {
		int size = currentUser.getShippingSize();
		String[] shipping = new String[size];
		for(int i = 0; i < size; i++) {
			shipping[i] = currentUser.getShipping(i);
		}
		return null;
	}
	
	private String[] getBilling() {
		int size = currentUser.getBillingSize();
		String[] billing = new String[size];
		for(int i = 0; i < size; i++) {
			billing[i] = currentUser.getBilling(i);
		}
		return null;
	}

	private String[] getCards() {
		int size = currentUser.getCreditCardSize();
		String[] cards = new String[size];
		for(int i = 0; i < size; i++) {
			cards[i] = currentUser.getCreditCard(i);
		}
		return null;
	}
	
	private String[][] getOrders(int index, int range) {
		return currentUser.getPreviousOrder(index, range);
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
	
	//TODO also the ability to delete the user's account, and remove account information one index at a time
	
	/* user has to be logged in, then changes password, if password doesn't exist (search function) then make a
	 * new password, before setting the user's password to the new password; go to the old password and decease 
	 * it's quantity and if it's quantity hits 0 remove the password from the password database then update the 
	 * password indices for all other users, last add the new password, if unique, to the password database. if 
	 * the password is not unique then just set the user password index to the index where it exists in the 
	 * password database.
	 */
	public boolean changePassword(String password) {
		if(currentUser != null) { //means the user is logged in
			
		}
		return false;
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
	
	//checks if there is a user logged in to begin with if so then it sets currentUser to null as to break access to the currentUser info
	//returns false if the user is already logged out
	public boolean logout() {
		if(currentUser != null) {
			currentUser = null;
			return true;
		}
		return false;
	}
	
	// searches similar items within a category and returns them to be used as a way to suggest common items
	// based on a users previous searches
	public itemInformation[] searchCategory(String name, int range) {
		return null;
	}
	// TODO make it so the user has to add a name after making their account
	
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
	
	// TODO not finished
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
	private itemInformation getItem(String index) {
		int itemIndex = Integer.parseInt(index.substring(3, index.length()));
		return itemDatabase.get(itemIndex);
	}
	
	private user getUser(String index) {
		int userIndex = Integer.parseInt(index.substring(3, index.length()));
		return userDatabase.get(userIndex);
	}
}
