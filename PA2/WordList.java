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
		WordNode temp = handle;
		WordNode prev = temp; // init
		while (temp != null) {

			if ((temp.getData()).compareTo(word) == 0) {
				// Found match! Now append position to the PositionList associated with this word:
				temp.appendOccurances(position);
				return;
			}

			if (word.compareTo(temp.getData()) < 0) {
				WordNode newNode = new WordNode(word); // Make a new WordNode to store our word.
				newNode.appendOccurances(position);
				
				// Edge case for replacing the handle:		// Necessary???
				if (temp.equals(handle)) {
					newNode.setNext(handle);
					handle = newNode;
				}
				else {

					// Insert newNode between prev (node preceding traverser) and traverser:
//					newNode.setNext(traverser.getNext());
//					traverser.setNext(newNode);
					prev.setNext(newNode);
					newNode.setNext(temp);
				}
				return;
			}
			
			// else:
			// Keep looping:
			prev = temp; // Keep track of prev for inserting before traverser...
			temp = temp.getNext();
		}
		// If insert location not found within the list:
		WordNode newNode = new WordNode(word);
		newNode.appendOccurances(position);
		prev.setNext(newNode);

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