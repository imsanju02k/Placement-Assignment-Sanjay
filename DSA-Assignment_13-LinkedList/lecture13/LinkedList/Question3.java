package lecture13.LinkedList;

/*
 *

Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should be considered as a group and must be reversed (See Example 2 for clarification).
Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output:4 2 2 1 8 7 6 5
Explanation:
The first 4 elements 1,2,2,4 are reversed first
and then the next 4 elements 5,6,7,8. Hence, the
resultant linked list is 4->2->2->1->8->7->6->5.

*/
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question3 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupTail = dummy;
        ListNode current = head;
        int count = 0;

        while (current != null) {
            count++;
            if (count % k == 0) {
                prevGroupTail = reverseGroup(prevGroupTail, current.next);
                current = prevGroupTail.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }

    public static ListNode reverseGroup(ListNode prevGroupTail, ListNode nextGroupHead) {
        ListNode prev = prevGroupTail.next;
        ListNode current = prev.next;

        while (current != nextGroupHead) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode groupHead = prevGroupTail.next;
        groupHead.next = nextGroupHead;
        prevGroupTail.next = prev;

        return groupHead;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 3;

        System.out.print("Original list: ");
        printList(head);

        ListNode reversed = reverseKGroup(head, k);

        System.out.print("Reversed list: ");
        printList(reversed);
    }
}
