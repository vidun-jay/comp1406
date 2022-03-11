import java.util.Arrays;

public class SampleBoxes{

   public static void main(String[] args){
      Box b1 = new SpecificBox("Cat", "Ottawa", 12);
      Box b2 = new SpecificBox("Dogs", "Ottawa", 7);
      Box b3 = new SpecificBox("Dogs", "Ajax", 17);
      
      Box[] boxes = {b1,b2,b3};
      System.out.println( Arrays.toString(boxes) );

      Arrays.sort(boxes);
      System.out.println( Arrays.toString(boxes) );

   }
}