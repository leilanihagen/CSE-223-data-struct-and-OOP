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
	
	private String data;
	private PositionList occurrences;
	private WordNode next;
	
	WordNode() {
		/* No argument constructor. Initializes a new PositionList and sets next and data to null.
		   */

		data = null;
		occurrences = new PositionList();
		next = null;
	}
	WordNode(String data) {
		/* Data-setting constructor. Initializes a new PositionList, sets next to null, and sets
		   the string data to the data provided in the argument. */

		this.data = data;
		occurrences = new PositionList();
		next = null;
	}
                                                                                           
	public void setData(String data) {
		/* data mutator. */

		this.data = data;
	}
	public void setOccurances(PositionList occurrences) {
		/* occurrences mutator. */

		this.occurrences = occurrences;
	}
	public void setNext(WordNode next) {
		/* next mutator. */

		this.next = next;
	}
	
	public String getData() {
		/* data accessor. */

		return data;
	}
	public PositionList getOccurances() {
		/* occurrences accessor. */

		return occurrences;
	}
	public WordNode getNext() {
		/* next accessor. */

		return next;
	}

	boolean hasNext() {
		/* Boolean initialized checker for next. */

		if (next != null) {
			return true;
		} else { 
			return false;
		}
	}
	
	public void appendOccurances(int occuranceNum) {
		/* WordNode wrapper for the PositionList.add() method. */

		occurrences.add(occuranceNum);
	}

}
