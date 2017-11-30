package Database;


public class user {
	private String userName;
	private int nameSize, shippingSize, billingSize, creditCardSize, orderSize, password;
	private String [][] userInformation = new String[4][5];
	private previousOrders orders = new previousOrders();
	private Time time = new Time();
	
	//Email address stored here, with the index that contains the user's password
	protected user(String userName, int passwordIndex) {
		setUserName(userName);
		setPassword(passwordIndex);
		nameSize = 0;
		shippingSize = 0;
		billingSize = 0;
		creditCardSize = 0;
		orderSize = 0;
	}
	
	//returns the index of where the password is located in the password database
	protected int getPassword() {
		return password;
	}
	
	//used to update the password location if the user changes their password
	protected void setPassword(int index) {
		if(password != index) {
			password = index;
		}
	}

	//returns the username (email address used)
	protected String getUserName() {
		return userName;
	}

	// private because once a user enters their email there is no way to change it
	private void setUserName(String userName) {
		this.userName = userName;
	}

	//searches to see if the name already exists then if it doesn't; it adds the name to the names array
	protected boolean addName(String name) {
		int index = findName(name);
		if(nameSize < 5 && index == -1) {
			userInformation[0][getNameSize()] = name;
			nameSize++;
			return true;
		}
		return false;
	}
	
	//returns true if the name at the index specified was removed
	protected boolean removeName(int index) {
		if(index != -1 && index < nameSize) {
			for(int i = index; i < nameSize - 1; i++) {
				userInformation[0][i] = userInformation[0][i + 1];
			}
			nameSize--;
			userInformation[0][nameSize] = null;
			return true;
		}
		return false;
	}
	
	//used to determine if the name exist in the user information 2d array
	private int findName(String name) {
		int index = -1; 
		for (int i = 0; i < userInformation[0].length; i++) {
			if (userInformation[0][i].equalsIgnoreCase(name)) {
				return i;
			}
		}
		return index;
	}
	
	//used to determine where to add the next name in the array
	private int getNameSize(){
		return nameSize;
	}
	
	//returns the name located at the index specified, else returns a null string
	protected String getName(int index) {
		if(index < nameSize && index > -1) {
			return userInformation[0][index];
		}
		return null;
	}
	
	//searches to see if the shipping already exists then if it doesn't; it adds the shipping address to the shipping array
	protected boolean addShipping(String shipping) {
		int index = findShipping(shipping);
		if(shippingSize < 5 && index == -1) {
			userInformation[1][getShippingSize()] = shipping;
			shippingSize++;
			return true;
		}
		return false;
	}
	
	//used to determine where to add the next shipping address in the array
	private int getShippingSize(){
		return shippingSize;
	}
	
	//returns true if the shipping address was removed from the index specified
	protected boolean removeShipping(int index) {
		if(index != -1 && index < shippingSize) {
			for(int i = index; i < shippingSize - 1; i++) {
				userInformation[1][i] = userInformation[1][i + 1];
			}
			shippingSize--;
			userInformation[1][shippingSize] = null;
			return true;
		}	
		return false;
	}
	
	//used to determine if the shipping address already exist in the user information 2d array
	private int findShipping(String shipping) {
		int index = -1; 
		for (int i = 0; i < userInformation[1].length; i++) {
			if (userInformation[1][i].equalsIgnoreCase(shipping)) {
				return i;
			}
		}
		return index;
	}
	
	//returns the shipping address at the index specified, else returns a null string
	protected String getShipping(int index) {
		if(index < shippingSize && index > -1) {
			return userInformation[1][index];
		}
		return null;
	}
	
	//searches to see if the billing already exists then if it doesn't; it adds the billing to the billing array
	protected boolean addBilling(String billing) {
		int index = findBilling(billing);
		if(billingSize < 5 && index == -1) {
			userInformation[2][getBillingSize()] = billing;
			billingSize++;
			return true;
		}
		return false;
	}
	
