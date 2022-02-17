/**
 * name: Vidun Jayakody
 * id: 101224988
 * course: COMP1406
 * semester: Winter 2022
 * assignment: 2
 * comments:
*/

public class Circle extends Shape {

    private double radius;

    /* Constructor */
    public Circle(XYCoord centre, double radius) {
        // call super constructor
        super(centre);
        this.radius = radius;
    }

    /**
     * Calculates area of current object
     * @return : area (double)
     */
    @Override
    public double area() {
        return Math.PI * (radius*radius);
    }

    /**
     * Calculates perimiter of current object
     * @return : perimiter (double)
     */
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
