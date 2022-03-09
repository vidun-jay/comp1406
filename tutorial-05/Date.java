
/**
Abstract Date class for tutorial.
<p>
Example class for tutorials in COMP 1006/1406. 
Students will override the comparable method. 

@author m. jason hinek
@version 1.01.2022

*/
public abstract class Date implements Comparable<Date>{

	protected int year;
	protected Month month;
	protected byte day;


	public Date(int year, Month month, byte day){
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public Date(String yyyymmdd){
		// imput must be 8 characters long...
		// days and month have a leading zero if needed
		this.year = Integer.parseInt(yyyymmdd.substring(0, 4));
		this.day = Byte.parseByte(yyyymmdd.substring(6, 8));
		int m = Integer.parseInt(yyyymmdd.substring(4,6));
		this.month = switch(m){
			case 1 -> Month.January;
			case 2 -> Month.February;
			case 3 -> Month.March;
			case 4 -> Month.April;
			case 5 -> Month.May;
			case 6 -> Month.June;
			case 7 -> Month.July;
			case 8 -> Month.August;
			case 9 -> Month.September;
			case 10 -> Month.October;
			case 11 -> Month.November;
			case 12 -> Month.December;
			default -> {this.year = 1970; this.day = 1; yield Month.January;}
		};		
	}


	/** 
	A string representation of a date is of the form "DD/MM/YYYY"
	
	@return a string representation of a date in the format "DD/MM/YYYY"
	*/
	public abstract String toString();

}