/**
 * Linked list node class for integer data nodes.
 * 
 * @author Leilani Hagen
 * @version 1.0
 * @since Apr 25, 2018
 *
 */
public class StrNode {
	
	// Member fields:
	private String data;
	private StrNode next;
	
	// Constructor:
	StrNode(String data) {
		this.data = data;
	}

	// Setters/mutators:
	public void setNext(StrNode next) {
		this.next = next;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	// Getters/accessors:
	public StrNode getNext() {
		return next;
	}
	public String getData() {
		return data;
	}

}
