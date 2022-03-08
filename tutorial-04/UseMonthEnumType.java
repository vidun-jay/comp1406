/** Tutorial 4 - Winter 2022
 * <p>Class for enumeration testing, includes <code>main</code> method that prints various methods of the <code>Month</code> class.</p>
 * @author Vidun Jayakody
 * @version 1.0.0
*/

public class UseMonthEnumType{

	/**
	 * Returns the number of days in a given month
	 * @param month month object
	 * @return integer number of days in input month object
	 */
	public static int days(Month month) {
		int days = 0;

		switch (month) {
			// months with 31 days
			case JANUARY: case MARCH: case MAY: case JULY: case AUGUST: case OCTOBER: case DECEMBER:
				days = 31;
				break;
			// februrary (28 days)
			case FEBRUARY:
				days = 28;
				break;
			// months with 30 days
			case APRIL: case JUNE: case SEPTEMBER: case NOVEMBER:
				days = 30;
				break;
			}

		return days;
	}

	public static void main(String[] args){
		// a Month object
		Month current = Month.SEPTEMBER;

		// all enum objects have a pre-defined toString() method
		System.out.println("the current month is " + current.toString());

		// the values() method returns an array of all constants (objects)
		// in the order that they appear in the enum declaration/definition
		for(Month m : Month.values()){
			System.out.println(m.toString());
		}

		// the valueOf(String) method returns the enum object corresponding to the
		// input string (if it exitst)
		current = Month.valueOf("OCTOBER");
		System.out.println("the new current month is " + current.toString());


		//
		// try uncommenting this code to see what happens
		//

		// current = Month.valueOf("September");
		// System.out.println("the new current month is " + current.toString());

	}
}
