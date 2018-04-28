/**
 * Linked list node class for integer data nodes.
 * 
 * @author Leilani Hagen
 * @version 1.0
 * @since Apr 25, 2018
 *
 */
public class IntNode {
	
	// Member fields:
	private int data;
	private IntNode next;
	
	// Constructors:
	IntNode() {
		next = null;
	}
	IntNode(int data) {
		this.data = data;
		next = null;
	}

	// Setters/mutators:
	public void setNext(IntNode next) {
		this.next = next;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	// Getters/accessors:
	public IntNode getNext() {
		return next;
	}
	public int getData() {
		return data;
	}

}
