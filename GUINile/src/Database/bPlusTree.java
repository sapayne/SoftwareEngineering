package Database;

//Written By Samuel Payne

//needs a search function, add function, and delete function
public class BPlusTree {
	
	private BTreeNode treeRoot;
	private BTreeNode current;
	private Node node;
	private int length;
	private int size; //the size of the tree, number of nodes in the whole b+ tree
	private boolean oddFlag;
	
	public BPlusTree(int length) {
		treeRoot = new BTreeNode(length);
		current = treeRoot;
		this.length = length;
		size = 0;
		setIsLengthOdd();
	}
	
	public int getLength() {
		return length;
	}
	
	public void setIsLengthOdd() {
		oddFlag = (length/2)%2 == 1;
	}
	
	public boolean isLengthOdd() {
		return oddFlag;
	}
	
	/* if the bTree node can no longer contain any more nodes, then the bTree node is split into two bTree nodes
	 * where the values less than the middle index are stored in the first newly created bTree node, and the values
	 * greater than or equal to the middle value are stored in the second newly created bTree node. Then in the 
	 * parent node that was just split, the value to the left of the middle value goes from a node pointer to a 
	 * bTree node pointer, which points to the less than bTree node and the value to the right goes to the greater
	 * than bTree node. Last it calls leafUpdate function which connects all the leaf bTree nodes together.
	 */
	private void split(BTreeNode nodeToSplit) {
		int isNode = 1;
		/* is used to determine if a bTreeNode containing bTreeNodes or a bTreeNode containing Nodes is being 
		 * split, changes the index location the contents to match the child index location (used later on to
		 * retrieve data correctly)
		 */
		if(isLeaf(nodeToSplit)) {
			isNode = 0;
		}
		BTreeNode greaterThanEqual = new BTreeNode(length);
		/* the for loop is duplicated for the purpose of saving runtime computations, instead of saving space
		 * by the if else being inside the for loop
		 */
		if(isLengthOdd()) {	//checks if the bTreeNode has an odd number of contents (string array used in bTreeNode as storage)
			for(int i = 0; i < length/2; i++) {
				greaterThanEqual.setContents(nodeToSplit.getContents(length-isNode-i), length/2-i);
				nodeToSplit.setContents(null, length-1-i);
				greaterThanEqual.setChild(nodeToSplit.getChild(length-i), length/2-i);
				nodeToSplit.setChild(null, length-i);
			}
			greaterThanEqual.setContents(nodeToSplit.getContents(length/2), 0);
			nodeToSplit.setContents(null, length/2);
			greaterThanEqual.setChild(nodeToSplit.getChild(length/2), 0);
			greaterThanEqual.setSize(length/2+1);
		} else {
			for(int i = 0; i < length/2; i++) {
				greaterThanEqual.setContents(nodeToSplit.getContents(length-isNode-i), length/2-1-i);
				nodeToSplit.setContents(null, length-1-i);
				greaterThanEqual.setChild(nodeToSplit.getChild(length-i), length/2-i);
				nodeToSplit.setChild(null, length-i);
			}
			greaterThanEqual.setSize(length/2);
		}
		
		nodeToSplit.setSize(length/2); 
		
		//if there is no parent to the node that was just split, make one and have both nodes point to the new one
		if(nodeToSplit.getParent() == null) {
			BTreeNode parent = new BTreeNode(length);
			nodeToSplit.setParent(parent);
			greaterThanEqual.setParent(parent);
			parent.setChild(nodeToSplit, 0);
			parent.addChild(greaterThanEqual);
			parent.incSize();
		} else {
			//pass middle content value to parent btree node using add()
			current = nodeToSplit.getParent();
			if(current.size() == length-1) {
				current.addChild(greaterThanEqual);
				current.incSize();
				split(current);
			} else {
				current.addChild(greaterThanEqual);
				current.incSize();
			}
		}
	}
	
	//	inserts the node at the correct index of the correct bTreeNode
	private void insort(Node node) {
		Object[] indexToInsert = search(node.getName());
		current = (BTreeNode)indexToInsert[0];
		/*	don't need a special case for index 0 as the name to insert would always go to the BTreeNode to 
		 *	the left of the current if it is less than the current BTreeNode
		 */
		if(current.size() == length) { //prevents out of bounds exception for the contentShift method
			split(current);
			indexToInsert = search(node.getName());
			current = (BTreeNode)indexToInsert[0];
		} 
		current.addChild(node);
		size++;
	}
	
