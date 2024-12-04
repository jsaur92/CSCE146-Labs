//Written by Joe Hardy
//Comments for methods from https://cse.sc.edu/~shephejj/csce146/Labs/Lab07FruitTree.html
public class LinkedBST<T extends Comparable<T>> {
	
	private Node root;
	
	public LinkedBST() {
		root = null;
	}

    //add: Takes in a new element via a parameter and adds it to the tree
	public void add(T data) {
		if (root == null)
			root = new Node(data);
		else {
			Node curr = root;
			boolean placed = false;
			while (!placed) {
				if (data.compareTo(curr.data) < 0) {
					if (curr.left == null) {
						curr.left = new Node(data);
						placed = true;
					}
					else {
						curr = curr.left;
					}
				}
				else {
					if (curr.right == null) {
						curr.right = new Node(data);
						placed = true;
					}
					else {
						curr = curr.right;
					}
				}
			}
		}
	}
	
    //remove: Given an instance of a Comparable type it will remove that from the tree
	public void remove(T data) {
		Node curr = root;
		boolean finished = false;
		while (!finished) {
			
			if (data.compareTo(curr.data) < 0) {
				if (curr.left == null) {
					finished = true;
				}
				else if (curr.left.data == data) {
					Node scrap = curr.left.left;
					curr.left = curr.left.right;
					addNode(scrap, curr.left);
					finished = true;
				}
				else {
					curr = curr.left;
				}
			}
			else {
				if (curr.right == null) {
					finished = true;
				}
				else if (curr.right.data == data) {
					Node scrap = curr.right.right;
					curr.right = curr.right.left;
					addNode(scrap, curr.right);
					finished = true;
				}
				else {
					curr = curr.right;
				}
			}
		}
	}
	
	//Helper function for remove, to add whichever node isn't replacing the removed node's spot, keeping all of its children attached.
	private void addNode(Node child, Node parent) {
		if (child != null) {
			Node curr = parent;
			boolean placed = false;
			while (!placed) {
				if (child.data.compareTo(curr.data) < 0) {
					if (curr.left == null) {
						curr.left = child;
						placed = true;
					}
					else {
						curr = curr.left;
					}
				}
				else {
					if (curr.right == null) {
						curr.right = child;
						placed = true;
					}
					else {
						curr = curr.right;
					}
				}
			}
		}
	}
	
    //search: Given an instance of a Comparable type it will return true or false if that instance is found
	public boolean search(T data) {
		Node curr = root;
		boolean finished = false;
		while (!finished) {
			
			if (curr.data.compareTo(data) == 0)
				return true;
			
			if (data.compareTo(curr.data) < 0) {
				if (curr.left == null) {
					finished = true;
				}
				else {
					curr = curr.left;
				}
			}
			else {
				if (curr.right == null) {
					finished = true;
				}
				else {
					curr = curr.right;
				}
			}
		}
		return false;
	}
	
    //printPreOrder: Prints the elements in the tree via a pre-order traversal
	public void printPreOrder() {
		System.out.println("Printing the pre-order traversal");
		printPreHelper(root);
	}
	
	private void printPreHelper(Node node) {
		if (node != null) {
			System.out.println(node.data);
			printPreHelper(node.left);
			printPreHelper(node.right);
		}
	}
	
    //printInOrder: Prints the elements in the tree via an in-order traversal
	public void printInOrder() {
		System.out.println("Printing the in-order traversal");
		printInHelper(root);
	}
	
	private void printInHelper(Node node) {
		if (node != null) {
			printInHelper(node.left);
			System.out.println(node.data);
			printInHelper(node.right);
		}
	}
	
    //printPostOrder: Prints the elements in the tree via a post-order traversal
	public void printPostOrder() {
		System.out.println("Printing the post-order traversal");
		printPostHelper(root);
	}
	
	private void printPostHelper(Node node) {
		if (node != null) {
			printPostHelper(node.left);
			printPostHelper(node.right);
			System.out.println(node.data);
		}
	}
	
	class Node {
		T data;
		Node left;
		Node right;
		
		public Node(T data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

}
