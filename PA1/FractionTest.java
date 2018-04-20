public class FractionTest {
public static void main(String[] args) {
Fraction a=new Fraction(1,2); // a=1/2
Fraction b=new Fraction(4); // b=4
Fraction c,d,e;
System.out.println("5/2: "+new Fraction(125,50));
c=a.add(b);

System.out.println("1: " + new Fraction(1,2).mul(new Fraction(2)));
System.out.println("9/2: "+c);
c=a.sub(b);
System.out.println("-7/2: "+c);
c=b.sub(a);
System.out.println("7/2: "+c);
c=a.mul(b);
System.out.println("2: "+c);
System.out.println("4: "+c.mul(c));
d=new Fraction(3); // d=3
e=new Fraction(4); // e=4
c=d.div(e);
System.out.println("3/4: "+c);
a=e.div(d);
System.out.println("4/3: "+a);
c=a.mul(b); // c=16/3
System.out.println("16/3: "+c);
System.out.println("1/3=0.33333...:"+ new Fraction(1,3).toDouble());
System.out.println("1/0 (NaN): "+new Fraction(1,0));
a=new Fraction(1,2); // a=1/2
b=new Fraction(1,2); // b=1/2
c=a.sub(b); // c=0
a=a.div(c); // a=1/0
System.out.println("NaN: "+a.toDouble());
a=c.div(c); // a=0/0
System.out.println("NaN: "+a.toDouble());
System.out.println("NaN: "+new Fraction(-1,0).toDouble());
}
}
