/***************************************************** w22
 * 
 * course: COMP1406
 * assignment: 1
 * question: PartTwo
 * 
 * name: Vidun Jayakody
 * id: 101224988
 * 
 * comments:
 *
 ********************************************************/

import java.util.Scanner;
public class PartTwo {

    /**
     * Computes everything needed to plot dataset to console graph
     * @param data : dataset (2D array of strings)
     * @param width : width for rolling average calculation
     */
    public static void plot(String[][] data, int width) {

        // find max value and length of max value
        double max = 0;
        int max_x = 0; 
        for (int i = 0; i < data.length; i++) {
            if (max < Double.parseDouble(data[i][1]))
                max = Double.parseDouble(data[i][1]);
            if (max_x < data[i][0].length())
                max_x = data[i][0].length();
        }

        double[] values = new double[data.length];
        double[] rolling_ave = new double[data.length];
        
        // for string formatting
        String max_y = (int)max +"";
        
        // populate values array with raw y values
        for (int i = 0; i < data.length; i++) values[i] = Double.parseDouble(data[i][1]);

        // populate rolling_average[] with rolling averages of values[]
        rolling_ave = A1Q1.rollingAverage(values, width);

        // scale the values to 40 dashes
        for (int i = 0; i < data.length; i++) {
            double num_dashes = (Double.parseDouble(data[i][1]) / max) * 40;
            double scaled_rolling_ave = (rolling_ave[i] / max) * 40;
            StringBuilder dashes = new StringBuilder("");

            // edge case for when value is 0 (still needs to draw rolling average astericks)
            if (num_dashes == 0) {
                for (int j = 0; j <= (int)scaled_rolling_ave; j++) {
                    if (j+1 == (int)scaled_rolling_ave)
                    dashes.append("*");
                    else
                    dashes.append(" ");
                }
            } else {
                // determine how many dashes to draw
                for (int j = 0; j < 40; j++) {
                    if (j+1 == (int)scaled_rolling_ave)
                        dashes.append("*");
                    else if (j+1 != (int)scaled_rolling_ave && j < num_dashes)
                        dashes.append("-");
                    else
                        dashes.append(" ");
                }
            }

            // format and print to console
            System.out.println(String.format("%" + max_x + "s |%-40s    %"+ (max_y.length() + (max_y.length() + (5 - max_y.length()))) +".3f", data[i][0], dashes, Float.valueOf(data[i][1])));
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // prompt user for number of data points
        System.out.print("enter number of data points: ");
        int num_data_points = Integer.parseInt(sc.nextLine());

        // prompt user for width of rolling average
        System.out.print("enter width for rolling average: ");
        int width = Integer.parseInt(sc.nextLine());

        // prompt user to enter datapoints
        System.out.println("enter data one line at a time (\"label, value\")");
        String data[][] = new String[num_data_points][];
        
        // split data by comma
        for (int i = 0; i < num_data_points; i++) {
            data[i] = sc.nextLine().split(",");
            // get rid of leading/trailing white spaces
            data[i][0] = data[i][0].stripLeading();
            data[i][0] = data[i][0].stripTrailing();
            data[i][1] = data[i][1].stripLeading();
            data[i][1] = data[i][1].stripTrailing();
        }

        plot(data, width); // plot the data to the console
        sc.close();
    }
}