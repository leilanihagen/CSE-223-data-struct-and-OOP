
public class PositionListTest {

	public static void main(String[] args) {
		
		PositionList test = new PositionList();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		
		IntNode temp = test.getPl();
		System.out.println("1=" + temp.getData());
		temp = temp.getNext();
		System.out.println("2=" + temp.getData());
		temp = temp.getNext();
		System.out.println("3=" + temp.getData());
		temp = temp.getNext();
		System.out.println("4=" + temp.getData());
		temp = temp.getNext();
		System.out.println("5=" + temp.getData());
		
	}
}
