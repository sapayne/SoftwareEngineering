package Database;

//Written By Samuel Payne

public class Node {
	/*	private global variables so that the objects that make references to the node class/object aren't able to 
	 *	access the variables directly.
	 */
	private String name;
	private String index;
	
	protected Node(){
		//sets item name and item index to null
		this.name = null;
		this.index = null;	
	}
	
	//sets the object name to the name passed after the addition of the node
	protected void setName(String name) {
		this.name = name;
	}
	
	//gets the object name from the node
	protected String getName() {
		return name;
	}
	
	//sets the object index to the index where the item is found in the database array 
	protected void setIndex(String index) {
		this.index = index;
	}
	
	//gets the index of the object where it's located in the database array
	protected String getIndex() {
		return index;
	}
}
