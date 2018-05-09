/**
 * An instance of PositionList creates a simple linked list of integers for keeping track of all
 * the positions at which a given word of a WordList occurs.
 * 
 * @author Leilani Hagen
 * @date Apr 28, 2018
 * @assignment PA2 - CSE223
 *
 */
public class PositionList {

	private IntNode handle;
	
	PositionList() {
		handle = new IntNode(0); // 0 as "empty node" flag (included for explicitness).
	}
	
	public void add(int data) {
		/* Creates a new node with data value passed in arg, traverses the list for the last node,
		   and links the new node to the last node. If the list handle does not contain a position
		   value, it's data will simply be initialized to the first position being added to the
		   given list. */

		// Use handle node for initial entry:
		if (handle.getData() == 0) { // No position will be position 0, so using this as a flag for an
			handle.setData(data);    // uninitialized PositionList...
			return;
		}
		
		// Create a new node for non-initial entries, then traverse for the end of the list:
		IntNode plNext = new IntNode(data);
		IntNode traverser = handle;
		while (traverser.getNext() != null) {
			traverser = traverser.getNext(); // Advance the traverser node...
		}
		traverser.setNext(plNext); // "Dereference" traverser and set it's object's next field to plNext.
	}
	
	public String toString() {
		/* Returns a space-separated list of all entries in the PositionList. */
		
		String runningList = "";
		IntNode traverser = handle;
		while (traverser != null) {
			runningList += " " + traverser.getData();
			traverser = traverser.getNext();
		}
		return runningList;
	}

}