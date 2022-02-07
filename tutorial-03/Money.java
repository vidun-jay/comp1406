/*
 * A class to model currency (money) as dollars and cents
 * 
 * course: 1406
 * tutorial: 3
 * question: 1-2
 * 
 * name: Vidun Jayakody
 * id: 101224988
 */
 
public class Money{

  /* attributes */ 
  public int dollars = -1;
  public int cents = -1;
  
  public Money(){ 
		// create an object with zero dollars and cents.
    this.dollars = 0;
    this.cents = 0;
  }
  
  public Money(int c){
		// create an object with c cents
		// (adjusting dollars and cents so that 0<=cents<=99)
    this.dollars = c / 100;
    this.cents = c % 100;
  }
  
  public Money(int d, int c){
		// create an object with d dollars and c cents
		// (adjusting dollars and cents so that 0<=cents<=99)
    this.dollars = d;
    this.cents = c;
  }
  
  /*
  // OPTIONAL
  public Money(int[] coins){
	  // input array have 6 elements and corresponds to 
		// {#toonies, #loonies, #quarters, #dimes, #nickels, #pennies}
    // {$2, $2, $0.25, $0.10, $0.05, $0.01}		
		// create an object with total money passed in array 
		// (adjusting internal dollars and cents so that 0<=cents<=99)
  } */

  public Money add(int d, int c) {
    // adds d dollars and c cents to the current money object // (like the constructors, the internal state of the object // will always have 0 <= cents <= 99)
    // pre-conditions: d >= 0 and c >= 0.
    // return a reference to the current object
    this.dollars += d;
    this.cents += c;
    return this;
  }

  public Boolean remove(int d, int c) {
  // removed d dollars and c cents from the current money object if possible // pre-conditions: d >= 0 and c >= 0.
  // returns true if d dollars and c cents was removed, false otherwise
    if (this.dollars - d >= 0 && this.cents - c >= 0) {
      this.dollars -= d;
      this.cents -= c;
      return true;
    }
    else
      return false;
  }
  public static void main(String[] args){
    // some basic testing 
    Money m1 = new Money();
    Money m2 = new Money(12,76);
    Money m3 = new Money(234);

    System.out.print("checkng m1:");
    if( m1.dollars == 0 && m1.cents == 0){
        System.out.println("passed");
    }else{
        System.out.println("failed");
        System.out.println("--- expected dollars = 0, cents = 0");
        System.out.println("---   actual dollars = " + m1.dollars + ", cents = "+ m1.cents);
        
    }

    System.out.print("checkng m2:");
    if( m2.dollars == 12 && m2.cents == 76){
        System.out.println("passed");
    }else{
        System.out.println("failed");
        System.out.println("--- expected dollars = 12, cents = 76");
        System.out.println("---   actual dollars = " + m1.dollars + ", cents = "+ m1.cents);
        
    }

    System.out.print("checkng m3:");
    if( m3.dollars == 2 && m3.cents == 34){
        System.out.println("passed");
    }else{
        System.out.println("failed");
        System.out.println("--- expected dollars = 2, cents = 34");
        System.out.println("---   actual dollars = " + m1.dollars + ", cents = "+ m1.cents);
        
    }

    // Question 2 testing
    Money m = new Money();
    m.add(1,1);
    System.out.println(m.toString() + "  expecting $1.01");
    m.add(0,2);
    System.out.println(m.toString() + "  expecting $1.03");
    m.remove(1,2);
    System.out.println(m.toString() + "  expecting $0.01");
    m.remove(1,1);
    System.out.println(m.toString() + "  expecting $0.01 (no change)");
  }

  /** 
   * Returns a String representation of the value of the current object. 
   * 
   * @return The value of the current object is returned as the <code>String</code>"$D.cc"
   * where D is the number of dollars and cc is the cents of the value.  Uses the <code>format()</code>
   * method from the <code>String</code> class to ensure that the cents are displayed properly (2 spaces
   * with leading zeros if needed).
   **/
  public String toString(){
    return "$" + String.format("%01d", dollars) + "." + String.format("%02d", cents);
  }
}