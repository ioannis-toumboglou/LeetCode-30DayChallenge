/* Write an algorithm to determine if a number n is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with any positive integer, 
 * replace the number by the sum of the squares of its digits, and repeat the process until the number 
 * equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not. 
 */

package LeetCode;

public class Day02_HappyNumber {
	
	public static int newNumber(int number) {
		int newNumber = 0;
		
		while (number != 0) {
			newNumber = newNumber + (number % 10)*(number % 10);
			number /= 10;
		}
		
		return newNumber;
	}

	public static boolean isHappy(int number) {
		int counter = 1000;
		
		if (number == 1) {
			return true;
		}
		
		while (counter > 0) {
			number = newNumber(number);
			if (number == 1) {
				return true;
			} else {
				counter--;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int number = 19;
		
		System.out.println(isHappy(number));

	}

}
