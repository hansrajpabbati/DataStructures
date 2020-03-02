package Q_2_Add_Two_Numbers;

import Q_2_Add_Two_Numbers.Solution.ListNode;

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

//Example:
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.

public class Solution {

	
	public static  class ListNode {
		      int val;
		      ListNode next;
		      public ListNode() {
			}
		      ListNode(int x) { val = x; }
		  }
//	 public static ListNode root = new ListNode(2);
//	 public static ListNode root1 = new ListNode(5);

	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode dummy = new ListNode();
		ListNode dummyHead = dummy;
		 ListNode h1 = l1;
		 ListNode h2 = l2;
		 int x=0;
		 int y=0;
		 int carry =0;
		 
		 
		 while(h1 !=null || h2!=null) {
			 
			 if(h1 == null) {
				 x=0;
			 }else {
				 x = h1.val;
			 }
			 if(h2 == null) {
				 y=0;
			 }else {
				 y = h2.val;
			 }
			 
			 int sum = carry + x +y;
			 carry = sum /10;
			 
			 dummy.next = new ListNode(sum %10);
			 dummy = dummy.next;
			 if(h1 !=null) {
				 h1 = h1.next;
			 }
			 
			 if(h2 != null) {
				 h2 = h2.next;
			 }
			 
			 
		 }
		 
		 if(carry >0) {
			 dummy.next = new ListNode(carry);
		 }
		 
		 
	     return dummyHead.next;   
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
//		ListNode root = new ListNode(2);
		ListNode root = new ListNode(5);
//		root.next = new ListNode(4);
//		root.next.next = new ListNode(3);
		
		ListNode root1 = new ListNode(5);
		
//		root1.next= new ListNode(6);
//		root1.next.next = new ListNode(4);
		
		ListNode ans = s.addTwoNumbers(root	, root1);
		
		while(ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}

	}

}
