package Database;

public class DatabaseInterface {
	private BPlusTree tree;
	// grab the index of the item being looked for, if it doesn't exist it returns null
	public String search(String name) {	
		return tree.databaseIndex(name);
	}
}
