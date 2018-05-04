import java.util.Scanner;

/**
 * IndexUtility() is the WordList helper class that handles reading input and mechanizes feeding
 * tokens from your input into a WordList. .buildIndex() accomplishes this by tokenizing input
 * using a Scanner, incrementing a position counter for each token/word scanned, and adding the new
 * word to the WordList.
 * 
 * @author Leilani Hagen
 * @date May 3, 2018
 * @assignment PA2 - CSE223
 */
public class IndexUtility {
	
	IndexUtility() {
	}
	
	public WordList buildIndex() {
		/* Scans System.in for tokens until none left and passes scanned tokens to
		   WordList.addWord() with the token and it's position as grabbed from the input stream. */
		
		WordList wl = new WordList();
		
		// Create a scanner on System.in for grabbing words:
		Scanner sc = new Scanner(System.in);
		String word;
		
		// Grab each word encountered and add it to wl with a unique position for every word:
		int position = 0;
		while (sc.hasNext()) {
			position++;
			word = sc.next().toLowerCase();
			wl.addWord(word, position);
		} sc.close();

		return wl;
	}
}