package Database;

public class Order {
	
	private String customerName, itemName, brand,  image, index;
	private double price;
	private int quantity;
	private long time;
	
	//no setters needed as you will never change the contents of an order after it's been placed
	public Order(String customerName, String itemName, String brand,  String image, double price, int quantity, String index, long time) {
		this.customerName = customerName;
		this.itemName = itemName;
		this.brand = brand;
		this.image = image;
		this.index = index;
		this.price = price;
		this.quantity = quantity;
		this.time = time;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	/*
	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}
	 */

	public String getItemName() {
		return itemName;
	}
	/*
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	*/
	public String getBrand() {
		return brand;
	}
	/*
	public void setBrand(String brand) {
		this.brand = brand;
	}
	*/
	public String getImage() {
		return image;
	}
	/*
	public void setImage(String image) {
		this.image = image;
	}
	*/
	public String getIndex() {
		return index;
	}
	
	public double getPrice() {
		return price;
	}
	/*
	public void setPrice(double price) {
		this.price = price;
	}
	*/
	public int getQuantity() {
		return quantity;
	}
	/*
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	*/
	public long getTime() {
		return time;
	}
	//no set time needed as you are never changing or updating, once the customer has bought an item
}
