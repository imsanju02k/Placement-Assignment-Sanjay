package lecture12.LinkedList;

/*
 *

Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.
>Input:
N = 2
LinkedList: 1->2->3->4->5->6->7->8->9
Output:8
Explanation:In the first example, there
are 9 nodes in linked list and we need
to find 2nd node from end. 2nd node
from end is 8.
*/
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Question3 {
    public static int findNthFromEnd(ListNode head, int N) {
        if (head == null || N <= 0) {
            return -1;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // Move the fast pointer N positions ahead
        for (int i = 0; i < N; i++) {
            if (fastPtr == null) {
                return -1; // N is greater than the length of the linked list
            }
            fastPtr = fastPtr.next;
        }

        // Move both pointers until the fast pointer reaches the end
        while (fastPtr != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        // At this point, the slow pointer is at the Nth node from the end
        return slowPtr.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        int N = 2;
        int result = findNthFromEnd(head, N);
        System.out.println("Nth node from the end: " + result);
    }
}



