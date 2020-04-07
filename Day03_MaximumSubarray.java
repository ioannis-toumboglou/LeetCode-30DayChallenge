/* Given an integer array nums, find the contiguous subarray (containing at least one number) 
 * which has the largest sum and return its sum. 
 */

package LeetCode;

public class Day03_MaximumSubarray {

	public static int maxSubArray(int[] array) {
		int size = array.length;
		int max_so_far = array[0]; 
	    int curr_max = array[0]; 
	  
	    for (int i = 1; i < size; i++) { 
	        curr_max = Math.max(array[i], curr_max+array[i]); 
	        max_so_far = Math.max(max_so_far, curr_max); 
	    } 
	    
	    return max_so_far; 
		
	}
	
	public static void main(String[] args) {
		
		int[] array = {1,2,-1,-2,2,1,-2,1};
		
		System.out.println(maxSubArray(array));
	}

}
