package Database;

//Written By Samuel Payne

//the object that will be used to populate the bPlusTree
public class BTreeNode {
	//global variables
	private BTreeNode parent;
	private BTreeNode rightSibling;
	private BTreeNode leftSibling;
	private String[] contents;
	private Object[] children;
	private int size; 			//size of treeNode, which is equal to the amount of nodes in it
	
	public BTreeNode(int length) {
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
	public void addChild(Node node) {
		int index;
		Node current = node;
		index = binarySearch(current.getName(), 0, size());
		childShift(index + 1, size());
		contentShift(index, size() - 1);
		children[index + 1] = current;
		contents[index] = current.getName();
		size++;
	}
	
	//adds the pointer to the node containing the object information and the name of the object in the next index
	public void addChild(BTreeNode treeNode) {
		int index;
		BTreeNode parent;
		String name = treeNode.contents[0]; 
		parent = treeNode.getParent();
		index = binarySearch(name,0,size());
		parent.childShift(index + 1, parent.size());
		parent.contentShift(index, parent.size() - 1);
		parent.setChild(treeNode, index + 1);
		parent.setContents(name, index);
	}
	
	public void removeChild(Node node) {
		int index, parentIndex;
		Node current = node;
		String name = node.getName();
		index = binarySearch(current.getName(), 0, size());
		/*	if the index returned is 0, then we will have to update the parent node's content value and 
		 * 	the child value
		 */
		if(index == 0) {
			if(getParent() != null) {
				BTreeNode parent = getParent();
				parentIndex = parent.binarySearch(name, 0, parent.size());
				if(parentIndex == 0) {
					//remove contents[index] and children[index + 1]
				}
				parent.setContents(contents[0], parentIndex);
				parent.setChild(children[1], parentIndex);
			}
			childShift(size, 0);
			contentShift(size - 1, 0);
		} else {
			childShift(size, index);
			contentShift(size - 1, index);
		}
		contents[size - 1] = null;
		children[size] = null;
	}
	
	public void removeChild(BTreeNode treeNode) {
		int index = binarySearch(treeNode.contents[0], 0, size);
		contentShift(index, size - 1);
		childShift(index, size);
		contents[index] = null;
		children[index] = null;
		size--;
	}
	
	//allows content shifting left to right, right to left, and no shift
	private void contentShift(int startingIndex, int endingIndex) {
		if(startingIndex < endingIndex) {
			for(int i = endingIndex; i > startingIndex; i--) {
				contents[i] = contents[i - 1];
			}
			contents[endingIndex] = null;
		} else if(startingIndex > endingIndex) {
			for(int i = endingIndex; i < startingIndex; i++) {
				contents[i] = contents[i + 1];
			}
		}
	}
	
	//three cases allowing for no shift, shift left, and shift right
	private void childShift(int startingIndex, int endingIndex) {
		if(startingIndex < endingIndex) {
			for(int i = endingIndex; i > startingIndex; i--) {
				children[i] = children[i - 1];
			}
			children[endingIndex] = null;
		} else if(startingIndex > endingIndex) {
			for(int i = endingIndex; i < startingIndex; i++) {
				children[i] = children[i + 1];
			}
		}
	}
	
	// sets the index of the children Object array
	public void setChild(Object child, int index) {
		children[index] = child;
	}
	
	//returns the Object in the children array at the index passed
	public Object getChild(int index) {
		return children[index];
	}
	
	//only used if the length is a small enough number
	public int search(String name) {
		for(int i = 0; i < size(); i++) {
			if(name.compareToIgnoreCase(contents[i]) < 0) {
				return i;
			} 
		}
		return size();
	}
	
	//only works if the array is all of type string, since if iterated through an object array it will return
	//the java provided name for the pointer in memory thus leading to some unwanted results.
	public int binarySearch(String name, int startingPointer, int endingPointer) {
		if(endingPointer-startingPointer > 1) {
			/* The if statement checks if the value enter is less than the value currently being checked.
			 * The else if statement checks if the value entered is greater than the value currently being checked.
			 * The last else statement represents if the value entered is equal to the value being checked.
			 * The test statements are ordered in this way, because if the equal statement was first that would 
			 * have the least number of operations done so long as you always get the value you are looking for
			 * as the middle value, however most of the time you will not match the value being searched for so 
			 * it will actually take up operations. So instead we check if the value is less than or greater than
			 * the current value (order for less than or greater than doesn't matter as it has the same outcome).
			 * In the long run this will save running time and lower the number of computations made.
			 */
			if (name.compareToIgnoreCase(getContents((endingPointer-startingPointer)/2 + startingPointer)) < 0){
				// recursion used as a loop to pinpoint the value being looked for
				return binarySearch(name, startingPointer, (endingPointer-startingPointer)/2 + startingPointer);
			} else if(name.compareToIgnoreCase(getContents((endingPointer-startingPointer)/2 + startingPointer)) > 0) {
				// recursion used as a loop to pinpoint the value being looked for
				return binarySearch(name, (endingPointer-startingPointer)/2 + startingPointer, endingPointer);
			} else {
				return ((endingPointer-startingPointer)/2 + startingPointer);
			}
		} else {
			// base case so the order doesn't matter and there doesn't need to be 3 cases as it's just one value
			if(name.compareToIgnoreCase(getContents((endingPointer-startingPointer)/2 + startingPointer)) < 0) {
				return (endingPointer-startingPointer)/2 + startingPointer - 1;
			} else {
				return (endingPointer-startingPointer)/2 + startingPointer;
			}
		}
	}
	
	//returns the length the children array, that is used to hold the strings, nodes, and bTree nodes.
	public int getLength() {
		return children.length;
	}
	
	// increases the counter of the number of nodes presently in the bTree node
	public void incSize() {
		size++;
	}
	
	// decreases the counter of the number of nodes presently in the bTree node
	public void decSize() {
		size--;	
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
	public String getContents(int index) {
		return contents[index];
	}
	
	//sets the value of the content at a certain index for the BTreeNode
	public void setContents(String name, int index) {
		contents[index] = name;
	}

	//returns if the bTree node has nodes in it or not
	public boolean isEmpty() {
        return size() == 0;
    }
	
	//points the bTree node to its parent bTree node if it isn't the root bTree node
	public void setParent(BTreeNode parent) {
		this.parent = parent;
	}
	
	//returns the parent of the current bTree node selected
	public BTreeNode getParent() {
		return parent;
	}
	
	//sets the right sibling to the next leaf bTree node
	public void setRightSibling(BTreeNode sibling) {
		rightSibling = sibling;
	}
	
	/*	returns the leaf bTree node that is connected to the current bTree node's right pointer,
	 *	the bTree node that contains elements less than the current bTree node.
	 */
	public BTreeNode getRightSibling() {
		return rightSibling;
	}
	
	//sets the left sibling to the previous leaf bTree node
	public void setLeftSibling(BTreeNode sibling) {
		leftSibling = sibling;
	}
	
	/*	returns the leaf bTree node that is connected to the current bTree node's left pointer, 
	 *	the BTree node that contains elements less than the current bTree node. 
	 */
	public BTreeNode getLeftSibling() {
		return leftSibling;
	}
}