//package Q_938_Range_Sum_of_BST;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//
///* -----------------------------------
// *  WARNING:
// * -----------------------------------
// *  Your code may fail to compile
// *  because it contains public class
// *  declarations.
// *  To fix this, please remove the
// *  "public" keyword from your class
// *  declarations.
// */
//
//// * Definition for a binary tree node.
//
//
//
//
//public class MainClass {
//
//	public int rangeSumBST(TreeNode root, int L, int R) {
//		
//		return 0; 
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	public static class TreeNode {
//		int val;
//		TreeNode left;
//		TreeNode right;
//		TreeNode(int x) { val = x; }
//	}
//
//	public static TreeNode stringToTreeNode(String input) {
//		input = input.trim();
//		input = input.substring(1, input.length() - 1);
//		if (input.length() == 0) {
//			return null;
//		}
//
//		String[] parts = input.split(",");
//		String item = parts[0];
//		TreeNode root = new TreeNode(Integer.parseInt(item));
//		Queue<TreeNode> nodeQueue = new LinkedList<>();
//		nodeQueue.add(root);
//
//		int index = 1;
//		while(!nodeQueue.isEmpty()) {
//			TreeNode node = nodeQueue.remove();
//
//			if (index == parts.length) {
//				break;
//			}
//
//			item = parts[index++];
//			item = item.trim();
//			if (!item.equals("null")) {
//				int leftNumber = Integer.parseInt(item);
//				node.left = new TreeNode(leftNumber);
//				nodeQueue.add(node.left);
//			}
//
//			if (index == parts.length) {
//				break;
//			}
//
//			item = parts[index++];
//			item = item.trim();
//			if (!item.equals("null")) {
//				int rightNumber = Integer.parseInt(item);
//				node.right = new TreeNode(rightNumber);
//				nodeQueue.add(node.right);
//			}
//		}
//		return root;
//	}
////	root = [10,5,15,3,7,null,18], L = 7, R = 15
////	10,5,15,3,7,null,18
////	7
////	15
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		MainClass m = new MainClass();
//		String line;
//		while ((line = in.readLine()) != null) {
//			TreeNode root = stringToTreeNode(line);
//			line = in.readLine();
//			int L = Integer.parseInt(line);
//			line = in.readLine();
//			int R = Integer.parseInt(line);
//
//			int ret = m.rangeSumBST(root, L, R);
//
//			String out = String.valueOf(ret);
//
//			System.out.print(out);
//		}
//	}
//}