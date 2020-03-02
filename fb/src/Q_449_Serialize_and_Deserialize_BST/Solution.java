package Q_449_Serialize_and_Deserialize_BST;


//Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
//Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
//The encoded string should be as compact as possible.
//
//Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

public class Solution {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	 public String serialize(TreeNode root) {
	        return null;
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        return null;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(3);
		
		System.out.println(s.serialize(root));
	}

}
