/**
 * name: Vidun Jayakody
 * id: 101224988
 * course: COMP1406
 * semester: Winter 2022
 * assignment: 2
 * comments:
*/

import java.lang.Math;

public class Quadrilateral extends Shape {

    private XYCoord a;
    private XYCoord b;
    private XYCoord c;
    private XYCoord d;

    /* Constructor */
    public Quadrilateral(XYCoord a, XYCoord b, XYCoord c, XYCoord d) {
        super(a); // call super constructor with anchor "a" as input
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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
        double x4 = this.d.getX();
        double y4 = this.d.getY();

        // compute area (according to https://byjus.com/maths/area-of-quadrilateral/)
        return Math.abs((0.5) * ( (x1*y2 + x2*y3 + x3*y4 + x4*y1) - (x2*y1 + x3*y2 + x4*y3 + x1*y4) ));
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
        double x4 = this.d.getX();
        double y4 = this.d.getY();

        // compute length of each side
        double AB = Math.sqrt((Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2)));
        double BC = Math.sqrt((Math.pow((x3-x2), 2) + Math.pow((y3-y2), 2)));
        double CD = Math.sqrt((Math.pow((x4-x3), 2) + Math.pow((y4-y3), 2)));
        double AD = Math.sqrt((Math.pow((x4-x1), 2) + Math.pow((y4-y1), 2)));

        // return sum of the lengths of the side
        return AB + BC + CD + AD;
    }
}
