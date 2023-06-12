package lecture13.LinkedList;

/*

Given a linked list and a key to be deleted. Delete last occurrence of key from linked. The list may have duplicates.
Input:   1->2->3->5->2->10, key = 2
Output:  1->2->3->5->10

*/

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}

public class Question5 {
    public static ListNode deleteLastOccurrence(ListNode head, int key) {
        if (head == null)
            return null;

        ListNode prev = null;
        ListNode lastOccurrence = null;
        ListNode current = head;
        ListNode nextNode = null;

        // Find the last occurrence of the key
        while (current != null) {
            if (current.val == key)
                lastOccurrence = prev;
            prev = current;
            current = current.next;
        }

        // If last occurrence is found, delete the node
        if (lastOccurrence != null) {
            nextNode = lastOccurrence.next;
            lastOccurrence.next = nextNode.next;
        } else {
            // If last occurrence is the head node, update the head
            nextNode = head;
            head = head.next;
        }

        // Clean up memory
        nextNode.next = null;

        return head;
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
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(10);

        int key = 2;

        System.out.println("Original list:");
        printList(head);

        head = deleteLastOccurrence(head, key);

        System.out.println("Modified list:");
        printList(head);
    }
}
