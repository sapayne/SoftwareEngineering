package Database;

//written by Samuel Payne

public class Password {
	private String password;
	private int quantity;
	
	// doesn't allow password changing after the password has been set, instead you have to destroy the password
	// reference and make a new one, the Quantity is present to know how many users use this password
	public Password(String password) {
		this.password = password;
		quantity = 1;
	}
	
	public boolean checkPassword(String password) {
		if(password.compareTo(this.password) == 0) {
			return true;
		}
		return false;
	}
	
	public void incQuantity() {
		quantity++;
	}
	
	public int getQuantity() {
		return quantity;
	}
}
