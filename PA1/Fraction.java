// TO DO: Write fraction normalizing/reducing method to call from
// the setters and constructors.

public class Fraction {

  // Member fields:
  private int num;
  private int denom;
  private boolean undefined = false;

  // Constructor 1:
  public Fraction(int num, int denom) {
    this.num = num;
    this.denom = denom;
    this.condition();
  }

  // Constructer 2:
  public Fraction(int num) {
    this.num = num;
    this.denom = 1;
  }

  // Getters:
  public int getNum() {
    return this.num;
  }
  public int getDenom() {
    return this.denom;
  }

  // Setters (needed? if so, condition):
  public void setNum(int num) {
    this.num = num;
  }
  public void setDenom(int denom) {
    this.denom = denom;
  }

  public String toString() {
    this.condition();
    if (this.undefined == true){
      return "NaN";
    }
    if (this.denom == 1){
      return Integer.toString(this.num);
    }
    else return (Integer.toString(this.num) + "/" + Integer.toString(this.denom));
  }

//  public Fraction add(Fraction addend) {
//  }
//
//  public Fraction sub(Fraction subtrahend) {
//  }
//
//  public Fraction mul(Fraction multiplier) {
//  }
//
//  public Fraction div(Fraction divisor) {
//  }

  private void condition() {
    // Flag divisions by 0 as undefined:
    if (this.denom == 0){
      this.undefined = true;
    }
    // Reduce 0/num to 0/1:
    else if (this.num == 0){ // Do not modify denom. if it also ==0
      this.denom = 1;
    }
    // Keep negative sign placement consistent:
    if (this.denom < 0){
      this.num = -this.num;
      this.denom = -this.denom;
    }
    // Reduce:
    if (this.undefined == false && this.num != 0){
      int gcf = gcf();
      this.num = this.num/gcf;
      this.denom = this.denom/gcf;
    }
  }

  public int gcf() { // ADD CACHEING
    // Base cases:
    if (this.num == 0){
      return this.denom;
    }
    if (this.denom == 0){
      return this.num;
    }
    // Internally convert negatives to positives:
    int num, denom; // Use local variations of member fields...
    if (this.num < 0){
      num = -this.num;
    } else num = this.num;
    denom = this.denom; // denom should not be negative (pre-condition)... 
    // Recursive step:
    int remainder = num % denom;
    Fraction intermediate = new Fraction(denom, remainder); // CONDENSE
    return (intermediate.gcf());
  }
}
