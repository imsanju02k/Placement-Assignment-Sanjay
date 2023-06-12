package lecture14.LinkedList;

/*

Given a singly linked list of size N. The task is to left-shift the linked list by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.
Input:
N = 5
value[] = {2, 4, 7, 8, 9}
k = 3
Output:8 9 2 4 7
Explanation:Rotate 1:4 -> 7 -> 8 -> 9 -> 2
Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
Rotate 3: 8 -> 9 -> 2 -> 4 -> 7

*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question6 {
    public static ListNode leftShiftLinkedList(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int length = getLength(head);
        int shift = k % length;

        if (shift == 0) {
            return head;
        }

        ListNode newHead = null;
        ListNode newTail = null;

        ListNode current = head;
        int count = 0;
        while (current != null) {
            if (count == length - shift - 1) {
                newTail = current;
            }
            if (count == length - shift) {
                newHead = current;
            }
            current = current.next;
            count++;
        }

        newTail.next = null;
        current = newHead;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;

        return newHead;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(9);

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        int k = 3;
        ListNode shiftedList = leftShiftLinkedList(head, k);

        System.out.print("Left-shifted Linked List: ");
        printLinkedList(shiftedList);
    }
}
