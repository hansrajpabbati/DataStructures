package Q_938_Range_Sum_of_BST;


//Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
//
//The binary search tree is guaranteed to have unique values.
//
// 
//
//Example 1:
//
//Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
//Output: 32
//Example 2:
//
//Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//Output: 23
 
public class Solution {
	public  int currSum =0;
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	 public int rangeSumBST(TreeNode node, int L, int R) {
		 return helper(node, L, R);
	    }
	
	public int helper(TreeNode node, int L, int R) {
		if(node == null) {
			return 0;
		}
		
		
		if(node.val <=R && node.val >=L) {
			currSum = currSum + node.val;
		}
		
		helper(node.left, L, R);
		helper(node.right, L, R);
		return currSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
//		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(18);
		
		System.out.println(s.rangeSumBST(root,7,15));

	}

}
