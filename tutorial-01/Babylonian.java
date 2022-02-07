/*
name: Vidun Jayakody
id: 101224988
course: Introduction to Computer Science II
### Tutorial 1 ###
*/

// if we want to get user input at any time later
import java.util.Scanner;

public class Babylonian {

  //
  // access    non-access  return  method    (input paramaters with types)
  // modifier  modifier    type    name                   (if any)
  //   
     public    static      double  babylonian(double N, double epsilon){
        // body of method in a block of code wrapped in curly braces { }
        double sqrt = -1.0;
        
        double m1 = 0.5 * N; // N/2
        double m2 = 0.5 * (m1 + N/m1); // average of m1 and N/m1

        while (Math.abs(m1-m2) >= epsilon) {
            m1 = m2;
            m2 = 0.5 * (m1 + N/m1);
        }

        sqrt = m2;
        
        // this method returns something that is NOT void and so  
        // it must have a return statement (it could have more than one)
        return sqrt;
    }

    public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    // prompt user for positive integer
    System.out.print("Enter a postive integer: ");
    String n = scanner.next();

    // if input is "exit", exit
    if (n.contains("exit")) {
        System.exit(0);
    }
    
    // only allow user to enter positive integers
    while (Double.parseDouble(n) < 0) {
        System.out.println("Only enter positive numbers.");
        System.out.print("Enter a postive integer: ");
        n = scanner.next();
    }
    
    scanner.close(); // so that VS code stops yelling at me >:(
    
    // convert user input from string to double and print results
    double n_value = Double.parseDouble(n);
    double epsilon = 0.01;
    double math_sqrt = Math.sqrt(n_value);
    double babylonian_sqrt = babylonian(n_value,epsilon);

    System.out.println("\nBabylonian Square Root Computation");
    System.out.println("            n = " + n_value);
    System.out.println(" Math.sqrt(n) = " + math_sqrt);
    System.out.println("babylonian(n) = " + babylonian_sqrt);
    System.out.println(" |difference| = " + Math.abs(math_sqrt-babylonian_sqrt));

    }
}