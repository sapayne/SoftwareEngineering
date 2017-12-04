package Database;

//written by Samuel Payne

public class Password {
	private String password;
	private int quantity;
	
	// doesn't allow password changing after the password has been set, instead you have to destroy the password
	// reference and make a new one, the Quantity is present to know how many users use this password
	protected Password(String password) {
		this.password = password;
		quantity = 1;
	}
	
	protected Password(String password, int quantity) {
		this.password = password;
		this.quantity = quantity;
	}
	
	//returns the password
	protected String getPassword() {
		return password;
	}
	
	//returns true if the password entered matches the password in this password Object
	protected boolean checkPassword(String password) {
		if(password.compareTo(this.password) == 0) {
			return true;
		}
		return false;
	}
	
	//increases the quantity, telling us how many users are using the same unique password
	protected void incQuantity() {
		quantity++;
	}
	
	//returns how many users are using the same unique password
	protected int getQuantity() {
		return quantity;
	}
	
	//decreases the number of user who are using the same password, called after changing a user password or deleting the user
	protected void decQuantity() {
		quantity--;
	}
}
