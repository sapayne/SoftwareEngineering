package Database;

public class Order {
	
	private String customerName, itemName, brand,  image, index;
	private double price;
	private int quantity;
	private long time;
	
	//no setters needed as you will never change the contents of an order after it's been placed
	protected Order(String customerName, String itemName, String brand,  String image, double price, int quantity, String index, long time) {
		this.customerName = customerName;
		this.itemName = itemName;
		this.brand = brand;
		this.image = image;
		this.index = index;
		this.price = price;
		this.quantity = quantity;
		this.time = time;
	}
	
	protected String getCustomerName() {
		return customerName;
	}
	/*
	protected void setCustomerName(String customerName){
		this.customerName = customerName;
	}
	 */

	protected String getItemName() {
		return itemName;
	}
	/*
	protected void setItemName(String itemName) {
		this.itemName = itemName;
	}
	*/
	protected String getBrand() {
		return brand;
	}
	/*
	protected void setBrand(String brand) {
		this.brand = brand;
	}
	*/
	protected String getImage() {
		return image;
	}
	/*
	protected void setImage(String image) {
		this.image = image;
	}
	*/
	protected String getIndex() {
		return index;
	}
	
	protected double getPrice() {
		return price;
	}
	/*
	protected void setPrice(double price) {
		this.price = price;
	}
	*/
	protected int getQuantity() {
		return quantity;
	}
	/*
	protected void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	*/
	protected long getTime() {
		return time;
	}
	//no set time needed as you are never changing or updating, once the customer has bought an item
}
