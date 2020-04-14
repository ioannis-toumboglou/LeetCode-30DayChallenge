/* You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift). 
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 *
 * Return the final string after all operations.
 */

package LeetCode;

public class Day14_PerformStringShifts {
	
	public static String stringShift(String s, int[][] shift) {
		
		for (int[] item : shift) {
			if (item[0] == 0) {
				for (int i=0; i<item[1]; i++) {
					char ch = s.charAt(0);
					s = s.substring(1, s.length()) + ch;
				}
			} else if (item[0] == 1) {
				for (int i=0; i<item[1]; i++) {
					char ch = s.charAt(s.length()-1);
					s = ch + s.substring(0, s.length()-1);
				}
			}
		}
		
		return s;
	}

	public static void main(String[] args) {
		
		String s = "abcdefg"; 
		int[][] shift = {{1,1},{1,1},{0,2},{1,3}};
		
		System.out.println(stringShift(s, shift));

	}

}
