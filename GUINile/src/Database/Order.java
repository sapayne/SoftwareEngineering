package softwareEngineering;

public class Order {
	
	private String name, brand, description, image;
	private double price, weight;
	private int quantity;
	Time time = new Time();
	
	public Order(String name, String brand,
			String description, String image, double price, double weight,
			int quantity, Time time) {
		super();
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.image = image;
		this.price = price;
		this.weight = weight;
		this.quantity = quantity;
		this.time = time;
	}

	public Order() {
		name = "";
		brand = "";
		description = "";
		image = "";
		price = 0;
		weight = 0;
		quantity = 0;
		time = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
