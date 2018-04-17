public class Main {
  public static void main(String[] args) {
    Fraction test = new Fraction(24, 16);
    int gcf = test.gcf();
    System.out.println(gcf);
    Fraction test2 = new Fraction(-9, 3);
    int gcf2 = test2.gcf();
    System.out.println(gcf2);
    
//    Fraction test = new Fraction(24, -16);
//    String str = test.toString();
//    System.out.println(str);
  }
} 
