/***************************************************** w22
 * 
 * course: COMP1406
 * assignment: 1
 * question: 1
 * 
 * name: Vidun Jayakody
 * id: 101224988
 * 
 * comments:
 * 
 ********************************************************/

public class A1Q1{

    /**
     * Calculates rolling average of a given dataset
     * @param data : data set (array of doubles, needs to be >= 0)
     * @param width : last n values (needs to be >= 1)
     * @return : array of all rolling averages
     */
    public static double[] rollingAverage(double[] data, int width){

        // this will be your output array
        double[] rollingAve = new double[data.length];
        double sum = 0; // initialize sum

        // loop through items in list
        for (int i = 0; i < data.length; i++) {
            sum += data[i]; // track running sum
            
            // not enough data points case returns NaN
            if (i < width - 1) {
                rollingAve[i] = Double.NaN;
            // "sliding window" functionality: subtract last element and add new element
            } else {
                if (i != width - 1)
                    sum -= data[i - width];
                rollingAve[i] = sum / (double)width;
            }
        }
        return rollingAve;
    }
}