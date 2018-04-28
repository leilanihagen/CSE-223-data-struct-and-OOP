/**
 * An instance of PositionList creates a linked list of integers for keeping track of
 * the positions 
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
	
	public void add(int data) {
		/* Creates a new node with data value passed in arg, traverses the list
		   for the last node, and links the new node to the last node. */
		
		IntNode plNext = new IntNode(data);
		
		while(pl.getNext() != null) { // Traverse for the end of the list.
			pl.setNext(pl.getNext());
		}
		pl.setNext(plNext); // List 
	}
}
