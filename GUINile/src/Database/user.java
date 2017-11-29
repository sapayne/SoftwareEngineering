package Database;


public class user {
	private String userName;
	private int nameSize = 0, shippingSize = 0, billingSize = 0, creditCardSize = 0, password;
	private String [][] userInformation;
	private previousOrders orders = new previousOrders();
	private Time time = new Time();
	
	//Email address stored here
	protected user(String userName, int passwordIndex) {
		setUserName(userName);
		this.password = passwordIndex;
	}
	
	protected int getPassword() {
		return password;
	}

	protected String getUserName() {
		return userName;
	}

	// private because once a user enters their email there is no way to change it
	private void setUserName(String userName) {
		this.userName = userName;
	}
	
	protected void userInformation() {
		userInformation = new String[4][5];
	}
	
	protected void addName(String name) {
		userInformation[0][getNameSize()] = name;
		nameSize++;
	}
	
	protected void removeName(String name) {
		int index = findName(name);
		userInformation[0][index] = null;
        --nameSize;		
		
	}
	
	protected int findName(String name) {
		int index = -1; 
		for (int i = 0; i < userInformation[0].length; i++) {
			if (userInformation[0][i].equalsIgnoreCase(name)) {
				return i;
			}
		}
		return index;
	}
	
	private int getNameSize(){
		return nameSize;
	}
	
	protected String getName(int index) {
		return userInformation[0][index];
	}
	
	protected void addShipping(String shipping) {
		userInformation[1][getShippingSize()] = shipping;
		shippingSize++;
	}
	
	private int getShippingSize(){
		return shippingSize;
	}
	
	protected void removeShipping(String shipping) {
		int index = findShipping(shipping);
		userInformation[1][index] = null;
        --shippingSize;		
	}
	
	protected int findShipping(String shipping) {
		int index = -1; 
		for (int i = 0; i < userInformation[1].length; i++) {
			if (userInformation[1][i].equalsIgnoreCase(shipping)) {
				return i;
			}
		}
		return index;
	}
	
	protected String getShipping(int index) {
		return userInformation[1][index];
	}
	
	protected void addBilling(String billing) {
		userInformation[2][getBillingSize()] = billing;
		billingSize++;
	}
	
	private int getBillingSize(){
		return billingSize;
	}
	
	protected void removeBilling(String billing) {
		int index = findBilling(billing);
		userInformation[2][index] = null;
        --billingSize;		
	}
	
	protected int findBilling(String billing) {
		int index = -1; 
		for (int i = 0; i < userInformation[2].length; i++) {
			if (userInformation[2][i].equalsIgnoreCase(billing)) {
				return i;
			}
		}
		return index;
	}
	
	protected String getBilling(int index) {
		return userInformation[2][index];
	}
	
	protected void addcreditCard (String creditCard) {
		userInformation[3][getcreditCardSize()] = creditCard;
		creditCardSize++;
	}
	
	private int getcreditCardSize(){
		return creditCardSize;
	}
	
	protected void removecreditCard (String creditCard) {
		int index = findcreditCard(creditCard);
		userInformation[3][index] = null;
        --creditCardSize;		
	}
	
	protected int findcreditCard (String creditCard) {
		int index = -1; 
		for (int i = 0; i < userInformation[3].length; i++) {
			if (userInformation[3][i].equalsIgnoreCase(creditCard)) {
				return i;
			}
		}
		return index;
	}
	
	protected String getcreditCard (int index) {
		return userInformation[3][index];
	}
	
	protected void addOrder(String name, itemInformation item, int quantity, String itemIndex) {
		//String customerName, String itemName, String brand,  String image, double price, int quantity, String index, long time
		Order itemOrder = new Order(name, item.getName(), item.getBrand(), item.getImage(), item.getPrice(), quantity, itemIndex, time.currentEpoch());
		orders.addOrder(itemOrder);
	}
	
	protected Order[] getPreviousOrder(int index, int range) {
		return orders.getPreviousOrders(index, range);
	}
}
