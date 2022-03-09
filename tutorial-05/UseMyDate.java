import java.util.Arrays;

public class UseMyDate{
    public static void main(String[] args){
        Date d1 = new MyDate(2002, Month.November, (byte)4);
        Date d2 = new MyDate("20030512");
        Date d3 = new MyDate(2001, Month.September, (byte)6);
        Date d4 = new MyDate(2001, Month.September, (byte)3);
        Date d5 = new MyDate(2001, Month.September, (byte)5);
        Date d6 = new MyDate(2003, Month.May, (byte)12);


        Date[] dates = {d1,d2,d3,d4,d5,d6};
        for(Date d : dates){
            System.out.println(d);
        }
        System.out.println(Arrays.toString(dates));
        Arrays.sort(dates);
        System.out.println(Arrays.toString(dates));
        

    }

}