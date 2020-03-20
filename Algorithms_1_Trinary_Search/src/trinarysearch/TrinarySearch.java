/**
 * HW 1: Recursion
 * Written for CSCI 333, Prof. Adam Whitley
 * Implements recursive trinary search of a sorted int[] in overloaded method trinarySearch. Main method implements test cases.
 * Author:		Jesse Reeve
 * Contact: 	jreeve@unca.edu
 * Created:		1/18/2019
 * Modified:	1/18/2019
 */

package trinarysearch;

public class TrinarySearch {
/**
 * Recursively searches an integer array, partitioning into thirds at each iteration.
 * @param intArray		the array to be searched.
 * @param value			the value to be located.
 * @param first			the first index of intArray to be searched.
 * @param last			the last index of intArray to be searched.
 * @return				index of value in intArray, or -1 if not found
 */
	static public int trinarySearch(int[] intArray, int value, int first, int last) {

		//base case
		if (last - first < 2) { //fewer than three indices remain
			if (intArray[first] == value) {//value located
				return first;
			}
			else if (intArray[last] == value) {//value located
				return last;
			}
			else return -1; //value not in array
		}//end if
		else {//recursive divide and conquer
		int firstBound = first + (last/3);
		int secondBound = first + (2*last)/3;
		if (value <= intArray[firstBound]) {
			return trinarySearch(intArray, value, first, firstBound);//first instance is in range first:firstBound
		}//end if
		else if (value <= intArray[secondBound]) {
			return trinarySearch(intArray, value, firstBound, secondBound);//first instance is in range firstBound:secondBound
		}//end if
		else
			return trinarySearch(intArray, value, secondBound, last);//first instance is in range secondBound:last
		}//end else
	}//end method trinarySearch (recursive)
	
	/**
	 *  Calls recursive trinarySearch method to search a sorted integer array for a value.
	 * @param intArray		the integer array to be searched
	 * @param value			the integer to be located in intArray
	 * @return index of value in intArray, or -1 if not found
	 */
	public static int trinarySearch(int[] intArray, int value) {
		if (intArray.length < 1 || value < intArray[0] || value > intArray[intArray.length-1]) {
			return -1;//terminate without recursion if value does not appear in sorted array
		}//end if
		else{
			return trinarySearch(intArray, value, 0, intArray.length-1);
		}//else
	}//end method trinarySearch
	
	/**
	 * Uses an array of sorted integer arrays to test the trinarySearch method.
	 * @param args
	 */
	public static void main(String[] args) {

		int testArrays[][] = {{0,1,2,3,4,5,6},{2,4,6},{1,4},{4,8},{0},{},{1,1,5,5,7,7},{1,4,4,4,4,4,4,7},{1,1,4,4,4,4,4,7}};
		
		for(int i=0; i<testArrays.length; i++) {
			System.out.printf("Testing array %d:\n", i);
			for(int j=0;j<testArrays[i].length;j++) {
				System.out.print(testArrays[i][j]+" ");				
			}//end for
			System.out.println();
			System.out.printf("Trinary search for integer 4: %d\n\n",trinarySearch(testArrays[i],4));
		}
		
	}//main

}