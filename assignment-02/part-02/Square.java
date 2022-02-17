/**
 * name: Vidun Jayakody
 * id: 101224988
 * course: COMP1406
 * semester: Winter 2022
 * assignment: 2
 * comments:
*/

public class Square extends Quadrilateral {

    private double length;

    /* Constructor */
    public Square(XYCoord anchor, double length) {

        // call super constructor
        super(anchor,
        new XYCoord(anchor.getX(), anchor.getY() + length),
        new XYCoord(anchor.getX() + length, anchor.getY() + length),
        new XYCoord(anchor.getX() + length, anchor.getY()));

        this.length = length;
    }

    /**
     * Calculates area of current object
     * @return: area (double)
     */
    @Override
    public double area() {
        return length * length;
    }

    /**
     * Calculates perimiter of current object
     * @return: perimiter (double)
     */
    @Override
    public double perimeter() {
        return 4 * length;
    }
}
