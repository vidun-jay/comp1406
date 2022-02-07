/*
 * A class to simulate rolling two die
 * 
 * course: 1406
 * tutorial: 3
 * question: 3
 * 
 * name: Vidun Jayakody
 * id: 101224988
 */

import java.util.Arrays;
import java.util.Random;

public class Tutorial03 {

	// an array of strings to use
	public static String[] words = {"cat", "dog", "eel", "owl", "fox", "kitten", "puppy", "elver", "owlet", "kit"};
	
	public static int[][] rollRandomDice(int n, long seed) {
		Random d1 = new Random();
		Random d2 = new Random();
		int[][] rolls = new int[6][6];

		// initialize grid with all 0s
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				rolls[i][j] = 0;
			}
		}

		// increment the rolls[] at certain index
		for (int i = 0; i < n; i++) {
			rolls[d1.nextInt(6)][d2.nextInt(6)]++;
		}

		return rolls;
	}
	
	public static void diceRollResults(int[][] rolls) {

		// display results of dice rolls
		System.out.println(Arrays.deepToString(rolls));
		
		// calculate number of rolls
		int numRolls = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				numRolls += rolls[i][j];
			}
		}

		// calculate probabilities
		double[] percentage = new double[12];
		for (int i = 0; i < rolls.length; i++) {
			for (int j = 0; j < rolls[i].length; j++) {
				percentage[i + j] += ((double)rolls[i][j] / ((double) numRolls) * 100);
			}
		}

		// print to console
		System.out.println("\nThe total number of rolls is " + numRolls + "\n");

		for (int i = 0; i < percentage.length - 1; i++) {
			System.out.println(String.format("The percentage of rolls of " + (i + 2) + " is %.2f%%", percentage[i]));
		}

	}
	
	public static void main(String[] args){
		
		// Question 3
		System.out.println("\nQuestion 3\n----------");
		int[][] rolls = rollRandomDice(36, 0);
		diceRollResults(rolls);
		
		// Question 4 [optional]
		// System.out.println("Question 4\n----------");
		// strings();
	}
}