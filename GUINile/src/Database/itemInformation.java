package Database;

public class itemInformation {
	
	private String name, brand, category, description, image;
	private double price, weight, popularity;
	private int stock, numberSold;

	public itemInformation(String name, String brand, double price, int stock,
			String category, double weight, double popularity, String image, 
			int numberSold, String description) {
		super();
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.image = image;
		this.price = price;
		this.weight = weight;
		this.stock = stock;
		this.numberSold = numberSold;
		this.popularity = popularity;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public String toString() {
		return "Item [name= " + name + ", brand=" + brand + ", price=" + price +
				", stock=" + stock + ", category=" + category + 
				", weight= " + weight + ", popularity= " + popularity +
				", image= " + image + ", number sold= " + numberSold + 
				", description= " + description + "]";
	}
	
}