package lecture13.LinkedList;

/*

Given two sorted linked lists consisting of **N** and **M** nodes respectively. The task is to merge both of the lists (in place) and return the head of the merged list.

**Examples:**

Input: a: 5->10->15, b: 2->3->20

Output: 2->3->5->10->15->20

Input: a: 1->1, b: 2->4

Output: 1->1->2->4

*/

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Question6 {
    public static ListNode mergeSortedLists(ListNode a, ListNode b) {
        // Create a dummy node as the head of the merged list
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;

        // Traverse both lists and compare the nodes
        while (a != null && b != null) {
            if (a.val <= b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes of the non-empty list
        if (a != null) {
            current.next = a;
        } else if (b != null) {
            current.next = b;
        }

        // Return the head of the merged list
        return dummyNode.next;
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
        ListNode a = new ListNode(5);
        a.next = new ListNode(10);
        a.next.next = new ListNode(15);

        ListNode b = new ListNode(2);
        b.next = new ListNode(3);
        b.next.next = new ListNode(20);

        System.out.println("List a:");
        printList(a);

        System.out.println("List b:");
        printList(b);

        ListNode merged = mergeSortedLists(a, b);

        System.out.println("Merged list:");
        printList(merged);
    }
}
