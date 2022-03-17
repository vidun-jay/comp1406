/** A linked list implementation for the string-list ADT
 *
 * Represents a list S0, S1, S2, ..., Sn-1 of Strings
 */
public class LList extends LinkedList{

	/** Creates an empty linked list */
	public LList(){super();}

	/** Creates a linked list with a single item (X0)
	  *
		* @param s is string X0 in the created list of size 1.
		*/
	public LList(String s ){
		super(s);
	}

   /** Adds a string to the front of the list
    * 
    * @param s is a string to be added to the front of the list.
    * @return this list (after adding s to the front of it)
    */
	@Override
	public LinkedList addFront(String s) {

		Node new_node = new Node(s);

		if (this.getSize() == 0) {
			head = new_node;
		} else {
			Node tmp = head;
			head = new_node;
			head.next = tmp;
		}
		size++;
		return this;
	}

	/** Removes the first string in the list and returns it.
	 * 
	 * @return the first string S0 in the list, 
	 *         <code>null<\code> if the list is empty.
	 */
	/* remove elements from the front list */
	@Override
	public String removeFront() {
		String data = head.data;
		head = head.next;
		size--;
		return data;
	}

	/** Find the position of a string in the list if it exists.
	 * 
	 * @param s is the target string to search for
	 * @return the first position in the list where s exists, 
	 *         -1 if s is not in the list. 
	 */
	@Override
	public int find(String s) {
		Node tmp = this.head;
		int count = 0;

		while (tmp != null) {
			if (tmp.data == s) {
				return count;
			} else {
				tmp = tmp.getNext();
				count++;
			}
		}
		return -1;
	}

	/** Set (modify) the string at a given position
	 *
	 * @param position is the position in the list to set
	 * @param s is the string that is being set at <code>position</code>
	 * @return true successful, false otherwise.
	 */
	@Override
	public boolean set(int position, String s) {
		if( position < 0 || position > size -1 || head == null){
			return false;
		}
		int  count = 0;
		Node current = head;
		while(count < position){
			current = current.getNext();
			count += 1;
		}
		current.setData(s);
		return true;
	}
}