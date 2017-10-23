package Database;

//the object that will be used to populate the bPlusTree
public class bTreeNode {
	//global variables
	private bTreeNode parent;
	private bTreeNode rightSibling;
	private bTreeNode leftSibling;
	private node current;
	
	public Object[] children;
	private int size; 			//size of treeNode, which is equal to the amount of nodes in it
	
	public bTreeNode(int length) {
		/* 	Siblings are only used if the bTreeNode has no children, also known as a leaf node, as
		 * 	this will connect the lowest level nodes together as a way of returning the range of 
		 *	numbers between to indices.
		 */
		this.rightSibling = null;
		this.leftSibling = null;
		/* 	creates the array that will hold the pointers to the bTree nodes that contain the strings and nodes, 
		 *	or holds pointers to the nodes themselves along with their string values, bTree nodes and nodes are
		 *	never present in the same array.
		 */
		children = new Object[2*length+1];
	}
	
	//adds the pointer to the node containing the object information and the name of the object in the next index
	public void addChild(Object nodeToTest) {
		children[size()] = nodeToTest;
		if(children[size()] instanceof node) {
			current = (node)children[size()];
			children[size() + 1] = current.getName();
		}
	}
	
	//returns the length the children array, that is used to hold the strings, nodes, and bTree nodes.
	public int getLength() {
		return this.children.length;
	}
	
	// increases the counter of the number of nodes presently in the bTree node
	public void incSize() {
		this.size++;
	}
	
	//returns the number of nodes in the bTree node
	public int size() {
		return this.size;
	}

	public void nodeArray(int index) {
		
	}

	//returns if the bTree node has nodes in it or not
	public boolean isEmpty() {
        return size() == 0;
    }
	
	//points the bTree node to its parent bTree node if it isn't the root bTree node
	public void setParent(bTreeNode parent) {
		this.parent = parent;
	}
	
	//returns the parent of the current bTree node selected
	public bTreeNode getParent() {
		return this.parent;
	}
	
	//sets the right sibling to the next leaf bTree node
	public void setRightSibling(bTreeNode sibling) {
		this.rightSibling = sibling;
	}
	
	/*	returns the leaf bTree node that is connected to the current bTree node's right pointer,
	 *	the bTree node that contains elements less than the current bTree node.
	 */
	public bTreeNode getRightSibling() {
		return this.rightSibling;
	}
	
	//sets the left sibling to the previous leaf bTree node
	public void setLeftSibling(bTreeNode sibling) {
		this.leftSibling = sibling;
	}
	
	/*	returns the leaf bTree node that is connected to the current bTree node's left pointer, 
	 *	the BTree node that contains elements less than the current bTree node. 
	 */
	public bTreeNode getLeftSibling() {
		return this.leftSibling;
	}
	
}