package lecture12.LinkedList;

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

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Question5 {
    public static void removeLoop(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode loopNode = null;

        // Detect the loop using Floyd's cycle detection algorithm
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                loopNode = slowPtr;
                break;
            }
        }

        // If a loop is found, remove it
        if (loopNode != null) {
            slowPtr = head;

            // If the loop starts at the head of the linked list
            if (slowPtr == loopNode) {
                while (fastPtr.next != slowPtr) {
                    fastPtr = fastPtr.next;
                }
            } else {
                while (slowPtr.next != fastPtr.next) {
                    slowPtr = slowPtr.next;
                    fastPtr = fastPtr.next;
                }
            }

            // Remove the loop by setting the next pointer of the last node to null
            fastPtr.next = null;
        }
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
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = head.next; // Creating a loop at position X = 2

        System.out.println("Original linked list:");
        printLinkedList(head);

        removeLoop(head);

        System.out.println("Modified linked list:");
        printLinkedList(head);
    }
}
