public class Main {
  public static void main(String[] args) {
//    Fraction a = new Fraction(5, 500);
//    a.condition();
//    System.out.println(a.toString());
//    Fraction a2 = new Fraction(-9, 0);
//    a2.condition();
//    System.out.println(a2.toString());
    
    Fraction a = new Fraction(1,2);

    String str = a.toString();
    System.out.println("fraction= "+str);

    Fraction b = new Fraction(2,3);

    Fraction c = a.add(b);
    System.out.println("fraction + "+b.toString()+"= "+c);

    c = a.sub(b);
    System.out.println("fraction - "+b.toString()+"= "+c);

    c = a.mul(b);
    System.out.println("fraction * "+b.toString()+"= "+c);

    c = a.div(b);
    System.out.println("fraction / "+b.toString()+"= "+c);

    System.out.println(a.toDouble());

  }
} 
