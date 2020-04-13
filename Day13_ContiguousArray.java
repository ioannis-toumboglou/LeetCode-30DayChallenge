// Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1. 

package LeetCode;

import java.util.Arrays;

public class Day13_ContiguousArray {
	
	public static int findMaxLength(int[] nums) {
		
		int[] arr = new int[2*nums.length+1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxlen = 0, count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i]==0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;
	}

	public static void main(String[] args) {

		int[] nums = {0,1,0};
		
		System.out.println(findMaxLength(nums));

	}

}