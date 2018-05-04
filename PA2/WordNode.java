/**
 * Linked list node class for WorldList nodes, which contain 3 pieces: String data to store the
 * word in the list, a reference to a PositionList that stores where this word occurs, and a
 * reference to the next WordNode in the WordList.
 * 
 * @author Leilani Hagen
 * @date Apr 28, 2018
 * @assignment PA2 - CSE223
 *
 */
public class WordNode {
	
	// Member fields:
	private String data;
	private PositionList occurances;
	private WordNode next;
	
	// Constructors:
	WordNode() {
		occurances = new PositionList();
		next = null;		
	}
	WordNode(String data) {
		this.data = data;
		occurances = new PositionList();
		next = null;
	}
                                                                                           
	// Setters/mutators:
	public void setData(String data) {
		this.data = data;
	}
	public void setOccurances(PositionList occurances) { // ONLY USE for re-initializing the head
		this.occurances = occurances;                    // /root of the PositionList.
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
	
	// WordNode wrapper for the PositionList.add() method:
	public void appendOccurances(int occuranceNum) {
		occurances.add(occuranceNum);
	}

}
