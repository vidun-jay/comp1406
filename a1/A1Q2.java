/***************************************************** w22
 * 
 * course: COMP1406
 * assignment: 1
 * question: 2
 * 
 * name: Vidun Jayakody
 * id: 101224988
 * 
 * comments:
 *
 ********************************************************/
import java.lang.Math;

public class A1Q2 {

    /**
     * Check if two floating point numbers are close enough to each other
     * @param x : first number
     * @param y : second number
     * @param epsilon : tolerance value
     * @return : whether or not x and y are practically equivalent (true/false)
     */
    public static boolean compareFloat(double x, double y, double epsilon) {
        if (Math.abs(x - y) < epsilon) return true;
        else return false;
    }

    /**
     * Calculate the peaks of the data set
     * @param data : dataset (array of doubles, needs to be >= 0)
     * @param epsilon : tolerance value (needs to be > 0)
     * @return : return 2D array of doubles, in the format [[value1, value2, ...], [index1, index2, ...]]
     */
    public static double[][] peaks(double[] data, double epsilon) {
        
        int count = 0;
        // edge cases
        if (data[0] > data[1]) count++;
        if (data[data.length - 1] > data[data.length - 2]) count++;

        // find how many local maxima there are in array
        for (int i = 1; i < (data.length - 1); i++) {
            if (data[i] > data[i-1] && data[i] > data[i+1] ) {
                    if (compareFloat(data[i], data[i-1], epsilon) == false && compareFloat(data[i], data[i+1], epsilon) == false)
                        count++;
            }
        }

        // output array
        double[][] out = new double[2][count];
        int index = 0;

        // edge cases
        if (data[0] > data[1]) {
            index = 1;
            out[0][0] = data[0];
            out[1][0] = 0;
        } if (data[data.length - 1] > data[data.length - 2]) {
            out[0][count - 1] = data[data.length - 1];
            out[1][count - 1] = data.length - 1;
        }
               
        // add peaks to array
        for (int i = 1; i < (data.length - 1); i++) {
            if (data[i] > data[i-1] && data[i] > data[i+1]) {
                // mitigating representational error of floating point values
                if (compareFloat(data[i], data[i-1], epsilon) == false && compareFloat(data[i], data[i+1], epsilon) == false) {
                    out[0][index] = data[i];
                    out[1][index] = i;
                    index++;
                }
            }
        }
        return out;
    }    
}