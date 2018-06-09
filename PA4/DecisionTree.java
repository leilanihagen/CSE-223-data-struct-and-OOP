import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Create and maintain a DecisionTree in memory throughout a gameplay lifecycle.
 * DecisionTree provides methods to serialize/deserialize the tree to/from a
 * file (or System.in/out, or other) and to add a question node to the tree in
 * the event that the tree led the gameplay system to the wrong answer.
 * 
 * High-level public methods keep the caller away from the underlying structure
 * of the decision tree itself and wrap all the functionality into 3 important
 * methods, .ingest(), .serialize(), and .addQuestion().
 * 
 * @author Leilani Hagen
 * @date May 29, 2018
 * @assignment PA4 - CSE223
 *
 */
public class DecisionTree {

	private TNode root = null;

	// Constructor:
	public DecisionTree() {
		/* Initialize the root node upon construction. */

		root = new TNode();
	}

	// // Getter:
	// public TNode getRoot() {
	// /* Access the root. */
	//
	// return root;
	// }
	//
	// // Setters:
	// public void setRoot(TNode root) { // REMOVE IF NOT USED
	// /* Set the root to a pre-existing tree's root... */
	//
	// this.root = root;
	// }
	// public void setYes(TNode yes) {
	// /* Set the yes subtree/node. */
	//
	// if (root != null) {
	// root.yes = yes;
	// }
	// return;
	// }
	// public void setNo(TNode no) {
	// /* Set the yes subtree/node. */
	//
	// if (root != null) {
	// root.no = no;
	// }
	// return;
	// }

	public void ingest(Scanner scanner) {
		/*
		 * Public wrapper for the .ingestRecursive() method (which operates on
		 * individual TNodes and therefore should not be visible to caller).
		 * 
		 * Call this method on your tree, passing a Scanner where your input data is
		 * coming from, and the method will construct your serial data into a
		 * DecisionTree in memory.
		 */

		ingestRecursive(scanner, root);
	}

	private void ingestRecursive(Scanner scanner, TNode node) {
		/*
		 * Recursively builds a full tree by grabbing lines from a Scanner on the
		 * database file/ System.in/etc. Uses NLR order to read lines and assemble them
		 * into the tree. It is essential that the nodes are written to the database
		 * file in the same NLR order (see .serializeRecursive())...
		 */

		// Build the tree:
		if (scanner.hasNextLine()) { // If there's one next line, there will be two.
			String typeString = scanner.nextLine();
			String dataString = scanner.nextLine();

			if (root == null) {
				return; // Catches all null node cases for recursive calls...
			}

			if (typeString.charAt(0) == 'A') { // Base case - at a leaf node.
				node.type = 'A';
				node.data = dataString;
				return;
			} else if (typeString.charAt(0) == 'Q') {
				// Node:
				node.type = 'Q';
				node.data = dataString;
				// Left:
				node.yes = new TNode();
				ingestRecursive(scanner, node.yes);
				// Right:
				node.no = new TNode();
				ingestRecursive(scanner, node.no);
			}
		}
		this.root = node;
	}

	public void serialize(PrintWriter writer) {
		/*
		 * Public method wrapper for the serializeRecursive() method which accepts a
		 * node and therefore breaks info-hiding convention for this class.
		 * 
		 * Simply specify the PrintWriter to which you would like to serialize and write
		 * out your tree!
		 */

		serializeRecursive(writer, root);
	}

	private void serializeRecursive(PrintWriter writer, TNode node) { // Error checking?
		/*
		 * Write the tree constructed in memory to a file for permanent storage. Written
		 * recursively with NLR tree traversal order.
		 */

		String aIndicator = "A:";
		String qIndicator = "Q:";

		if (node.type == 'A') { // Leaf base case...
			writer.println(aIndicator);
			writer.println(node.data);
			return;
		} else if (node.type == 'Q') {
			writer.println(qIndicator); // Writing for node.
			writer.println(node.data);

			serializeRecursive(writer, node.yes); // Write for left/yes.
			serializeRecursive(writer, node.no); // Write for right/no.
		}
	}

	// *******Error checking at this level?
	public void addQuestion(String wrongAnswer, String newQuestion, String correctAns) {
		/*
		 * Improve the brain! Traverses the tree for the node with data matching
		 * argument wrongAnswer and grabs it's node, then turns the wrongAnswer node
		 * into a new subtree containing a distinguishing question with children
		 * pointing (left/yes:) to the new and correct answer to the distinguishing
		 * question and (right/no:) the old "wrong" answer.
		 */

		TNode wrongAnswerNode = findQuestion(root, wrongAnswer);
		morphQuestionNode(wrongAnswerNode, newQuestion, correctAns);
		// Technically this is all we need...
	}

	private TNode findQuestion(TNode node, String question) {
		/*
		 * Traverses the tree, NLR, looking for an -answer- node (all answer nodes will
		 * be unique) with data matching question. Returns the matching answer node, or
		 * null if no matching node found.
		 */

		if (node == null || node.type == 'A') {
			return null; // Not found/base case..
		} else if (node.type == 'Q') {
			if (node.data.equals(question)) { // Node...
				return node;
			} else {
				TNode recurseYesResult = findQuestion(node.yes, question); // Left...
				if (recurseYesResult != null) {
					return recurseYesResult;
				} else {
					TNode recurseNoResult = findQuestion(node.no, question); // Right...
					if (recurseNoResult != null) {
						return recurseNoResult;
					}
				}
			}
		}
		return null; // Final filter - no matching node found through recursion...
	}

	private void morphQuestionNode(TNode wrongAnsNode, String newQuestion, String yesAnswer) {
		/*
		 * Morphs a leaf answer node into a new question subtree whose yes child is the
		 * new answer provided by the user (what the computer didn't guess correctly),
		 * and whose no child is the old (incorrectly guessed by the computer) answer.
		 * Eliminates the need to keep track of references to parent nodes, since the
		 * wrong answer node is morphed instead of replaced and relinked.
		 */

		// Capture the data from wrongAnsNode that will become the .no child of the
		// morphed node:
		String noAnswer = wrongAnsNode.data;

		// Morph wrongAnsNode:
		TNode morpher = wrongAnsNode; // morpher node will become the new question's node...
		morpher.type = 'Q'; // What was previously an answer node morphs into a question node.
		morpher.data = newQuestion;

		// Relink morpher to it's new children:
		morpher.yes = new TNode(yesAnswer, 'A');
		morpher.no = new TNode(noAnswer, 'A');

		// The garbage collector does the rest :)
	}

}