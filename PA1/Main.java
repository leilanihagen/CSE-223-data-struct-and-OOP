public class Main {
  public static void main(String[] args) {
//    Fraction test = new Fraction(5, 500);
//    test.condition();
//    System.out.println(test.toString());
//    Fraction test2 = new Fraction(-9, 0);
//    test2.condition();
//    System.out.println(test2.toString());
    
    Fraction test = new Fraction(24, -16);
    String str = test.toString();
    System.out.println(str);
    Fraction addend = new Fraction(14, 20);
    Fraction sum = test.add(addend);
    System.out.println("Sum= "+sum);
  }
} 
