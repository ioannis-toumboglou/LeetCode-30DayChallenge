/*  You have a queue of integers, you need to retrieve the first unique integer in the queue.

	Implement the FirstUnique class:

    FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
    int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 
    if there is no such integer.
    void add(int value) insert value to the queue.
*/

package LeetCode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Day28_FirstUniqueNumber {
	
	Set<Integer> set;
    Set<Integer> all;

    public Day28_FirstUniqueNumber(int[] nums) {

        set = new LinkedHashSet<>();
        all = new HashSet<>();
        int n = nums.length;

        for(int i=0;i<n;i++) {
            
            if(!all.contains(nums[i])) {
                all.add(nums[i]);
                set.add(nums[i]);

            } else {
                if(set.contains(nums[i])) {
                    set.remove(nums[i]);
                }
            }
        }

    }

    

    public int showFirstUnique() {

        if(set.size() == 0) {
            return -1;
        }
            
        return set.iterator().next();

    }

    

    public void add(int value) {

        if(!all.contains(value)) {
            all.add(value);
            set.add(value);

        } else {

            if(set.contains(value)) {
                set.remove(value);
            }
        }
    }


	public static void main(String[] args) {
		
		int[] nums = {2,3,5};
		
		Day28_FirstUniqueNumber firstUnique = new Day28_FirstUniqueNumber(nums);
		
		System.out.println(firstUnique.showFirstUnique()); // return 2
		firstUnique.add(5);            // the queue is now [2,3,5,5]
		System.out.println(firstUnique.showFirstUnique()); // return 2
		firstUnique.add(2);            // the queue is now [2,3,5,5,2]
		System.out.println(firstUnique.showFirstUnique()); // return 3
		firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
		System.out.println(firstUnique.showFirstUnique()); // return -1
		
	}

}
