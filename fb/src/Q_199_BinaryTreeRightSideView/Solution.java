package Q_199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	List<Integer> ans;
	
	 public List<Integer> rightSideView(TreeNode root) {
		 ans = new ArrayList<>();
		 int level =0;
		 helper(root,level);
	     return ans;   
	    }
	 
	 public void helper(TreeNode node,int level) {
		 if(node == null) {
			 return;
		 }
		 if(ans.size() < level+1) {
			 ans.add(node.val);
		 }
			 helper(node.right,level+1);
			 helper(node.left,level+1);
		 
		 
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(6);
//		root.right.left.right = new TreeNode(7);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(6);
//		root.right.left.right = new TreeNode(7);
		
		System.out.println(s.rightSideView(root));

	}

}
