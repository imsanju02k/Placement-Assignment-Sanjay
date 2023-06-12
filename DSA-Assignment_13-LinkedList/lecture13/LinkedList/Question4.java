package lecture13.LinkedList;


/*
Given a linked list, write a function to reverse every alternate k nodes (where k is an input to the function) in an efficient way. Give the complexity of your algorithm.
Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
Output:   3->2->1->4->5->6->9->8->7->NULL.
>
*/



class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}

public class Question4 {
    public static ListNode reverseAlternateKNodes(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        // Reverse k nodes
        int count = 0;
        while (current != null && count < k) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
            count++;
        }

        // Skip the next k nodes
        count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        // Recursively reverse the remaining alternate k nodes
        if (current != null) {
            head.next = reverseAlternateKNodes(current, k);
        }

        return previous;
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

        int k = 2;

        System.out.println("Original list:");
        printList(head);

        head = reverseAlternateKNodes(head, k);

        System.out.println("Reversed list:");
        printList(head);
    }
}
