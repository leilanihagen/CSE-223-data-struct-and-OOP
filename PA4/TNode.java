/**
 * DecisionTree node class. Each node should be thought of as it's own subtree, even if it's
 * children are null. This thinking permits the concept of having a TNode.add() that can be
 * called on any "subtree."
 * 
 * @author Leilani Hagen
 * @date May 25, 2018
 * @assignment PA4 - CSE223
 *
 */
public class TNode {
	
	public String data;
	public char type; // Q/A
	public TNode yes; // left -> question
	public TNode no; // right -> answer
	
	public TNode(String data, char type) {
		/* Main constructor. */
		
		this.data = data;
		this.type = type;
		yes = null;
		no = null;
	}
	public TNode() {
		/* Minimal constructor... */

		data = null;
		yes = null;
		no = null;
	}
	
	public TNode add(String data) {
		
		
	}

}
