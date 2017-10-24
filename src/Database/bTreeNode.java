package Database;

//the object that will be used to populate the bPlusTree
public class bTreeNode {
	//global variables
	private bTreeNode parent;
	private bTreeNode rightSibling;
	private bTreeNode leftSibling;
	public String[] contents;
	public Object[] children;
	private int size; 			//size of treeNode, which is equal to the amount of nodes in it
	
	public bTreeNode(int length) {
		parent = null;
		/* 	Siblings are only used if the bTreeNode has no children, also known as a leaf node, as
		 * 	this will connect the lowest level nodes together as a way of returning the range of 
		 *	numbers between to indices.
		 */
		rightSibling = null;
		leftSibling = null;
		/* 	creates the array that will hold the pointers to the bTree nodes that contain the strings and nodes, 
		 *	or holds pointers to the nodes themselves along with their string values, bTree nodes and nodes are
		 *	never present in the same array.
		 */
		contents = new String[length];
		children = new Object[length+1];
		size = 0;
	}
	
	//adds the pointer to the node containing the object information and the name of the object in the next index
	public void addChild(Object nodeToTest) {
		int index;
		if(nodeToTest instanceof node) {
			index = search(((node) nodeToTest).getName());
		} 
		if(nodeToTest instanceof bTreeNode) {
			
		}
	}
	
	//searches through the bTreeNode and returns the index where the name would be found, so if it's less than 
	//every name it should return 0 for the index, and if it's greater than every name it should return length
	//of the children array.
	public int search(String name) {
		int index = 0;
		for(int i = 0; i < size(); i+=2) {
				if(name.compareToIgnoreCase(nodeArray(i)) < 0) {
					index = i-1;
					break;
				} else if (name.compareToIgnoreCase(nodeArray(i)) >= 0) {
					index = i;
				} 
		}
		return index;
	}
	
	//only works if the array is all of type string, since if iterated through an object array it will return
	//the java provided name for the pointer in memory thus leading to some unwanted results.
	public int binarySearch(String name, int startingPointer, int endingPointer) {
		int index = 0;
		if(endingPointer-startingPointer > 1) {
			if(name.compareToIgnoreCase(nodeArray((endingPointer-startingPointer)/2 + startingPointer)) < 0) {
				return binarySearch(name, startingPointer, (endingPointer-startingPointer)/2 + startingPointer);
			} else if(name.compareToIgnoreCase(nodeArray((endingPointer-startingPointer)/2 + startingPointer)) > 0) {
				return binarySearch(name, (endingPointer-startingPointer)/2 + startingPointer, endingPointer);
			} else {
				index = (endingPointer-startingPointer)/2 + startingPointer;
			}
		} else {
			if(name.compareToIgnoreCase(nodeArray((endingPointer-startingPointer)/2 + startingPointer)) < 0) {
				index = (endingPointer-startingPointer)/2 + startingPointer - 1;
			} else {
				index = (endingPointer-startingPointer)/2 + startingPointer;
			}
		}
		return index;
	}
	
	//returns the length the children array, that is used to hold the strings, nodes, and bTree nodes.
	public int getLength() {
		return children.length;
	}
	
	// increases the counter of the number of nodes presently in the bTree node
	public void incSize() {
		size++;
	}
	
	//returns the number of nodes in the bTree node
	public int size() {
		return size;
	}
	
	//allows the split method in the bPlusTree class to set the size of each child node
	public void setSize(int size) {
		this.size = size;	
	}
	
	//returns the string value located at the index passed
	public String nodeArray(int index) {
		return contents[index];
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
		return parent;
	}
	
	//sets the right sibling to the next leaf bTree node
	public void setRightSibling(bTreeNode sibling) {
		rightSibling = sibling;
	}
	
	/*	returns the leaf bTree node that is connected to the current bTree node's right pointer,
	 *	the bTree node that contains elements less than the current bTree node.
	 */
	public bTreeNode getRightSibling() {
		return rightSibling;
	}
	
	//sets the left sibling to the previous leaf bTree node
	public void setLeftSibling(bTreeNode sibling) {
		leftSibling = sibling;
	}
	
	/*	returns the leaf bTree node that is connected to the current bTree node's left pointer, 
	 *	the BTree node that contains elements less than the current bTree node. 
	 */
	public bTreeNode getLeftSibling() {
		return leftSibling;
	}
	
}