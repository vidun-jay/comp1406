public class ShapeExampleApp{

    private static double epsilon = 0.0000001;

    // private helper methods for the program
    private static boolean eq(double x, double y){
        return Math.abs(x-y) < epsilon;
    }

    private static void show(Object o){
        System.out.println(o.toString());
    }

    
    public static void main(String[] args){
        show("Simple Shape Example Program");
        show("----------------------------");

        XYCoord a = new XYCoord(1.0,1.0);
        XYCoord b = new XYCoord(1.5,10.1);
        XYCoord c = new XYCoord(21.5,11.4);
        XYCoord d = new XYCoord(19.6,0.4);

        // make a quadrilateral shape
        Shape s = new Quadrilateral(a,b,c,d);
        show("\nQuadrilateral!");
        show(s.toString());
        show("Quadrilateral's area = " + s.area());
        show("...expecting 193.54499999999996 : " + eq(193.54499999999996,s.area()));
        show("Quadrilateral's perimeter = " + s.perimeter());
        show("...expecting 58.92849121441224 : " + eq(58.92849121441224,s.perimeter()));

        // make a square
        s = new Square(new XYCoord(0,0), 25.5);
        show("\nSquare!");
        show(s.toString());
        show("Square's area = " + s.area());
        show("...expecting 650.25 : " + eq(650.25,s.area()));
        show("Square's perimeter = " + s.perimeter());
        show("...expecting 102.0 : " + eq(102,s.perimeter()));
        show("is Square a Shape     :" + (s instanceof Shape));
        show("is Square a Quadrilateral :" + (s instanceof Quadrilateral));
        show("is Square a Square    :" + (s instanceof Square));
        

        // make a circle
        s = new Circle(new XYCoord(3,1.5), 7.2);
        show("\nCircle!");
        show(s.toString());
        show("Circle's area = " + s.area());
        show("...expecting 162.8601631620949 : " + eq(162.8601631620949,s.area()));
        show("Circle's perimeter = " + s.perimeter());
        show("...expecting 45.23893421169302 : " + eq(45.23893421169302,s.perimeter()));

    
        // make a triangle
        s = new Triangle(new XYCoord(1,1), new XYCoord(1,3), new XYCoord(2,1));
        show("\nTriangle! (easy case... right angle horizontal base)");
        show(s.toString());
        show("Triangle's area = " + s.area());
        show("...expecting 1.0 : " + eq(1.0,s.area()));
        show("Triangle's perimeter = " + s.perimeter());
        show("...expecting 5.23606797749979 : " + eq(5.23606797749979,s.perimeter()));


        // make a triangle
        s = new Triangle(new XYCoord(0,0.1), new XYCoord(1,3), new XYCoord(2,1));
        show("\nTriangle! (arbitrary orientation)");
        show(s.toString());
        show("Triangle's area = " + s.area());
        show("...expecting 2.4499999999999997 : " + eq(2.4499999999999997,s.area()));
        show("Triangle's perimeter = " + s.perimeter());
        show("...expecting 7.496811527481515 : " + eq(7.496811527481515,s.perimeter()));


    }    


}