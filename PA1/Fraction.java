import java.lang.Double;

/**
* Fraction class that creates an interface for creating and using Fraction objects of the form
* (int numerator)/(int denominator). The class provides public methods for accessing the numerator
* and denominator separately, for representing the fraction as a String and as a double,
* and for adding, subtracting, multiplying, and dividing by other Fraction objects.
*
* @author Leilani Hagen
* @version 1.0
* @since 2018-04-19
*/
public class Fraction {

  // Member fields:
  private int num;
  private int denom;

  // Constructor 1:
  public Fraction(int num, int denom) {
    /* Main constructor for building new Fractions. Calls the condition() on fractions at
       construction. */

    this.num = num;
    this.denom = denom;
    this.condition();
  }

  // Constructer 2:
  public Fraction(int num) {
    /* Constructs a fraction out of whole number when only a numerator is provided. */

    this.num = num;
    this.denom = 1;
  }

  // Getters:
  public int getNum(int num) {
    return this.num;
  }
  public int getDenom(int denom) {
    return this.denom;
  }

  public String toString() {
    /* Returns a String representation of the instance Fraction. */

    if (this.denom == 0){ // Flag
      return "NaN";
    }
    if (this.denom == 1){
      return Integer.toString(this.num);
    }
    return (Integer.toString(this.num) + "/" + Integer.toString(this.denom));
  }

  public double toDouble() {
    /* Converts the instance Fraction to double. */

    if (this.denom == 0){
      return Double.NaN;
    }
    return ((double)this.num/this.denom);
  }

  public Fraction add(Fraction addend) {
    /* Computes the Fraction sum of the instance Fraction plus the addend Fraction. */

    if (this.denom == addend.denom){ // Already have common denominator.
      return (new Fraction(this.num + addend.num, this.denom)); // Calling the constructor again
    } // Else:                                                // ensures fraction gets reconditioned.
    int thisScaledNum = this.num * addend.denom;
    int addendScaledNum = addend.num * this.denom;
    int commonDenom = this.denom * addend.denom;
    return (new Fraction(thisScaledNum + addendScaledNum, commonDenom));
  }

  public Fraction sub(Fraction subtrahend) {
    /* Computes the Fraction difference of the instance Fraction minus the subtrahend Fraction. */

    if (this.denom == subtrahend.denom){
      return (new Fraction(this.num - subtrahend.num, this.denom));
    } // Else:
    int thisScaledNum = this.num * subtrahend.denom;
    int subtrahendScaledNum = subtrahend.num * this.denom;
    int commonDenom = this.denom * subtrahend.denom;
    return (new Fraction(thisScaledNum - subtrahendScaledNum, commonDenom));
  }

  public Fraction mul(Fraction multiplier) {
    /* Computes the Fraction product of the instance Fraction times the multiplier Fraction. */

    return (new Fraction(this.num * multiplier.num, this.denom * multiplier.denom));
  }

  public Fraction div(Fraction divisor) {
    /* Computes the Fraction quotient of the instance Fraction divided by the divisor Fraction. */

    if (divisor.num == 0){
      return (new Fraction(1, 0));
    }
    return (new Fraction(this.num * divisor.denom, this.denom * divisor.num));
  }

  private void condition() {
    /* Fraction "conditioning" method that reduces fractions to simplest form (eliminates common
       factors from the numerator and denominator) and reformats negative fractions. */

    // Keep negative sign placement consistent (placed before any conditinals with returns, to be
    // done first):
    if (this.denom < 0){
      this.num = -this.num;
      this.denom = -this.denom;
    }
    // Force numerator to 1 in undefined fractions (num/0) and return (conditioning complete).
    if (this.denom == 0){ // BUG FIX for exceptions caused by trying to reduce 0/0 (2018-04-21).
      this.num = 1;
      return; // Bug fix.
    }
    // Reduce 0/num to 0/1:
    if (this.num == 0){ // Do not modify denom. if it also ==0
      this.denom = 1;
      return; // Bug fix.
    }
    // Reduce:
    int gcf = gcf(this.num, this.denom);
    this.num = this.num/gcf;
    this.denom = this.denom/gcf;
  }

  private static int gcf(int a, int b) {
    /* General purpose gcf method which takes two input values and finds their greatest common
       factor. Recursively implements Euclid's Algorithm. */

    // Base cases:
    if (a == 0){
      return b;
    }
    if (b == 0){
      return a;
    }
    // Convert negative inputs to positives:
    a = (a < 0)? -a:a;
    b = (b < 0)? -b:b;
    // Recursive step:
    int remainder = a % b;
    return(gcf(b, remainder));
  }
}
