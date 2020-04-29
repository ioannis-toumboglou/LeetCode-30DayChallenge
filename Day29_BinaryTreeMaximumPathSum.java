/*  Given a non-empty binary tree, find the maximum path sum.

	For this problem, a path is defined as any sequence of nodes from some starting node to any 
	node in the tree along the parent-child connections. The path must contain at least one node 
	and does not need to go through the root.
	
	Example 1:
	
	Input: [1,2,3]
	
	       1
	      / \
	     2   3
	
	Output: 6
	
	Example 2:
	
	Input: [-10,9,20,null,null,15,7]
	
	   -10
	   / \
	  9  20
	    /  \
	   15   7
	
	Output: 42

 */

package LeetCode;

public class Day29_BinaryTreeMaximumPathSum {
	
	int result = Integer.MIN_VALUE;
	
	class TreeNode {
		
		int val;
	    TreeNode left;
	    TreeNode right;
	
	    TreeNode() {}
	    
	    TreeNode(int val) { 
	    	this.val = val; 
	    }
		
	    TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
	}
	
	public int findMax(TreeNode root) {
        
		if (root == null) return 0;
        
        int left = Math.max(findMax(root.left), 0);
        int right = Math.max(findMax(root.right), 0);
        
        result = Math.max(result, root.val + left + right);
        
        return root.val + Math.max(left, right);
		
    }
	
	public int maxPathSum(TreeNode root) {
		
        findMax(root);
        return result;
    }

}