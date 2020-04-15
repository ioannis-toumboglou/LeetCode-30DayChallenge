/* Given an array nums of n integers where n > 1,  return an 
 * array output such that output[i] is equal to the product of 
 * all the elements of nums except nums[i].
 * 
 * Constraint: It's guaranteed that the product of the elements of 
 * any prefix or suffix of the array (including the whole array) fits 
 * in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 */

package LeetCode;

public class Day15_ProductOfArrayExceptSelf {
	
	public static int[] productExceptSelf(int[] nums) {
		
		int[] newArray = new int[nums.length];
		int i = 0;
		int temp = 1;
		
		if (nums.length == 1) { 
            return nums; 
        }
		
		for (int j = 0; j < nums.length; j++) {
            newArray[j] = 1;
		}
		
		for (i = 0; i < nums.length; i++) { 
            newArray[i] = temp; 
            temp *= nums[i]; 
        }
		
		temp = 1;

		for (i = nums.length - 1; i >= 0; i--) { 
            newArray[i] *= temp; 
            temp *= nums[i]; 
        } 
        
		return newArray;
    
	}
	
	public static void printArray(int[] array) {
		
		System.out.print("[ ");
		
		for (int item : array) {
			System.out.print(item + " ");
		}
		
		System.out.print("]");
	}

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4};
		
		//System.out.println(productExceptSelf(nums));

		printArray(productExceptSelf(nums));
	}

}
