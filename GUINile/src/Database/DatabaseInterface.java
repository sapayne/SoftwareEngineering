package Database;

public interface DatabaseInterface {
	String[] searchBar(String name, int range);
	
	String[][] searchResults(String name, int range);
	
	boolean login(String username, String password);
	
	boolean add(String username, String password);

	boolean add(String name, String brand, double price, int stock, String category, double weight, String image, String description); 

	boolean subtract(String name, int amountToSubtract);
}
