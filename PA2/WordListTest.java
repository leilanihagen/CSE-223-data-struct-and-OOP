
public class WordListTest {

	public static void main(String[] args) {
		
		WordList wl = new WordList();
		wl.addWord("zy", 1);
		wl.addWord("by", 2);
		wl.addWord("by", 3);
		wl.addWord("by", 4);
		wl.addWord("ay", 5);
		wl.addWord("cy", 6);
		
		WordNode head = wl.getHead();
		System.out.println("'ay'= " + head.getData());
		System.out.println("'ay' at pos. #5= " + ((IntNode)((head.getOccurances()).getPl())).getData());
		System.out.println("null= " + ((IntNode)((head.getOccurances()).getPl())).getNext());
		System.out.println("'by'= " + (head.getNext()).getData());
		WordNode byNode = head.getNext();
		System.out.println();
		System.out.println("'by' at #2= " + ((IntNode)(((head.getNext()).getOccurances()).getPl())).getData());
		System.out.println("'by' at #3= " + ((IntNode)(((head.getNext()).getOccurances()).getPl())).getNext().getData());
//		System.out.println("'by' at #3= " + ((IntNode)(((head.getNext()).getOccurances()).getPl())).getNext().getNext().getData());
	}
}
