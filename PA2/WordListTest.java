
public class WordListTest {

	public static void main(String[] args) {
		
		WordList wl = new WordList();
		wl.addWord("by", 1);
		wl.addWord("by", 2);
		wl.addWord("by", 3);
		wl.addWord("ay", 4);
		wl.addWord("cy", 5);
		
		WordNode head = wl.getHead();
		System.out.println("'ay'= " + head.getData());
		System.out.println("'ay' at pos. #4= " + ((IntNode)((head.getOccurances()).getPl())).getData());
		System.out.println("null= " + ((IntNode)((head.getOccurances()).getPl())).getNext());
		
		WordNode by = head.getNext();
		System.out.println("'by'= " + by.getData());
		System.out.println("'by' at #1= " + ((IntNode)((by.getOccurances()).getPl())).getData());
		System.out.println("'by' at #2= " + ((IntNode)((by.getOccurances()).getPl())).getNext().getData());
		System.out.println("'by' at #3= " + ((IntNode)((by.getOccurances()).getPl())).getNext().getNext().getData());
		
		WordNode cy = by.getNext();
		System.out.println("'cy'= " + cy.getData());
		System.out.println("'cy' at #5= " + ((IntNode)((cy.getOccurances()).getPl())).getData());
	}
}
