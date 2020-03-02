package Q_230_Kth_Smallest_Element_in_a_BST;

import java.util.ArrayList;
import java.util.List;

//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//
//Note:
//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//
//Example 1:
//
//Input: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//Output: 1
//Example 2:
//
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//Output: 3
//Follow up:
//What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?



public class Solution {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static TreeNode root = new TreeNode(5);
	List<Integer> result = new ArrayList<>();

	 public int kthSmallest(TreeNode root, int k) {
		 helper(root);
	     return result.get(k-1);   
	    }
	 
	 public void helper(TreeNode node) {
		 if(node == null) {
			 return;
		 }
		 
		 helper(node.left);
		 result.add(node.val);
		 helper(node.right);
		 
	 }
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
//		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
//		root.right.right = new TreeNode(3);
		
		System.out.println(s.kthSmallest(root, 6));

	}

}
