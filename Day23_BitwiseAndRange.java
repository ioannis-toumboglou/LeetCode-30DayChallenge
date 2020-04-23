/* Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

   Example 1:

   Input: [5,7]
   Output: 4

   Example 2:

   Input: [0,1]
   Output: 0 
*/

package LeetCode;

public class Day23_BitwiseAndRange {
	
	public static int rangeBitwiseAnd(int m, int n) {
		
		while (m < n) {
			n -= (n & -n);
		}
		
		return n;
	}

	public static void main(String[] args) {

		int m = 5;
		int n = 7;
		
		System.out.println(rangeBitwiseAnd(m,n));

	}

}
