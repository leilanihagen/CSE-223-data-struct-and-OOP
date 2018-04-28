/**
 * Linked list node class for WorldList nodes, which contain 3 pieces: String data to store the
 * word in the list, a reference to a PositionList that stores where this word occurs, and a
 * reference to the next WordNode in the WordList.
 * 
 * @author Leilani Hagen
 * @version 1.0
 * @since Apr 27, 2018
 *
 */
public class WordNode {
	
	// Member fields:
	private String data;
	private PositionList occurances;
	private WordNode next;
	
	// Constructors:
	WordNode() {
		occurances = null;
		next = null;		
	}
	WordNode(String data) {
		this.data = data;
		occurances = null;
		next = null;
	}
                                                                                           
	// Setters/mutators:
	public void setData(String data) {
		this.data = data;
	}
	public void setOccurances(PositionList occurances) {
		this.occurances = occurances;
	}
	public void setNext(WordNode next) {
		this.next = next;
	}
	
	// Getters/accessors:
	public String getData() {
		return data;
	}
	public PositionList getOccurances() {
		return occurances;
	}
	public WordNode getNext() {
		return next;
	}
}
