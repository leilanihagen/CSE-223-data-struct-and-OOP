// TO DO: Write fraction normalizing/reducing method to call from
// the setters and constructors.

public class Fraction {

  // Member fields:
  private static int serialCounter = 1;
  private int serialNo;
  private int num;
  private int denom;

  // Constructor 1:
  public Fraction(int num, int denom) {
    this.serialNo = serialCounter++;
    this.num = num;
    this.denom = denom;
    System.out.println("Fraction("+num+", "+denom+")="+this.serialNo);
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
    if (this.undefined == true){
      return "NaN";
    }
    if (this.denom == 1){
      return Integer.toString(this.num);
    }
    return (Integer.toString(this.num) + "/" + Integer.toString(this.denom));
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

  public void condition() {
    // Flag divisions by 0 as undefined:
    if (this.denom == 0){
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
    int gcf = gcf();
    this.num = this.num/gcf;
    this.denom = this.denom/gcf;
  }

  public int gcf() { // ADD CACHEING, CLEAN UP
    // Base cases:
    if (this.num == 0){
      return this.denom;
    }
    if (this.denom == 0){
      return this.num;
    }

    // Internally convert negatives to positives: // FIX TO WORK WITH "NEW WAY"
    

    int posNum, posDenom; // Use local variations of member fields...
    if (this.num < 0){
      posNum = -this.num;
    } else posNum = this.num;
    if (this.denom < 0){
      posDenom = -this.denom;
    } else posDenom = this.denom;

    // Recursive step:
    int remainder = posNum % posDenom;

    //DEBUGGING//
    //System.out.println("num="+this.num+" denom="+this.denom+" rem.="+remainder+" serialNo="+this.serialNo);

    //OLD WAY: Create a new fraction and recursively call gcf on new instance (buggy):
    //Fraction intermediate = new Fraction(posDenom, remainder); // CONDENSE
    //NEW WAY: Intermediately undate -this- instance and call again... (no call to constructor,
    // should eliminate bug):
    this.num = this.denom; // Update values according to Euclid's Algorithm so that next recursive
    this.denom = remainder; // call brings us closer to the solution...
    return (this.gcf());
  }
}
