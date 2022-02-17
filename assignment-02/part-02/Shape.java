public class Shape{

   // -------------------------------------------------
   // State of all Shapes
   // -------------------------------------------------
   protected final XYCoord anchor;
   

   // -------------------------------------------------
   // Constructors for the Shape class
   // -------------------------------------------------
   public Shape(double x, double y){
      this( new XYCoord(x,y) );
   }

   public Shape(XYCoord anchor){
      this.anchor = anchor;
   }


   /** Computes and returns the area of this shape. 
    * 
    * @return the area of <code>this</code> shape. 
    */
   public double area(){return -1.0;}


   /** Computes and returns the perimeter of this shape.
    * 
    * @return the perimeter of <code>this</code> shape. 
    */
   public double perimeter(){return -2.0;}

   @Override
   public String toString(){
      return "Shape anchored at " + this.anchor.toString();
   }

}