	//used to determine where to add the next billing address in the array
	private int getBillingSize(){
		return billingSize;
	}
	
	//returns true if the billing address at the index specified was removed
	protected boolean removeBilling(int index) {
		if(index != -1 && index < billingSize) {
			for(int i = index; i < billingSize - 1; i++) {
				userInformation[2][i] = userInformation[2][i + 1];
			}
			billingSize--;
			userInformation[2][billingSize] = null;
			return true;
		}	
		return false;
	}
	
	//used to tell if the billing address exist in the user information 2d array
	private int findBilling(String billing) {
		int index = -1; 
		for (int i = 0; i < userInformation[2].length; i++) {
			if (userInformation[2][i].equalsIgnoreCase(billing)) {
				return i;
			}
		}
		return index;
	}
	
	//returns the billing information located at the index
	protected String getBilling(int index) {
		if(index < billingSize && index > -1) {
			return userInformation[2][index];
		}
		return null;
	}
	
	//searches to see if the credit card already exists then if it doesn't; it adds the card to the credit card array
	protected boolean addcreditCard (String creditCard) {
		int index = findCreditCard(creditCard);
		if(creditCardSize < 5 && index == -1) {
			userInformation[3][getcreditCardSize()] = creditCard;
			creditCardSize++;
			return true;
		}
		return false;
	}
	
	//used to determine where to add the next credit card in the array
	private int getcreditCardSize(){
		return creditCardSize;
	}
	
	//returns true if the card at the index specified was removed
	protected boolean removecreditCard (int index) {
		if(index != -1 && index < creditCardSize) {
			for(int i = index; i < creditCardSize - 1; i++) {
				userInformation[3][i] = userInformation[3][i + 1];
			}
			creditCardSize--;
			userInformation[3][creditCardSize] = null;
			return true;
		}	
		return false;
	}
	
	//used to test if the card already exists in the userInformation 2d array
	private int findCreditCard (String creditCard) {
		int index = -1; 
		for (int i = 0; i < userInformation[3].length; i++) {
			if (userInformation[3][i].equalsIgnoreCase(creditCard)) {
				return i;
			}
		}
		return index;
	}
	
	// returns the last 4 digits of the credit card
	protected String getcreditCard (int index) {
		if(index < creditCardSize && index > -1) {
			String card = userInformation[3][index];
			return card.substring(card.length() - 4, card.length());
		}
		return null;
	}
	
	//used to add an order to the previous orders array
	protected void addOrder(String name, itemInformation item, int quantity, String itemIndex) {
		//String customerName, String itemName, String brand,  String image, double price, int quantity, String index, long time
		Order itemOrder = new Order(name, item.getName(), item.getBrand(), item.getImage(), item.getPrice(), quantity, itemIndex, time.currentEpoch());
		orders.addOrder(itemOrder);
		incOrderSize();
	}
	
	//gets the number of orders specified by the range, at starts at which index
	protected String[][] getPreviousOrder(int index, int range) {
		Order[] previousOrders = orders.getPreviousOrders(index, range);
		String[][] orders = null;
		if(previousOrders.length != 0) {
			//uses previousOrders length because there might be less items than the range
			orders = new String[previousOrders.length][8];
			//converts all info in the Order class to strings
			for(int i = 0; i < previousOrders.length; i++) {
				orders[i][0] = previousOrders[i].getCustomerName();
				orders[i][1] = previousOrders[i].getItemName();
				orders[i][2] = previousOrders[i].getBrand();
				orders[i][3] = previousOrders[i].getImage();
				orders[i][4] = previousOrders[i].getIndex();
				orders[i][5] = "" + previousOrders[i].getPrice();
				orders[i][6] = "" + previousOrders[i].getQuantity();
				orders[i][7] = time.epochToHuman(previousOrders[i].getTime());
			}
		}
		return orders;
	}
	
	private void incOrderSize() {
		orderSize++;
	}
	
	protected int orderSize() {
		return orderSize;
	}
}
