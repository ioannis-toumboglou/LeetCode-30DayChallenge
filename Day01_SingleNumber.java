// Given a non-empty array of integers, every element appears twice except for one. Find that single one.

package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Day01_SingleNumber {
	
	public static int singleNumber(int[] nums) {
		
		Map<Integer, Integer> m = new HashMap<>(); 
        
		for (int i = 0; i < nums.length; i++) { 
            if (m.containsKey(nums[i])) { 
                m.put(nums[i], m.get(nums[i]) + 1); 
            } else { 
                m.put(nums[i], 1); 
            } 
        } 

        for (int i = 0; i < nums.length; i++) {
            if (m.get(nums[i]) == 1) {
                return nums[i]; 
            }
        }
        
        return -1; 
    }

	public static void main(String[] args) {
		
		int[] array = {2,1,2};
		
		System.out.println(singleNumber(array));

	}

}
