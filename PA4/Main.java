import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main class for a command-line interface to the 20+ questions game.
 * 
 * @author Leilani Hagen
 * @date May 26, 2018
 * @assignment PA4 - CSE223
 * 
 */
public class Main {

	public static void main(String args[]) { // ******* Put file creation in try/catch, not separte pw and sc...
		
		// Setup:
		System.out.println("Welcome to 20+ (or ++) questions!");
		System.out.println();
		Scanner fNameGetter = new Scanner(System.in);
		System.out.println("Please specify the file you would like to play the game with. But"
				+ " beware, the file you play with may grow it's brain smarter, and it may"
				+ " become more and more unbeatable as it learns your tricks...");
		System.out.println();
		while (true) {
			System.out.println("File name: ");
			if (fNameGetter.hasNextLine()) {
				String brainbase = fNameGetter.nextLine();
				
				File file;
				try {
					file = new File(brainbase);
					break;
				} catch(FileNotFoundException e) {
					System.out.println("Please check specified file permissions/existence and try again...");
				}
			} else {
				System.out.println("Please type the name of a file...");
			}
		} // Once loop exits, we should have a valid File object, ref. brainbase.
		

//		Scanner dbScanner;
//		try {
//			dbScanner = new Scanner(new File("database.txt"));
//		} catch (Exception e) {
//			System.out.println("Please check that the specified database file exists...");
//			e.printStackTrace();
//			return;
//		}
//		
//		PrintWriter dbWriter = new PrintWriter()
//	}

}
