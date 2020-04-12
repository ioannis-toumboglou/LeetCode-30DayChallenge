/*  We have a collection of stones, each stone has a positive integer weight.
 *
 *	Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y 
 *	with x <= y.  The result of this smash is:
 *
 *   If x == y, both stones are totally destroyed;
 *   If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 *
 *	At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 */

package LeetCode;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Day12_LastStoneWeight {
	
	public static int lastStoneWeight(int[] stones) {
		
		int weight = 0;
		List<Integer> stoneList = new ArrayList<>();
		
		for (int item : stones) {
			stoneList.add(item);
		}
		
		while (true) {
			Collections.sort(stoneList);
			System.out.println(stoneList);
			
			for (int i=stoneList.size()-1; i>0; i--) {
				int first = stoneList.get(i);
				int second = stoneList.get(i-1);
				
				if (first == second) {
					stoneList.remove(i);
					stoneList.remove(i-1);
					break;
				} else if (first > second) {
					weight = first - second;
					stoneList.set(i-1, weight);
					stoneList.remove(i);
				} else {
					weight = second - first;
					stoneList.set(i-1, weight);
					stoneList.remove(i);
				}
				
				if (weight != 0) {
					stoneList.add(weight);
				}
			}
			
			if (stoneList.size() == 0) {
				weight = 0;
				break;
			}
			
			if (stoneList.size() == 1) {
				weight = stoneList.get(0);
				break;
			}
			
			System.out.println(weight);
		}
		
		return weight;
		
	}

	public static void main(String[] args) {

		int[] stones = {10,6,3,5,10,2};
		
		System.out.println(lastStoneWeight(stones));

	}

}
