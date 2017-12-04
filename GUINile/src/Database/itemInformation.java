package Database;

public class itemInformation {
	
	private String name, brand, category, description, image;
	private double price, weight, popularity;
	private int quantity, numberSold, numReviewed;

	public itemInformation(String name, String brand, String category, String description, String image, double price, double weight, int quantity, int numberSold, double popularity,  int numReviewed) {
		super();
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.image = image;
		this.price = price;
		this.weight = weight;
		this.quantity = quantity;
		this.numberSold = numberSold;
		this.popularity = popularity;
		this.numReviewed = numReviewed;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public int getNumberSold() {
		return numberSold;
	}

	public void setNumberSold(int numberSold) {
		this.numberSold = numberSold;
	}
	
	public double getPopularity() {
		return popularity;
	}

	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}
	
	public int getNumReviewed() {
		return numReviewed;
	}
	
	public void setNumReviewed(int reviewed) {
		numReviewed = reviewed;
	}

	public String toString() {
		return "Item [name= " + name + ", brand=" + brand + ", price=" + price +
				", quantity=" + quantity + ", category=" + category + 
				", weight= " + weight + ", popularity= " + popularity +
				", image= " + image + ", number sold= " + numberSold + 
				", description= " + description + "]";
	}
	
}