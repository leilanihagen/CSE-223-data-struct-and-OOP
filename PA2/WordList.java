/**
 * WordList creates an initial WordNode upon construction, which will later be initialized upon the
 * first add (there are no sentinel nodes).
 * 
 * .addWord(word, position) will do one of two things, in general: (1) if the word being added is
 * already in the list, it will locate this word by doing a traversal and data comparison on all
 * existing nodes, then append the position of the word being added to the PositionList associated
 * with the existing entry for this word; OR (2) if the word is not located in the list, a second
 * traversal of the WordList will be performed, searching for the word in WordList that is as
 * lexicographically similar to the new word, then it either insert the new word before or after
 * it's best found match.
 * 
 * .print() traverses the (sorted) WordList and prints the data at each node, along with a sorted
 * ascending list of all the positions at which this word occurs in the input.
 * 
 * @author Leilani Hagen
 * @date May 3, 2018
 * @assignment PA2 - CSE223
 *
 */
public class WordList {
	
	private WordNode handle;
	
	private static int TRIPVAL = 1000;
	
	WordList() {
		handle = new WordNode();
	}
	
	public void addWord(String word, int position) {
		/* Locate an exact match in the WordList of word and append to it's PositionList, or insert
		   word if it is new into the list in the correct location to maintain sorted order. */ 

		// Edge case for adding initial word to list:
		if (handle.getData() == null) { // Zero words in list...
			handle.setData(word);
			handle.appendOccurances(position);
			return;
		}
		
		// Traverse the WordList comparing String data, looking for a matching word:
		WordNode traverser = handle;
		while (traverser != null) {
			if ((traverser.getData()).equals(word)) {
				// Found match! Now append position to the PositionList associated with this word:
				traverser.appendOccurances(position);
				return;
			}
			traverser = traverser.getNext();
		} // No matching word found...
		
		// Traverse again, this time looking for the correct place to insert word:
		traverser = handle; // Restart the traverser at the head of the list.
		WordNode candidate = null;
		int smallestDiff = TRIPVAL; // Initialize to a ridiculously large number so that the first
		while (traverser != null) { // word compare satisfies the condition on line 58.
			if (Math.abs((traverser.getData()).compareTo(word)) < Math.abs(smallestDiff)) {
				smallestDiff = (traverser.getData()).compareTo(word);
				candidate = traverser; // Save the address of the current best-matched node...
			}
			traverser = traverser.getNext();
		} WordNode best = candidate; // Best has now been selected...
		
		// Insert the word:
		WordNode newNode = new WordNode(word); // Make a new WordNode to store our word.
		newNode.appendOccurances(position); // Append it's position (initialize the position list)
		if (smallestDiff < 0) { // compareTo() returned a negative value...
			// Insert newNode AFTER best:
			newNode.setNext(best.getNext());
			best.setNext(newNode);
		}
		else if (smallestDiff > 0) { // compareTo() returned a positive value...
			// Insert newNode BEFORE best:
			
			// Edge-case for replacing the handle:
			if (best.equals(handle)) {
				newNode.setNext(handle); // Link handle to newNode...
				handle = newNode; // Re-assign the handle to be newNode.
				return;
			}
			
			// General case:
			newNode.setNext(best.getNext()); // Link newNode to best's next.
			best.setNext(newNode);
		}

	}
	
	public void print() {
		/* Traverse the WordList and print the value stored in each WordNode along with the entries
		   in it's PositionList. */
		
		WordNode traverser = handle;
		while (traverser != null) {
			System.out.println(traverser.getData() + traverser.getOccurances().toString());
			traverser = traverser.getNext();
		}
	}

}