	/* no longer used as the merge function takes care of the insertion of the BTreeNode's into the correct indices
	//	inserts the BTreeNode at the correct index
	private void insort(BTreeNode bTreeNode) {
		Object[] indexToInsert = search(bTreeNode.getContents(0));
		current = (BTreeNode)indexToInsert[0];
		if(current.size() == length) {
			split(current);
			indexToInsert = search(bTreeNode.getContents(0));
			current = (BTreeNode)indexToInsert[0];
		}
		current.addChild(bTreeNode);
	}
	*/
	protected void add(String name, String index) {
		if(isEmpty()) {
			treeRoot = new BTreeNode(length);
			current = treeRoot;
			node.setName(name);
			node.setIndex(index);
			current.addChild(node);
			size++;
		}else {
			//call search to see if it exists, if not add it to the bPlusTree
			Object[] temp = search(name);
			current = (BTreeNode) temp[0];
			if (current.size() == current.getLength()) {
				split(current);
			} else {
				node = new Node();
				node.setName(name);
				node.setIndex(index);
				insort(node);
				size++;
			}
		}
	}
	
	//used to return the index that's stored in the node, does the same as the search function
	protected String databaseIndex(String name) {
		Object[] item = search(name);
		BTreeNode treeNode = (BTreeNode)item[0];
		int index = (int)item[1];
		if(treeNode.getContents(index).equalsIgnoreCase(name)) {
			Node node = (Node)treeNode.getChild(index);
			return node.getIndex();
		} else {
			return null;
		}
	}
	
	/* returns the node that has the exact name as the name being searched for or it returns null if the 
	 * node doesn't exist
	 */
	protected Node searchTree(String name) {
		current = treeRoot;
		do {
			if(isLeaf(current)) {
				int index = current.binarySearch(name, 0, current.size());
				node = (Node)current.getChild(index);
				if(node.getName().compareTo(name) == 0) {
					return node;
				} else {
					return null;
				}
				
			} else {
				current = (BTreeNode) current.getChild(current.binarySearch(name, 0, current.size()));
			}
			
		} while(true);	
	}
	
	/* The search function tests if the current node is a leaf and then uses the binary search function of the 
	 * bTree Node class to determine the location of the index where the node is found/needs to be inserted, or 
	 * gives the index where the next bTree Node that's closest to the value being searched for. Last returns 
	 * the bTreeNode and index of the where either the value exists or needs to be placed.
	 */
	private Object[] search(String name) {
		Object[] array = new Object[2];
		current = treeRoot;
		do {	
			if(isLeaf(current)) {
				// call binary search of the current btree node, and return the current node with the index
				array[0] = current; //BTreeNode 
				array[1] = current.binarySearch(name, 0, current.size()); //Index where the name is found in the BTreeNode  
				//returns the BTreeNode and the index to find the element or insert the element
				return array;
			} else {
				// find which child branch to transverse to using binary search of the current btree node  
				current = (BTreeNode) current.getChild(current.binarySearch(name, 0, current.size()));
			}
			
		} while(true);
	}
	
	//goes as far down to the left as possible then starts printing values from the furtherest left to the 
	//furtherest right
	protected void incOrderPrint() {
		current = treeRoot;
		while(current.getChild(0) instanceof BTreeNode) {
			current = (BTreeNode) current.getChild(0);
		}
		
		System.out.print("The B+ tree printed in order is: ");
		while(current != null) {						//current.getRightSibling() if this causes an error
			for(int i = 0; i < current.size(); i++) {	//loops to print out all contents in that bTree node
				System.out.print(((Node)current.getChild(i)).getName());	
			}
			current = current.getRightSibling();		//progressively from left to right printing out all leaf nodes
		}
	}
	
	/*	goes as far down to the right as possible then starts printing values from the furtherest right to the 
	 *	furtherest left
	 */
	protected void decOrderPrint() {
		current = treeRoot;
		while(current.getChild(current.size()) instanceof BTreeNode) {
			current = (BTreeNode) current.getChild(current.size());
		}
		
		System.out.print("The B+ tree printed in order is: ");
		while(current != null) {						//current.getLeftSibling() if this causes an error
			for(int i = 0; i < current.size(); i++) {	//loops to print out all contents in that bTree node
				System.out.print(((Node)current.getChild(i)).getName());	
			}
			current = current.getLeftSibling();		//progressively from right to left printing out all leaf nodes
		}
	}
	
	// searches for the name in the database then returns the next number of values (range) that match the 
	// entered value the most, simplest from of auto-complete, change to return an array of nodes
	protected String[] printSimilar(String name, int range) {
		String[] array = null;
		Object[] similarName = search(name);
		current = ((BTreeNode)similarName[0]);
		int index = (int)similarName[1];
		
		if(range < 0) {
			range *= -1;
			array = new String[range];
			if(range > current.size() - index) {
				for(int i = current.size()-1; i >= index; i--) {
					if(((Node)current.getChild(i)).getName().matches(name)) {
						array[i] = ((Node)current.getChild(i)).getName();
						range--;
					} else {
						return array;
					}
				}
				if(current.getLeftSibling() != null) {
					current = current.getLeftSibling();
					printSimilar(((Node)current.getChild(0)).getName(), -range);
				} else if (current.getRightSibling() != null){
					current = current.getRightSibling();
					printSimilar(((Node)current.getChild(0)).getName(), range);
				} else {
					return array;
				}
			}
		} else if(range > 1){
			array = new String[range];
			if(range > current.size() - index) {
				for(int i = index; i < current.size(); i++) {
					if(((Node)current.getChild(i)).getName().matches(name)) {
						array[i] = ((Node)current.getChild(i)).getName();
						range--;
					} else {
						return array;
					}
				}
				if(current.getRightSibling() != null) {
					current = current.getRightSibling();
					printSimilar(((Node)current.getChild(0)).getName(), range);
				} else if (current.getLeftSibling() != null) {
					current = current.getLeftSibling();
					printSimilar(((Node)current.getChild(0)).getName(), -range);
				} else {
					return array;
				}
			}
		} else {
			array = new String[1];
			if(current.getContents(index).equalsIgnoreCase(name)) {
				array[0] = name;
			}
		}
		return array;
	}
	
