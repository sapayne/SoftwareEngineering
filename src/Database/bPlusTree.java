package Database;

//needs a search function, add function, and delete function
public class bPlusTree {
	
	private bTreeNode treeRoot;
	private bTreeNode current;
	private node Node = new node();
	protected int length;
	protected int size; //the size of the tree, number of nodes in the whole b+ tree
	
	public bPlusTree(int length) {
		treeRoot = new bTreeNode(length);
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	
	// if the bTree node can no longer contain any more nodes, then the bTree node is split into two bTree nodes
	// where the values less than the middle index are stored in the first newly created bTree node, and the values
	// greater than or equal to the middle value are stored in the second newly created bTree node. Then in the 
	// parent node that was just split, the value to the left of the middle value goes from a node pointer to a 
	// bTree node pointer
	private void split(bTreeNode nodeToSplit) {
		bTreeNode lessThan = new bTreeNode(length);
		bTreeNode greaterThanEqual = new bTreeNode(length);
		for(int i = 0; i < length/2+1; i++) {
			lessThan.children[i] = nodeToSplit.children[i];
			greaterThanEqual.children[length/2-i] = nodeToSplit.children[length-1-i];
		}
		lessThan.setParent(nodeToSplit);
		greaterThanEqual.setParent(nodeToSplit);
	}
	
	//inserts and sorts the new item to the database, if the item doesn't already exist
	public void insort(String name, String index) {
		current = binarySearch(name);
		if(current == null) {
			current.addChild(Node);
		}
		if (current.size() == current.getLength()) {
			split(current);
		} else {
			Node.setName(name);
			Node.setIndex(index);
			current.addChild(Node);
			current.incSize();
			this.size++;
		}
		//call search to see if it exists, if not add it to the bPlusTree
	}
	
	//allows you to find the bTree node closest to the value you want to add or find in the bPlusTree
	public bTreeNode binarySearch(String name) {
		//finds the object by name in the database, and returns the key which will be the Index.
		if((current.size()/2)%2 != 1) {
			current.nodeArray((treeRoot.size()/2+1));
		} else {
			current.nodeArray((current.size()/2));
		}
		
		return current;
	}
	
	public void transverse() {
		
	}
	
	//deletes the item from the database
	public void delete(String itemName) {
		this.size--;
		//searches for the item by name then removes it from the bPlusTree
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isLeaf() {
		return treeRoot.children[0] instanceof node;
	}
	
	public boolean isEmpty() {
        return treeRoot == null;
    }
	
}
