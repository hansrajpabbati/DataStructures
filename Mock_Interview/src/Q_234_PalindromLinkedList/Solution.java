package Q_234_PalindromLinkedList;

//234. Palindrome Linked List
//Given a singly linked list, determine if it is a palindrome.
//
//Example 1:
//
//Input: 1->2
//Output: false
//Example 2:
//
//Input: 1->2->2->1
//Output: true
//Follow up:
//Could you do it in O(n) time and O(1) space?

/**
 * Definition for singly-linked list.*/
  
class Solution {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
    public static boolean isPalindrome(ListNode head) {
    	
    	if(head == null) 
    	{
    		return true;
    	}
    	
    	ListNode slow = head;
    	ListNode fast = head.next;
    	
    	while(fast != null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}    	
    	
    	ListNode head2 = slow.next;
    	slow.next = null;
    	
    	
    	ListNode prev = null;
    	ListNode cur = head2;
    	ListNode next = null;
    	
    	while(cur != null)
    	{
    		next = cur.next;
    		cur.next  = prev;
    		prev = cur;
    		cur = next;
    	}
    	
    	head2 = prev;
    	
    	
    	while(head != null && head2 != null) {
    		if(head.val != head2.val)
    		{
    			return false;
    		}else
    		{
    			head= head.next;
    			head2 = head2.next;
    		}
    	}
    	
		return true;
        
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ListNode link = new ListNode(1);
    	link.next = new ListNode(2);
    	link.next.next = new ListNode(2);
    	link.next.next.next = new ListNode(1);
    	
    	System.out.println(isPalindrome(link));

	}
}