	//searches the tree then determines what category the item belongs too, then prints the other items in that
	//category that come alphabetically after the item returned
	protected Node[] returnSimilar(String name, int range) {
		Node[] array = null; //determined by how many results can be displayed per page
		Object[] similarName = search(name);
		current = (BTreeNode) similarName[0];
		int index = (int)similarName[1];

		if(range < 0) {
			range *= -1;
			array = new Node[range];
			if(range > current.size() - index) {
				for(int i = current.size()-1; i >= index; i--) {
					if(((Node)current.getChild(i)).getName().matches(name)) {
						array[i] = (Node)current.getChild(i);
						range--;
					} else {
						return array;
					}
				}
				if(current.getLeftSibling() != null) {
					current = current.getLeftSibling();
					returnSimilar(((Node)current.getChild(0)).getName(), -range);
				} else if (current.getRightSibling() != null){
					current = current.getRightSibling();
					returnSimilar(((Node)current.getChild(0)).getName(), range);
				} else {
					return array;
				}
			}
		} else if(range > 1){
			array = new Node[range];
			if(range > current.size() - index) {
				for(int i = index; i < current.size(); i++) {
					if(((Node)current.getChild(i)).getName().matches(name)) {
						array[i] = (Node)current.getChild(i);
						range--;
					} else {
						return array;
					}
				}
				if(current.getRightSibling() != null) {
					current = current.getRightSibling();
					returnSimilar(((Node)current.getChild(0)).getName(), range);
				} else if (current.getLeftSibling() != null) {
					current = current.getLeftSibling();
					returnSimilar(((Node)current.getChild(0)).getName(), -range);
				} else {
					return array;
				}
			}
		} else {
			array = new Node[1];
			if(current.getContents(index).equalsIgnoreCase(name)) {
				array[0] = (Node) current.getChild(index);
			} 
		}
		return array;
	}
	
	/* no longer use as the split function takes care of the resetting of the root node
	private void rootUpdate() {
		while(treeRoot.getParent() != null) {
			treeRoot = treeRoot.getParent();
		}	
	}
	*/
	//deletes the item from the Btree, and calls the merge function to see if the tree can be made smaller
	protected void delete(String name) {
		Object[] btreenode = search(name);
		current = (BTreeNode) btreenode[0];
		int index = (int)btreenode[1];
		Node nodeToDelete = ((Node)current.getChild(index));
		if(nodeToDelete.getName().equalsIgnoreCase(name)) {
			current.removeChild(index);
			//current.removeChild(nodeToDelete);
			if((current.getLeftSibling().size() + current.size()) < length) {
				merge(current.getLeftSibling(),current);
			} else if((current.size() + current.getRightSibling().size()) < length) {
				merge(current,current.getRightSibling());
			}
		}
	}
	
	/* every time a value is deleted from the BPlusTree, it checks in delete if the size of the right or left
	 * sibling's size plus it's own size is less than length, if so it merges the two nodes who's combined size
	 * is less than the length and then updates the parent BTreeNode of those two, the children and contents. 
	 */
	private void merge(BTreeNode left, BTreeNode right) {
		if(left.size() + right.size() < length) {
			for(int i = 0; i < right.size(); i++) {
				left.setContents(right.getContents(i), left.size() + i);
				left.setChild(right.getChild(i), left.size() + i + 1);
			}
			if(right.getRightSibling() != null) {
				left.setRightSibling(right.getRightSibling());
			}
			BTreeNode parent = left.getParent();
			left.setSize(left.size() + right.size());
			parent.removeChild(right);
		}
	}
	
	//	returns the total number of nodes in the tree, can be used as a this is how many items we have in our 
	// 	database.
	public int size() {
		return size;
	}
	
	//	used to see if the btreenode being tested is at the lowest level of the tree
	private boolean isLeaf(BTreeNode current) {
		
		return current.getChild(0) instanceof Node || current.getChild(0) == null;
	}
	
	//	test if the tree is empty, not really ever used outside of initializing the tree
	private boolean isEmpty() {
        return treeRoot == null;
    }
	
}