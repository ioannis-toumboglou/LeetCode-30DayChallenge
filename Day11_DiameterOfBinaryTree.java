package LeetCode;

public class Day11_DiameterOfBinaryTree {
	
	class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int x) {
			val = x;
		}
	}
	
	static TreeNode root;
	static int result;
	
	public static int height(TreeNode node) {		
		
		if (node == null) {
			return 0;
		}
		
		int lheight = height(node.left);
		int rheight = height(node.right);
		
		result = Math.max(result, lheight + rheight + 1);
		
		return Math.max(lheight, rheight) + 1;
		
	}
	
	public static int diameterOfBinaryTree(TreeNode tree) {
		
		result = 1;
		height(root);
		
		return result - 1;
	}

}
