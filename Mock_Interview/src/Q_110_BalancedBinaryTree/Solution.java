package Q_110_BalancedBinaryTree;

//110. Balanced Binary Tree
//
//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as:
//
//a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
//
// 
//
//Example 1:
//
//Given the following tree [3,9,20,null,null,15,7]:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//Return true.
//
//Example 2:
//
//Given the following tree [1,2,2,3,3,null,null,4,4]:
//
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//Return false.

/**
 * Definition for a binary tree node.
 * 
 */
class Solution {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static boolean isBalanced(TreeNode root) {
		if(root == null)
		{
			return true;
		}
		
		return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(helper(root.left) - helper(root.right) )<=1);
	}

	private static int helper(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}else
		{
			return Math.max(helper(root.left), helper(root.right)) +1; 
		}
		
	}

	
public static void main(String[] args) {
	// TODO Auto-generated method stub
	TreeNode root = new TreeNode(3);
	root.left = new TreeNode(9);
	root.right = new TreeNode(20);
	root.right.left = new TreeNode(15);
	root.right.right = new TreeNode(7);
//	root.right.right.right = new TreeNode(10);
	
	System.out.println(isBalanced(root));
//	System.out.println(helper(root));
			


}
}
