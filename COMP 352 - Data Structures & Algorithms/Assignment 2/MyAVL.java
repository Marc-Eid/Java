

public class MyAVL {

	private int size; //stores the size of the input
	private int[] nums; //array of integers to store the elements in the inorder traversal
	private Node root; //Node that will hold the reference of the the tree 
	private int counter; //this counter is used to with the nums[] array

	//inner class
	private class Node {
		private int key;
		private String name;
		private Node left;
		private Node right;

		int height; //this serves to keep track whether or not the tree is balanced

		private Node(int data, String value) {
			this.key = data;
			this.name = value;
		}
	}
	
	//our wraper functions``````````````````````````````````````````
	
	
	//constructor method, constructs a new empty AVL tree
	public MyAVL() {
		root = null;
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	
	//sets the size of the tree and reallocate new memory fo rthe array with the new size
	public void SetSIDCThreshold(int size) {
		this.size = size;
		nums = new int[size];
	}

	public int generate() { //now generate runs n O(logn). since contains runs in O(n).
		int newNum;
		
		do{	
			newNum =  (int)(Math.random() * ((99999999 - 0) + 1)); //generate a random number
		}while(contains(newNum));	 //check whether the number is unique or not
		
		return newNum;
	}

	public int[] allKeys() { //inorder traversal O(n).
		number = 0;
		numberOfElements(root);
		SetSIDCThreshold(number);
		
		counter = 0; //start storing the elements in the num array from index 0
		showElements(root);
		
	
		return nums;
	}
	
	public void print() { //this method print the elements in the array after storing inorder elements in it
		nums = this.allKeys();
		int count = 0;
		for(int i = 0 ; i < nums.length; i++) {
			System.out.printf("%08d ", nums[i]);
			count++;
			if(count%15 == 0) {
				System.out.println();
				System.out.println();
			}
		}
		System.out.println();
	}
	
	//add a new node in the tree
	public void add(int key, String value) { //time complexity O(logn).
		root = insertNode(key, value, root);
	}

	//removes the node with the specified key from the tree
	public void remove(int key) {
		if(contains(key)) 
			SetSIDCThreshold(--size);
		
		root = deleteNode(key, root);
	}
	
	
	
	//returns the Name of the the student with the ID = key
	public String getValue(int key) {
		Node pos = getPosition(key, root);
		if(pos == null)
			return "Not Valid";
		return pos.name;
	}
	
	//returns the ID that comes next in the sorted sequence after the input key
	public int nextKey(int key) { //runs in O(n)
		int[] nextFinder = allKeys();
		for(int i = 0 ; i < size; i++)
			if(nextFinder[i] == key) //if key found
				if (i == size -1) //if key is last key return -1
					return -1;
				else
					return nextFinder[i+1]; //return next key
		return -1; //if key not found
	}
	
	//returns the ID that comes before the input key in the sorted sequence 
	public int prevKey(int key) { //runs in O(n)
		int[] prevFinder = allKeys();
		for(int i = 0 ; i < size; i++)
			if(prevFinder[i] == key) //if key found
				if (i == 0) //if key is first key return -1
					return -1;
				else
					return prevFinder[i-1]; //return next key
		return -1; //if key not found
	}
	
	//returns the number of IDs in the range of key1 and key2
	public int range(int key1, int key2) { //runs in O(n)
		if (key1 > key2)
			return -1;
		
		int[] rangeFinder = allKeys();
		int first = 0;
		int second = 0;
		
		for(int i = 0; i < size; i++) {
			if( rangeFinder[i] < key1)
				first++;
			if(rangeFinder[i] < key2)
				second++;
		}
		
		if(key1 == rangeFinder[0])
			first++;
		if(key1 != rangeFinder[0])
			return second - first - 1;
		
		
		return second - first;
	}
	
	//returns the size of the tree
	public int getSize() {
		return size;
	}
	
	

	//helper private functions`````````````````````````````````````````````````````
	
	private void updateHeight(Node node) {
		int leftChildHeight;
		int rightChildHeight;
		
		if(node == null) {
			leftChildHeight = -1;
			rightChildHeight = -1;
			return;
		}else {
			leftChildHeight = height(node.left);
			rightChildHeight = height(node.right);
		}
		
		node.height = Math.max(leftChildHeight, rightChildHeight) + 1;
	}


	
	private Node rebalance(Node node) {
	    int balanceFactor = balanceFactor(node);

	    // Left-heavy?
	    if (balanceFactor < -1) {
	      if (balanceFactor(node.left) <= 0) {
	        // Rotate right
	        node = rotateRight(node);
	      } else {
	        // Rotate left-right
	        node.left = rotateLeft(node.left);
	        node = rotateRight(node);
	      }
	    }

	    // Right-heavy?
	    if (balanceFactor > 1) {
	    	if (balanceFactor(node.right) >= 0) {
	    		// Rotate left
	    		node = rotateLeft(node);
	    	} else {
	    		// Rotate right-left
	    		node.right = rotateRight(node.right);
	    		node = rotateLeft(node);
	    	}
	    }

	    return node;
	}

	private Node rotateRight(Node node) {
		Node leftChild = node.left;

		node.left = leftChild.right;
		leftChild.right = node;

		updateHeight(node);
		updateHeight(leftChild);

		return leftChild;
	}

	private Node rotateLeft(Node node) {
		Node rightChild = node.right;

		node.right = rightChild.left;
		rightChild.left = node;

		updateHeight(node);
		updateHeight(rightChild);

		return rightChild;
	}

	private int balanceFactor(Node node) {
		if(node == null)
			return 0;
		else
			return height(node.right) - height(node.left);
		
	}

	
	private int height(Node node) {
		return node != null ? node.height : -1;
	}

	
	
	public Node insertNode(int key, String name, Node node) {
		// No node at current position --> store new node at current position
		if (node == null) {
			node = new Node(key, name);
		}

		// Otherwise, traverse the tree to the left or right depending on the key
		else if (key < node.key) {
			node.left = insertNode(key, name, node.left);
		} else if (key > node.key) {
			node.right = insertNode(key, name, node.right);
		} else {
			throw new IllegalArgumentException("BST already contains a node with key " + key);
		}

		
		updateHeight(node);
		return rebalance(node);
	
	}
	
	
	
	
	
	public Node deleteNode(int key, Node node) {
		// No node at current position --> go up the recursion
		if (node == null) {
			return null;
		}

		// Traverse the tree to the left or right depending on the key
		if (key < node.key) {
			node.left = deleteNode(key, node.left);
		} else if (key > node.key) {
			node.right = deleteNode(key, node.right);
		}

		// At this point, "node" is the node to be deleted

		// Node has no children --> just delete it
		else if (node.left == null && node.right == null) {
			node = null;
		}

		// Node has only one child --> replace node by its single child
		else if (node.left == null) {
			node = node.right;
		} else if (node.right == null) {
			node = node.left;
		}

		// Node has two children
		else {
			deleteNodeWithTwoChildren(node);
		}

		
		
		updateHeight(node);
		return rebalance(node);
		
	}

	


	private void deleteNodeWithTwoChildren(Node node) {
		// Find minimum node of right subtree ("inorder successor" of current node)
		Node inOrderSuccessor = findMinimum(node.right);

		// Copy inorder successor's data to current node
		node.key = inOrderSuccessor.key;
		node.name = inOrderSuccessor.name;

		// Delete inorder successor recursively
		node.right = deleteNode(inOrderSuccessor.key, node.right);
	}

	private Node findMinimum(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	  
	  //this can help us to verify if the key is already inserted. it takes less time and less space O(logn).  
	  public boolean contains(int key) {
		  return isInTree(key, root);
	  }

	  
	  private boolean isInTree(int key, Node subRoot) { //time complexity O(nlogn).
		  if(subRoot == null)
			  return false;
		  else if(subRoot.key == key)
			  return true;
		  else if(key < subRoot.key)
			  return isInTree(key, subRoot.left);
		  else
			  return isInTree(key, subRoot.right);
	  }

	  
	  private void showElements(Node subRoot) { //inorder traversal


		  if(subRoot != null) {
			  showElements(subRoot.left);
			  nums[counter++] = subRoot.key;
			  showElements(subRoot.right);
		  }else
			  return;
	  }

	  
	  
	  private Node getPosition(int key, Node subRoot) { //similar to searchNode
		  if(subRoot == null)
			  return null;
		  else if(subRoot.key == key)
			  return subRoot;
		  else if(key < subRoot.key)
			  return getPosition(key, subRoot.left);
		  else
			  return getPosition(key, subRoot.right);


	  }

	  
	  private boolean isInternal(Node n) {
		  if(n.left == null && n.right == null)
			  return false;
		  else
			  return true;
	  }

	  public int  number = 0 ;
	  
	  public void numberOfElements(Node subRoot) { //inorder traversal

		  if(subRoot != null) {
			  numberOfElements(subRoot.left);
			  number++;
			  numberOfElements(subRoot.right);
		  }else
			  return;
	  }
	  

//	  public Node searchNode(int key) {
//		  return searchNode(key, root);
//	  }
//
//	  private Node searchNode(int key, Node node) {
//		  if (node == null) {
//			  return null;
//		  }
//
//		  if (key == node.key) {
//			  return node;
//		  } else if (key < node.key) {
//			  return searchNode(key, node.left);
//		  } else {
//			  return searchNode(key, node.right);
//		  }
//	  }
	  
	  
	  

}
