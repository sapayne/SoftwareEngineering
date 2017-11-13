package Database;

public class DatabaseInterface {
	private BPlusTree tree;
	private itemInformation item;
	private database itemDatabase;
	// grab the index of the item being looked for, if it doesn't exist it returns null
	public String[] search(String name) {	
		return tree.printSimilar(name, 3);
	}
	
	// adds the item to the item database then adds the name and index that the item was added to
	public void add(String name, String brand, double price, int stock,String category, double weight, String image, String description) {
		item = new itemInformation(name,brand,price,stock,category,weight,0,image,0,description);
		itemDatabase = new database();
		/* the size is retrieved before the add function, because the add function also increases the size, 
		 * so instead of subtracting 1 from the size to get the correct index, we can save on one operation 
		 * by just assigning the value. 
		 */
		int itemIndex = itemDatabase.size(); 
		itemDatabase.add(item);
		// adds the index to the string itm, item, to tell the system which database the item is located in
		tree.add(name, "itm" + itemIndex); // ex. "itm100" would be the 101st index in the item database
	}
	
	// when checking out the reference to the memory location at which the item is held should be passed
	// meaning you won't need to search for the item in the B+tree, then go to the database and return the 
	// memory location.
	public void subtract(itemInformation item, int amountToSubtract) {
		itemDatabase.subtract(item, amountToSubtract);
	}
}
