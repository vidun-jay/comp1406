/**
 * name: Vidun Jayakody
 * id: 101224988
 * course: COMP1406
 * semester: Winter 2022
 * assignment: 4
 * comments:
*/

import java.util.Scanner;
import java.io.File;

public class BST extends BinaryTree {

	// You MUST have a zero argument constructor that
	// creates an empty binary search tree
	// You can can add code to this if you want (or leave it alone).
	// We will create all BSTs for testing using this constructor
	public BST(){}

	/**
	 * Checks whether input string is in BST or not
	 * @param s string to look for (String)
	 * @return returns true if s in the this tree, false otherwise
	 */
	@Override
	public boolean contains(String s) {
		// precondition: s is string and this BST is a valid binary search tree
		// efficiency: (i) this method must be efficient
		//             (ii) do NOT use recursion for this method

		Node current_node = this.root;

		// as long as the current node is not null (end of branch)
		while (current_node != null) {

			int comp = s.compareTo(current_node.getData()); // compares s to data, stores as int

			// target found, return true
			if (comp == 0) { return true; }
			// if s is less than the current node, traverse to the left
			else if (comp < 0) { current_node = current_node.getLeft(); }
			// if s is greater than the current node, traverse to the right
			else if (comp > 0) { current_node = current_node.getRight(); }

		}
		return false; // otherwise, s is not found, return false
	}

	/**
	 * Wrapper method for add()
	 * @param s data for Node to add (String)
	 */
	@Override
	public void add(String s) {
		// precondition:  (i) s is a string
		//               (ii) this BST is a valid binary search tree
		// postcondition: (i) s is added to this tree, if it is not already
		//                    in the tree, and tree remains a valid binary search tree
		//               (ii) s is added as a leaf in the tree (if added)
		add(s, this.root);
	}

	/**
	 * Adds a node with data s such that binary tree is a valid binary search tree
	 * @param s data for Node to add (String)
	 * @param current_root current root node (Node)
	 * @return next Node to traverse (Node)
	 */
	private Node add(String s, Node current_root) {

		// base case for when tree is empty
		if (current_root == null && this.size == 0) {
			this.size++;
			this.root = new Node(s);
			return new Node(s);
		}

		// add node to tree
		if (current_root == null) {
			this.size++;
			return new Node(s); // add a new Node with data s
		}

		// recursively check where to put new Node
		if (current_root.getData().compareTo(s) > 0) {
			current_root.setLeft(add(s, current_root.getLeft()));
		} else {
			current_root.setRight(add(s, current_root.getRight()));
		}
		return current_root;
	}

	public BST makeBalanced(){
	return null;
	}

	@Override
	public void loadFromFile(String fname){
		BinaryTree bt = new BST();
		try{
			Scanner file = new Scanner( new File(fname) );
			while( file.hasNextLine()){
				bt.add(file.nextLine().strip());
			}
		}catch(Exception e){
			System.out.println("Something went wrong!!");
		}
		this.root = bt.root;
		this.size = bt.size;
	}

	public boolean saveToFile(String fname){
		return false;
	}
}