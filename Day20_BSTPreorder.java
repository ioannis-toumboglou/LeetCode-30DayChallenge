/* Return the root node of a binary search tree that matches the given preorder traversal.
   
   (Recall that a binary search tree is a binary tree where for every node, any descendant of 
   node.left has a value < node.val, and any descendant of node.right has a value > node.val.
   Also recall that a preorder traversal displays the value of the node first, then traverses 
   node.left, then traverses node.right.)
   
   Example 1:
   
   Input: [8,5,1,7,10,12]
   Output: [8,5,10,1,7,null,12]
   
   Note: 
   
   1. 1 <= preorder.length <= 100
   2. The values of preorder are distinct.
*/

package LeetCode;

public class Day20_BSTPreorder {
	
	private int i = 0;
	
	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			value = x;
		}
	}
	
	public TreeNode bstFromPreorder(int[] preorder) {
		
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		
		return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public TreeNode dfs(int[] preorder, int min, int max) {
		
		if (i >= preorder.length) {
			return null;
		}
		
		if (preorder[i] < min || preorder[i] > max) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[i]);
		
		i++;
		root.left = dfs(preorder, min, root.value);
		root.right = dfs(preorder, root.value, max);
		
		return root;
		
	}

}