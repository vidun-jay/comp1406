// name: Vidun Jayakody
// id: 101224988
// course: COMP1406C
// semester: Winter 2022
// current work: Network Automation Intern

public class Tutorial0{
   public static void main(String[] args){

      //
      // change the values of the strings
      // to include your own information
      //
      String name = "Vidun Jayakody";
      String course = "COMP1406";
      String tutorial ="COMP 1406-C2";
      String semester = "Winter 2022";

      
      //
      // you do not need to change anything
      // under this. But, you should read and understand
      // what is happening!
      //
      String first_line = course + " - " + semester; 
      String second_line = "name : " + name;
      String third_line =  "tutorial : " + tutorial;
      System.out.println(first_line);
      System.out.println("-".repeat(first_line.length()));
      System.out.println(second_line);
      System.out.println(third_line);

   }
}