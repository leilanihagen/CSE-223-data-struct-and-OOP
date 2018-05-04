/**
 * Implemented without sentinel node...
 * 
 * @author Leilani Hagen
 * @date May 3, 2018
 * @assignment PA2 - CSE223
 *
 */
public class WordList {
	
	private WordNode wl;
	
	private static int TRIPVAL = 1000;
	
	WordList() {
		wl = new WordNode();
	}
	
	public void addWord(String word, int position) {

		// Edge case for adding initial word to wl:
		if (wl.getData() == null) { // Zero words in wl...
			wl.setData(word);
			wl.appendOccurances(position); // Does this fix the bug?
			return;
		}
		
		// Traverse the WordList comparing String data, looking for a matching word:
		WordNode traverser = wl;
		while (traverser != null) {
			if ((traverser.getData()).equals(word)) {
				// Found match! Now append position to the PositionList associated with this word:
				traverser.appendOccurances(position);
				return;
			}
			traverser = traverser.getNext();
		} // No matching word found...
		
		// Traverse again, this time looking for the correct place to insert word:
		traverser = wl; // Restart the traverser at the head of the list.
		WordNode insertLoc = null;
		int bestMatch = TRIPVAL; // Initialize to a ridiculously large number so that the first
		while (traverser != null) { // word compare satisfies the condition on line 27.
			if (Math.abs((traverser.getData()).compareTo(word)) < Math.abs(bestMatch)) {
				bestMatch = (traverser.getData()).compareTo(word);
				insertLoc = traverser; // Save the address of the current best-matched node...
			}
			traverser = traverser.getNext();
		} // insertLoc should now contain the address of the node to insert word near...
		
		// Insert the word:
		WordNode newWord = new WordNode(word); // Make a new WordNode to store our word.
		newWord.appendOccurances(position); // Append it's position (initialize the position list)
		if (bestMatch < 0) { // compareTo() returned a negative value...
			// Insert newWord AFTER insertLoc:
			newWord.setNext(insertLoc.getNext());
			insertLoc.setNext(newWord);
		}
		else if (bestMatch > 0) { // compareTo() returned a positive value...
			// Insert newWord BEFORE insertLoc:
			
			// Edge-case for replacing the root:
			if (insertLoc.equals(wl)) {
				newWord.setNext(wl); // Link root to newWord (which will become the new root...)
				wl = newWord; // Re-assign the root to be newWord.
				return;
			}
			
			// General case:
			newWord.setNext(insertLoc.getNext()); // Link newWord to insertLoc's next.
			insertLoc.setNext(newWord);
		}

	}
	
	public void print() {
		/* Traverse the WordList and print the value stored in each WordNode along with the entries
		   in it's PositionList. */
		
		WordNode temp = wl;
		while (temp != null) {
			System.out.println(temp.getData() + temp.getOccurances().toString());
			temp = temp.getNext();
		}
	}
	
	public WordNode getHead() { // FOR TESTING ONLY, DELETE
		return wl;
	}

}