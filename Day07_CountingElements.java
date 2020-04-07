/* Given an integer array, count element x such that x + 1 is also in array.
 * If there're duplicates in the array, count them separately.
 */

package LeetCode;

import java.util.Arrays;

public class Day07_CountingElements {

	public static int countElements(int[] array) {
		
		int counter = 0;
		
		Arrays.sort(array);
		
		for (int i=0; i<array.length; i++) {
			for (int j=i+1; j<array.length; j++) {
				if (array[j] == array[i] + 1) {
					counter++;
					j++;
					break;
				}
			}
			continue;
		}
		
		return counter;
	}
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3};
		
		System.out.println(countElements(array));
		
	}

}
