/**
 * Linked list node class for integer data nodes.
 * 
 * @author Leilani Hagen
 * @date Apr 25, 2018
 * @assignment PA2 - CSE223
 *
 */
public class IntNode {
	
	private int data;
	private IntNode next;
	
	IntNode() {
		/* No argument constructor. */

		next = null;
	}
	IntNode(int data) {
		/* Data-setting constructor. */

		this.data = data;
		next = null;
	}

	public void setData(int data) {
		/* data mutator. */		

		this.data = data;
	}
	public void setNext(IntNode next) {
		/* next mutator. */
		
		this.next = next;
	}
	
	public int getData() {
		/* data accessor. */

		return data;
	}
	public IntNode getNext() {
		/* next accessor. */
		
		return next;
	}

}
