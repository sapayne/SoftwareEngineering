package softwareEngineering;


public class user {
	private int nameSize = 0;
	private int shippingSize = 0;
	private int billingSize = 0;
	private int ccSize = 0;
	String [][] userInformation;
	
	public void userInformation() {
		userInformation = new String[4][5];
	}
	
	public void addName(String name) {
		userInformation[0][getNameSize()] = name;
		nameSize++;
	}
	
	public void removeName(String name) {
		int index = findName(name);
		userInformation[0][index] = null;
        --nameSize;		
		
	}
	
	public int findName(String name) {
		int index = 0; 
		for (int i = 0; i < userInformation[0].length; i++) {
			if (userInformation[0][i] == name)
				index = i;
			else
				System.out.println("Name does not exist");
		}
		return index;
	}
	
	public int getNameSize(){
		return nameSize;
	}
	
	public String getName(int index) {
		return userInformation[0][index];
	}
	
	public void addShipping(String shipping) {
		userInformation[1][getShippingSize()] = shipping;
		shippingSize++;
	}
	
	public int getShippingSize(){
		return shippingSize;
	}
	
	public void removeShipping(String shipping) {
		int index = findShipping(shipping);
		userInformation[1][index] = null;
        --shippingSize;		
	}
	
	public int findShipping(String shipping) {
		int index = 0; 
		for (int i = 0; i < userInformation[1].length; i++) {
			if (userInformation[1][i] == shipping)
				index = i;
			else
				System.out.println("Shipping does not exist");
		}
		return index;
	}
	
	public String getShipping(int index) {
		return userInformation[1][index];
	}
	
	public void addBilling(String billing) {
		userInformation[2][getBillingSize()] = billing;
		billingSize++;
	}
	
	public int getBillingSize(){
		return billingSize;
	}
	
	public void removeBilling(String billing) {
		int index = findBilling(billing);
		userInformation[2][index] = null;
        --billingSize;		
	}
	
	public int findBilling(String billing) {
		int index = 0; 
		for (int i = 0; i < userInformation[2].length; i++) {
			if (userInformation[2][i] == billing)
				index = i;
			else
				System.out.println("Billing does not exist");
		}
		return index;
	}
	
	public String getBilling(int index) {
		return userInformation[2][index];
	}
	
	public void addCC (String cc) {
		userInformation[3][getCCSize()] = cc;
		ccSize++;
	}
	
	public int getCCSize(){
		return ccSize;
	}
	
	public void removeCC (String cc) {
		int index = findCC(cc);
		userInformation[3][index] = null;
        --ccSize;		
	}
	
	public int findCC (String cc) {
		int index = 0; 
		for (int i = 0; i < userInformation[3].length; i++) {
			if (userInformation[3][i] == cc)
				index = i;
			else
				System.out.println("Credit card does not exist");
		}
		return index;
	}
	
	public String getCC (int index) {
		return userInformation[3][index];
	}
	
	

}
