public class MyDate extends Date{

    /** Constructors */
    public MyDate(int year, Month month, byte day) {
        super(year, month, day);
    }

    public MyDate(String yyyymmdd) {
        super(yyyymmdd);
    }

    @Override
    public String toString() {
        // output formatted string in "DD/MM/YYYY"
        return String.format("%02d/%02d/%d", this.day, this.month.map(), this.year);
    }

    @Override
    public int compareTo(Date d) {

        // compare years
        if (this.year < d.year) {return -1;}
        else if (this.year > d.year) {return 1;}

        else {
            // compare months
            if (this.month.map() < d.month.map()) {return -2;}
            else if (this.month.map() > d.month.map()) {return 2;}
            else {
                // copmare days
                if (this.day < d.day) {return -3;}
                else if (this.day > d.day) {return 3;}
                else {
                    return 0; // error condition
                }
            }
        }
    }
}
