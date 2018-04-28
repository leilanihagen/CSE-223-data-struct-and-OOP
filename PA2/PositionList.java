/**
 * An instance of PositionList creates a linked list of integers for keeping track of
 * the positions at which a given word of WordList occurs.
 * @author Leilani Hagen
 * @version 1.0
 * @since Apr 27, 2018
 *
 */
public class PositionList {

	private IntNode pl;
	
	PositionList() {
		pl = new IntNode(); 
	}
	
	@SuppressWarnings("null")
	public void add(int data) {
		/* Creates a new node with data value passed in arg, traverses the list
		   for the last node, and links the new node to the last node. */
		
		IntNode plNext = new IntNode(data);
		
		if (pl.getData() == 0) { // No position will be positon 0, so using this as a flag for an
			pl.setData(data);    // uninitialized PositionList...
			return;
		}
		IntNode temp = pl;
		while(temp.getNext() != null) { // Traverse for the end of the list.
			temp = temp.getNext(); // Advance temp...
		}
		temp.setNext(plNext); // "Dereference" temp and set it's object's next field to plNext (?)
	}
	
	public IntNode getPl() { // FOR TESTING ONLY
		return pl;
	}
}
