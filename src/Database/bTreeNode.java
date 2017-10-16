package Database;

//the object that will be used to populate the bPlusTree
public class bTreeNode {
	//global variables
	private String itemName;
	private String itemIndex;
	private int length;
	private String[] nodes;
	
	// sets the name and itemIndex to null
	public bTreeNode() {
		this.itemName = null;
		this.itemIndex = null;	
		this.length = 5;
		this.nodes = new String[6];
	}
	
	public bTreeNode(int length) {
		this.itemName = null;
		this.itemIndex = null;	
		this.length = length;
		this.nodes = new String[length+1];
	}
	
	public void setItemName(String name) {
		this.itemName = name;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemIndex(String index) {
		this.itemIndex = index;
	}
	
	public String getItemIndex() {
		return itemIndex;
	}
}