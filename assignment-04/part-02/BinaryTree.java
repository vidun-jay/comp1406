/**
 * name: Vidun Jayakody
 * id: 101224988
 * course: COMP1406
 * semester: Winter 2022
 * assignment: 4
 * comments:
*/

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class BinaryTree {
	protected Node root = null;
  protected int  size = 0;

	public BinaryTree() {
		size = 0;
	}

  public BinaryTree(String s) {
		root = new Node(s);
		size = 1;
	}

	public int getSize(){ return this.size; }
	public Node getRoot(){ return this.root; }

	public Node getNode(Node node) { return node; }

	/**
	 * Convert nodes to ArrayList
	 * @return array of nodes (ArrayList<String>)
	 */
	private ArrayList<String> toArray() {
		ArrayList<String> nodes = new ArrayList<String>();
		inOrder(nodes, this.root);
		return nodes;
	}

	/**
	 * Traverse nodes recursively
	 * @param nodes array of node data (ArrayList<String>)
	 * @param current_root root node (Node)
	 */
	 public void inOrder(ArrayList<String> nodes, Node current_root) {
		 // if node isn't empty, recursively visit nodes (left to right) and add to array
		 if(current_root !=  null) {
			 inOrder(nodes, current_root.getLeft());
			 nodes.add(current_root.getData());
			 inOrder(nodes, current_root.getRight());
		 }
	 }

	/**
	 * Wrapper for contains method
	 * @param s string to look for (String)
	 * @return returns true if s in the this tree, false otherwise
	 */
	public boolean contains(String s) {
		// constraint:  this method MUST use recursion
		return contains(this.root, s);
	}

	/**
	 * Checks if target is in this tree
	 * @param current_node current root node (Node)
	 * @param target string to look for (String)
	 * @return true if target in the this tree, false otherwise
	 */
	private boolean contains(Node current_node, String target) {

		if (current_node == null || target == null) { return false; } // base cases

		int comp = target.compareTo(current_node.getData()); // compares target to data, stores as int

		if (comp == 0) { return true; } // target found, return true

		// recursively run check (first left, then right), return true if found
		if (contains(current_node.getLeft(), target) || contains(current_node.getRight(), target)) { return true; }

		return false; // if target not found return false
	}

	/**
	 * Checks if a tree is a valid BST
	 * @return true if this tree is a valid binary search tree, false otherwise
	 */
	public boolean isBST() {
		// note: an empty tree is a valid BST
		// notes: A BST object might NOT satisfy the binary search tree property.
		//        This method should not use instanceof. It should determine if the
		//        values and structure of this tree satisfy the binary search tree property or not.

		String prev = ""; // compare first element to empty string

		// check if every string in list is greater than last
		for (String current : toArray()) {
			if (current.compareTo(prev) < 0) { return false; }
			prev = current;
		}
		return true;
	}

	public void loadFromFile(String fname){
		BinaryTree bt = new BinaryTree();
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

	public void add(String s){
		addRandom(s);
	}

	/* add a node in a random place in the tree. */
	private void addRandom(String s){
		if(root == null && size == 0){
			root = new Node(s);
		}else{
		  Node tmp = root;
		  boolean left = Math.random() < 0.5;
		  Node child = left ? tmp.getLeft() : tmp.getRight();
		  while(child != null){
			tmp = child;
			left = Math.random() < 0.5;
			child = left ? tmp.getLeft() : tmp.getRight();
		  }
		  // assert: child == null
		  // yea! we have a place to add s
		  if(left){
		  	tmp.setLeft(new Node(s));
		  }else{
			  tmp.setRight(new Node(s));
		  }
		}
		size += 1;
	}

	/** Computes the height of the binary tree
	  *
		* The height is the length of the longest path from
		* the root of the tree to any other node.
		*
		* @return the height of the tree
		*/
	public final int height(){
	  if( root == null ){ return -1; }
	  if( size == 1){ return 0; }
	  return heightRecursive(root);
	}

	protected final static int heightRecursive(Node root){
		if( root == null ){
			return -1;
		}
		int leftHeight = heightRecursive(root.getLeft());
		int rightHeight = heightRecursive(root.getRight());
		if( leftHeight < rightHeight){
			return 1 + rightHeight;
		}else{
			return 1 + leftHeight;
		}
	}

	public static void main(String[] args){
		BinaryTree t = new BinaryTree("cat");
		System.out.println(t);
		System.out.println("height = " + t.height() + ",  size = " + t.getSize());
		t.add("dog");
		t.add("eel");
		t.add("cow");
		t.add("rat");
		System.out.println("\nheight = " + t.height() + ",  size = " + t.getSize());
		System.out.println(t);

		t.loadFromFile("sample.txt");
		System.out.println("\nheight = " + t.height() + ",  size = " + t.getSize());
		System.out.println(t);
	}

	@Override
	public String toString() {
		return PrintBinaryTree.toString(this);
	}


}
