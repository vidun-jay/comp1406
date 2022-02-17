/**
 * name: Vidun Jayakody
 * id: 101224988
 * course: COMP1406
 * semester: Winter 2022
 * assignment: 2
 * comments:
*/

public class Triangle extends Shape {

    private XYCoord a;
    private XYCoord b;
    private XYCoord c;

    /* Constructor */
    public Triangle(XYCoord a, XYCoord b, XYCoord c) {

        super(a); // call super constructor
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Calculates area of current object
     * @return: area (double)
     */
    @Override
    public double area() {

        double x1 = this.a.getX();
        double y1 = this.a.getY();
        double x2 = this.b.getX();
        double y2 = this.b.getY();
        double x3 = this.c.getX();
        double y3 = this.c.getY();

        return Math.abs((x1 * (y2-y3) + x2 * (y3-y1) + x3 * (y1-y2)) / 2);
    }

    /**
     * Calculates perimiter of current object
     * @return: perimeter (double)
     */
    @Override
    public double perimeter() {

        double x1 = this.a.getX();
        double y1 = this.a.getY();
        double x2 = this.b.getX();
        double y2 = this.b.getY();
        double x3 = this.c.getX();
        double y3 = this.c.getY();

        double AB = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double BC = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        double AC = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));

        return AB + BC + AC;
    }
}
