package lecture12.LinkedList;

/*

Given a singly linked list, delete middle of the linked list. For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5.If there are even nodes, then there would be two middle nodes, we need to delete the second middle element. For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.If the input linked list is NULL or has 1 node, then it should return NULL

Input:
LinkedList: 1->2->3->4->5
Output:1 2 4 5

*/

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}

public class Question01 {

	

	
	    public static ListNode deleteMiddleNode(ListNode head) {
	        if (head == null || head.next == null) {
	            return null;
	        }
	        
	        ListNode slowPtr = head;
	        ListNode fastPtr = head;
	        ListNode prevPtr = null;
	        
	        while (fastPtr != null && fastPtr.next != null) {
	            fastPtr = fastPtr.next.next;
	            prevPtr = slowPtr;
	            slowPtr = slowPtr.next;
	        }
	        
	        prevPtr.next = slowPtr.next;
	        slowPtr.next = null;
	        
	        return head;
	    }
	    
	    public static void printLinkedList(ListNode head) {
	        ListNode curr = head;
	        while (curr != null) {
	            System.out.print(curr.val + " ");
	            curr = curr.next;
	        }
	        System.out.println();
	    }
	    
	    public static void main(String[] args) {
	        ListNode head = new ListNode(1);
	        head.next = new ListNode(2);
	        head.next.next = new ListNode(3);
	        head.next.next.next = new ListNode(4);
	        head.next.next.next.next = new ListNode(5);
	        
	        System.out.println("Original linked list:");
	        printLinkedList(head);
	        
	        head = deleteMiddleNode(head);
	        
	        System.out.println("Modified linked list:");
	        printLinkedList(head);
	    }
	}



