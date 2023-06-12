package lecture14.LinkedList;

/*

Given a linked list of **N** nodes such that it may contain a loop.

A loop here means that the last node of the link list is connected to the node at position X(1-based index). If the link list does not have any loop, X=0.

Remove the loop from the linked list, if it is present, i.e. unlink the last node which is forming the loop.

Input:
N = 3
value[] = {1,3,4}
X = 2
Output:1
Explanation:The link list looks like
1 -> 3 -> 4
     ^    |
     |____|
A loop is present. If you remove it
successfully, the answer will be 1.

*/

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Question01 {
    public static Node detectAndRemoveLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Detect the loop using Floyd's cycle-finding algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        // If no loop exists, return the head as is
        if (fast == null || fast.next == null)
            return head;

        // Reset one of the pointers to the head and move both pointers until they meet again
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the loop by making the next pointer of the node just before the start of the loop null
        fast.next = null;

        return head;
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = head.next;

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        head = detectAndRemoveLoop(head);

        System.out.print("Linked List after removing the loop: ");
        printLinkedList(head);
    }
}
