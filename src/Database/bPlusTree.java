package Database;

//needs a search function, add function, and delete function
public class bPlusTree {
	
	private int length;
	private int treeSize;
	
	public bPlusTree() {
		
	}
	
	public void setLength(int value) {
		this.length = value;
	}
	
	public int getLength() {
		return length;
	}

	//insorts the new item to the database, if the item doesn't already exist
	public void add(String itemName) {
		//call search to see if it exists, if not add it to the bPlusTree
	}
	
	//allows you to find the item index from the bPlusTree
	public String search() {
		String itemIndex = null;
		//finds the item by name in the database, and returns the key which will be the itemIndex.
		
		return itemIndex;
	}
	
	//deletes the item from the database
	public void delete(String itemName) {
		//searches for the item by name then removes it from the bPlusTree
	}
	
}
