
public class Main {

	public static void main(String[] args) {
		
		IndexUtility IU = new IndexUtility();
		WordList l = IU.buildIndex();
		l.print();
	}

}
