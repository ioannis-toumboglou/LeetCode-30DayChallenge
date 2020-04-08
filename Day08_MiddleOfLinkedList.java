/* Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */

package LeetCode;

public class Day08_MiddleOfLinkedList {
	
	class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int value) {
			val = value;
		}
	}
	
	public static ListNode middleNode(ListNode head) {
		
		ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
        
	}

}
