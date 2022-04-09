/**
 * name: Vidun Jayakody
 * id: 101224988
 * course: COMP1406
 * semester: Winter 2022
 * assignment: 5
 * comments:
*/

import java.util.Deque;
import java.util.ArrayDeque;

/* -----------------------------------------
   Note: The ArrayDeque is an implementation
         of the Deque ADT. That is, it is a
		 double-ended queue.

		 You can simulate both a Stack and
		 a regular Queue with this data structure
		 in the following way:

		 Stack: push  ~ addFirst
		        pop   ~ removeFirst

		 Queue: enqueue ~ addLast
		        dequeue ~ removeFirst
  ------------------------------------------ */

public class MyBlobs extends Blobs {

	// do NOT change or remove this constructor. We will use it to create
	// objects when testing your code. If it is removed, we cannot test
	// your code!
	public MyBlobs(){}

	/**
	 * Helper function for blobRecursive()
	 * @param row row numer of current pixel (int)
	 * @param col column numer of current pixel (int)
	 * @param blobSoFar queue of the pixels that are in the blob so far (Deque<Pixel>)
	 */
	@Override
	public void blobRecursiveHelper(int row, int col, Deque<Pixel> blobSoFar) {

		// if pixel is out of bounds, already visited, or has no ink, exit
		if (row < 0 || col >= image.cols || row >= image.rows || col < 0 || image.getPixel(row, col).visited || !image.getPixel(row, col).hasInk()) {
			return; // end explore
		} else {
			image.getPixel(row, col).setVisited(true); // mark pixel as visited
			blobSoFar.addLast(image.getPixel(row, col)); // add to end of queue
		}

		blobRecursiveHelper(row - 1, col, blobSoFar); // explore up using recursion
		blobRecursiveHelper(row, col + 1, blobSoFar); // explore right using recursion
		blobRecursiveHelper(row + 1, col, blobSoFar); // explore down using recursion
		blobRecursiveHelper(row, col - 1, blobSoFar); // explore left using recursion
	}

	/**
	 * Explores the blobs in the image
	 * @param row row numer of current pixel (int)
	 * @param col column numer of current pixel (int)
	 * @return array of pixels in the blob (Deque<Pixel>)
	 */
	@Override
	public Deque<Pixel> blobIterative(int row, int col) {


		Deque<Pixel> blobList = new ArrayDeque<Pixel>();
		Deque<Pixel> workingList = new ArrayDeque<Pixel>();

		// add pixel at (row,col) to workingList
		workingList.addLast(image.getPixel(row, col));

		// while workingList is not empty do
		while (!workingList.isEmpty()) {

			Pixel p = workingList.getFirst();
			workingList.removeFirst(); // some pixel removed from workingList

			// if p has ink AND has not been visited then
			if (p.hasInk() && !p.visited()) {
				p.setVisited(true); // mark p as visited
				blobList.addLast(p); // add p to back of blobList

				// for each immediate neighbour q of p, add q to workingList
				if (p.getCol() > 0)
					workingList.addLast(image.getPixel(p.getRow(), p.getCol()-1)); // explore left
				if (p.getRow() < image.rows - 1)
					workingList.addLast(image.getPixel(p.getRow()+1, p.getCol())); // explore bottom
				if (p.getCol() < image.cols - 1)
					workingList.addLast(image.getPixel(p.getRow(), p.getCol()+1)); // explore right
				if (p.getRow() > 0)
					workingList.addLast(image.getPixel(p.getRow()-1, p.getCol())); // explore top
			}
		}
		// output blobList
		return blobList;
	}
}