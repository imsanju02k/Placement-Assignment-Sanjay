package lecture12.LinkedList;

/*

Given a singly linked list, find if the linked list is circular or not.
A linked list is called circular if it is not NULL-terminated and all nodes are connected in the form of a cycle. Below is an example of a circular linked list.
*/

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question8 {
    public static boolean isCircular(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head.next;

        while (fastPtr != null && fastPtr.next != null) {
            if (slowPtr == fastPtr || slowPtr == fastPtr.next) {
                return true; // Linked list is circular
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return false; // Linked list is not circular
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head; // Make the list circular

        boolean isCircular = isCircular(head);
        System.out.println("Is the linked list circular? " + (isCircular ? "Yes" : "No"));
    }
}


