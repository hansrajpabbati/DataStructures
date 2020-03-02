package Q_141_Linked_List_Cycle;


public class Solution {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	static ListNode root = new ListNode(0);
	public boolean hasCycle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;
		boolean isCycle = false;

		if(head == null){
			return isCycle;
		}

		while(fast != null && fast.next != null){
			slow= slow.next;
			fast= fast.next.next;

			if(slow == fast){
				isCycle = true;
				break;
			}
		}

		return isCycle;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root.next = new ListNode(1);
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(3);
		root.next.next.next.next = new ListNode(4);
		root.next.next.next.next.next = root.next.next;


		Solution s = new Solution();
		System.out.println(s.hasCycle(root));
	}

}
