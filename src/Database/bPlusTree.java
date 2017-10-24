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
		size = 0;
	}
	
	public int getLength() {
		return length;
	}
	
	/* if the bTree node can no longer contain any more nodes, then the bTree node is split into two bTree nodes
	 * where the values less than the middle index are stored in the first newly created bTree node, and the values
	 * greater than or equal to the middle value are stored in the second newly created bTree node. Then in the 
	 * parent node that was just split, the value to the left of the middle value goes from a node pointer to a 
	 * bTree node pointer, which points to the less than bTree node and the value to the right goes to the greater
	 * than bTree node. Last it calls leafUpdate function which connects all the leaf bTree nodes together.
	 */
	private void split(bTreeNode nodeToSplit) {
		bTreeNode lessThan = new bTreeNode(length);
		bTreeNode greaterThanEqual = new bTreeNode(length);
		for(int i = 0; i < length/2; i++) {
			lessThan.contents[i] = nodeToSplit.contents[i];
			greaterThanEqual.contents[length/2-i] = nodeToSplit.contents[length-1-i];
		}
		lessThan.setSize(length/2);
		greaterThanEqual.setSize(length/2);
		if((length/2)%2 == 1) {
			greaterThanEqual.contents[0] = nodeToSplit.contents[length/2+1];
			greaterThanEqual.incSize();
		}
		
		if(nodeToSplit.getParent() == null) {
			
		}
		
		lessThan.setParent(nodeToSplit);
		lessThan.setRightSibling(greaterThanEqual);
		greaterThanEqual.setParent(nodeToSplit);
		greaterThanEqual.setLeftSibling(lessThan);
		nodeToSplit.addChild(lessThan);
		nodeToSplit.addChild(greaterThanEqual);
	}
	
	//inserts and sorts the new item to the database, if the item doesn't already exist
	public void insort(String name, String index) {
		if(size() == 0) {
			treeRoot = new bTreeNode(length);
			current = treeRoot;
			Node.setName(name);
			Node.setIndex(index);
			current.addChild(Node);
			current.incSize();
			this.size++;
		} else {
			//call search to see if it exists, if not add it to the bPlusTree
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
		}
	}
	
	public boolean search(String name) {
		int index = treeRoot.binarySearch(name, 0, treeRoot.size());
		if(index == -1) {
			if(treeRoot.children[index+1] instanceof bTreeNode) {
				
			}
		}
		if(name.equalsIgnoreCase(treeRoot.contents[index])) {
			
		}
		return true;
	}
	
	public boolean search(String name, bTreeNode current) {
		
		return false;
	}
	
	//allows you to find the bTree node closest to the value you want to add or find in the bPlusTree
	public bTreeNode binarySearch(String name) {
		//finds the object by name in the database, and returns the key which will be the Index.
		
		if(isLeaf(treeRoot)) {
			if((treeRoot.size()/2)%2 != 1) {
				if(name.compareToIgnoreCase(current.nodeArray((treeRoot.size()/2+1))) < 0) {
					
				}
			
			} else {
				current.nodeArray((current.size()/2));
			}
			
		}
		
		
		if((current.size()/2)%2 != 1) {
			current.nodeArray((treeRoot.size()/2+1));
		} else {
			current.nodeArray((current.size()/2));
		}
		
		return current;
	}
	
	//goes as far down to the left as possible then starts printing values from the furtherest left to the 
	//furtherest right
	public void inOrderTransverse() {
		current = treeRoot;
		while(current.children[0] instanceof bTreeNode) {
			current = (bTreeNode) current.children[0];
		}
		
		System.out.print("The B+ tree printed in order is: ");
		while(current != null) {						//current.getRightSibling() if this causes an error
			for(int i = 0; i < current.size(); i++) {	//loops to print out all contents in that bTree node
				System.out.print(current.children[i]);	
			}
			current = current.getRightSibling();		//progressively from left to right printing out all leaf nodes
		}
	}
	
	//might not need 
	public void leafUpdate() {
		current = treeRoot;
		while(current.children[0] instanceof bTreeNode) {
			current = (bTreeNode) current.children[0];
		}
		current = current.getParent();
	}
	
	public void rootUpdate() {
		while(treeRoot.getParent() != null) {
			treeRoot = treeRoot.getParent();
		}	
	}
	
	//deletes the item from the database
	public void delete(String name) {
		size--;
		//searches for the item by name then removes it from the bPlusTree
	}
	
	public int size() {
		return size;
	}
	
	public boolean isLeaf(bTreeNode current) {
		return current.children[0] == null;
	}
	
	public boolean isEmpty() {
        return treeRoot == null;
    }
	
}
