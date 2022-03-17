
/** A linked list implementation for the string-list ADT
 *
 * Represents a list S0, S1, S2, ..., Sn-1 of Strings
 */
public abstract class LinkedList{
	protected Node head;
	protected Node tail;
	protected int  size;

	/** Creates an empty linked list */
	public LinkedList(){
		head = tail = null;
		size = 0;
	}

	/** Creates a linked list with a single item (S0)
	 *
	 * @param s is string S0 in the created list of size 1.
	 */
	public LinkedList(String s ){
		head = tail = new Node(s);
		size = 1;
	}

   /* ------------------------------------------------- */
	/* ------------------------------------------------- */
	/* ------------------------------------------------- */
	/* ------------------------------------------------- */

   /** Adds a string to the front of the list
    * 
    * @param s is a string to be added to the front of the list.
    * @return this list (after adding s to the front of it)
    */
   public abstract LinkedList addFront(String s);
		
	/** Removes the first string in the list and returns it.
	 * 
	 * @return the first string S0 in the list, 
	 *         <code>null<\code> if the list is empty.
	 */
	/* remove elements from the front list */
	public abstract String removeFront();

	/** Find the position of a string in the list if it exists.
	 * 
	 * @param s is the target string to search for
	 * @return the first position in the list where s exists, 
	 *         -1 if s is not in the list. 
	 */
	public abstract int find(String sO);

	/** Set (modify) the string at a given position 
	 * 
	 * @param position is the position in the list to set
	 * @param s is the string that is being set at <code>position</code>
	 * @return true successful, false otherwise.
	 */ 
	public abstract boolean set(int position, String s);

	/** Remove and return the string at a given position.
	 * 
	 * @param position is the index in the list of the string to remove. 
	 * @return the string initially at <code>position</code>, 
	 *         or <code>null</code> is unsuccessful. 
	 */
	// public abstract String remove(int position);





   /* ------------------------------------------------- */
	/* ------------------------------------------------- */
	/* ------------------------------------------------- */
	/* ------------------------------------------------- */



	/** Getter for the size of the linked list
    *
  	 * @return the size of the liked list.
	 */
	public int getSize(){
		return size;
	}



   
	public String get(int position){
		// returns data of element at index position
		// returns null otherwise
		if( position < 0 || position > size -1 || head == null){
			return null;
		}
		int  count = 0;
		Node current = head;
		while(count < position){
			current = current.getNext();
			count += 1;
		}
		return current.getData();
	}



	
	/** Adds a string to the back of the linked list
	 * 
	 * @param d is a string to be added to the back of the current list
	 * @return this list (after d is added to it)
	 */ 
	public LinkedList addBack(String d){
		// add to back of list
		Node back = new Node(d);
		if( size == 0 ){
			head = tail = back;
		}else{
			tail.setNext(back);
			tail = back;
		}
		size += 1;
		return this;
	}

	public LinkedList addFrontHiddenImplentation(String d){
		// add to front of list
		Node front = new Node(d, head);
		head = front;
		if(size == 0){ tail = front; }
		size += 1;
		return this;
	}

	public LinkedList add(int position, String d){
		// add a new node with data d at given position
		// return null if method fails
		if( position < 0 || position > size){
			// position is invalid
			return null;
		}
		// check for adding to front or back
		if( position == 0){
			return addFrontHiddenImplentation(d);
		}else if( position == size ){
			return addBack(d);
		}

		// find node at index position-1
		Node prev = head;
		int count = 0;
		while( count < position-1 ){
			count += 1;
			prev = prev.getNext();
		} // prev will point to node before
		Node n = new Node(d, prev.getNext() );
		prev.setNext(n);
		size += 1;
		return this;
	}



	@Override
	public String toString(){
		if( size == 0 || head == null){
			return "[]";
		}
		String out = "[";
		Node current = head;
		for(int i=0; i<size-1; i=i+1){
			out += current.getData() + "]->[";
			current = current.getNext();
		}
		return out+current.getData() +"]";
	}
}
