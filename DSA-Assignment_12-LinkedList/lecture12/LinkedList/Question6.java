package lecture12.LinkedList;

/*

Given a linked list and two integers M and N. Traverse the linked list such that you retain M nodes then delete next N nodes, continue the same till end of the linked list.

Difficulty Level: Rookie
Input:
M = 2, N = 2
Linked List: 1->2->3->4->5->6->7->8
Output:
Linked List: 1->2->5->6

Input:
M = 3, N = 2
Linked List: 1->2->3->4->5->6->7->8->9->10
Output:
Linked List: 1->2->3->6->7->8

Input:
M = 1, N = 1
Linked List: 1->2->3->4->5->6->7->8->9->10
Output:
Linked List: 1->3->5->7->9

*/

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Question6 {
    public static ListNode retainAndDelete(ListNode head, int M, int N) {
        if (head == null || M <= 0 || N <= 0) {
            return head;
        }

        ListNode curr = head;
        int count;

        while (curr != null) {
            // Retain M nodes
            for (count = 1; count < M && curr != null; count++) {
                curr = curr.next;
            }

            if (curr == null) {
                break;
            }

            // Delete N nodes
            ListNode next = curr.next;
            for (count = 1; count <= N && next != null; count++) {
                next = next.next;
            }

            curr.next = next; // Connect the last retained node to the next node after deleted nodes
            curr = next; // Move to the next retained node
        }

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
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println("Original linked list:");
        printLinkedList(head1);

        int M1 = 2;
        int N1 = 2;
        ListNode modifiedHead1 = retainAndDelete(head1, M1, N1);

        System.out.println("Modified linked list:");
        printLinkedList(modifiedHead1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next.next = new ListNode(7);
        head2.next.next.next.next.next.next.next = new ListNode(8);
        head2.next.next.next.next.next.next.next.next = new ListNode(9);
        head2.next.next.next.next.next.next.next.next.next = new ListNode(10);

        System.out.println("Original linked list:");
        printLinkedList(head2);

        int M2 = 3;
        int N2 = 2;
        ListNode modifiedHead2 = retainAndDelete(head2, M2, N2);

        System.out.println("Modified linked list:");
        printLinkedList(modifiedHead2);

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(4);
        head3.next.next.next.next = new ListNode(5);
        head3.next.next.next.next.next = new ListNode(6);
        head3.next.next.next.next.next.next = new ListNode(7);
        head3.next.next.next.next.next.next.next = new ListNode(8);
        head3.next.next.next.next.next.next.next.next = new ListNode(9);
        head3.next.next.next.next.next.next.next.next.next = new ListNode(10);

        System.out.println("Original linked list:");
        printLinkedList(head3);

        int M3 = 1;
        int N3 = 1;
        ListNode modifiedHead3 = retainAndDelete(head3, M3, N3);

        System.out.println("Modified linked list:");
        printLinkedList(modifiedHead3);
    }
}

        		


