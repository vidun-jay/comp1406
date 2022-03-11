/**
 * name: Vidun Jayakody
 * id: 101224988
 * course: COMP1406
 * semester: Winter 2022
 * assignment: 3
 * comments:
*/

public class SpecificBox extends Box {

   public SpecificBox(String label, String location, int size) {
      this.label = label;
      this.location = location;
      this.size = size;
   }

   @Override
   public int compareTo (Box b) {
      SpecificBox x = this; // X is the current object
      Box y = b; // Y is the input parameter

      /*
      Let X and Y be SpecificBox objects, then (in this order)

      a)  X < Y whenever X’s location is alphabetically “less than” Y’s location, or
      b)  X < Y whenever X and Y have the same location and length(X’s label) < length(Y’s
      label), or
      c) X < Y whenever X and Y have the same location, the lengths of their labels are the
      same, and A’s size is larger than Y’s size, or
      d)  X = Y whenever X and Y have the same location, their label lengths are the same
      and their sizes are the same,
      e)  Otherwise, Y < X
      */

      // if X comes before Y, return -1
      if (x.location.compareTo(y.location) < 0) {return -1;}
      // if X comes after Y, return 1
      else if (x.location.compareTo(y.location) > 0) {return 1;}
      // if locations are equal
      else if (x.location.compareTo(y.location) == 0) {

         // if length of x's label < length of y's label, return -2
         if (x.label.length() < y.label.length()) {return -2;}
         // if length of x's label > length of y's label, return 2
         else if (x.label.length() > y.label.length()) {return 2;}
         // if length of x's label = length of y's label
         else if (x.label.length() == y.label.length()) {

            // if size of x < size of y, return -3
            if (x.size < y.size) {return -3;}
            // if size of x > size of y, return 3
            else if (x.size > y.size) {return 3;}
            // all conditions are equivalent
            else if (x.size == y.size) {return 0;}

         }
      }
      return 0;
   }
}
