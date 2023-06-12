package lecture14.LinkedList;

/*

Given the `head` of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return *the reordered list*.

The **first** node is considered **odd**, and the **second** node is **even**, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in `O(1)` extra space complexity and `O(n)` time complexity.

Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question5 {
    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode evenNode = evenHead;

        while (evenNode != null && evenNode.next != null) {
            oddHead.next = evenNode.next;
            oddHead = oddHead.next;
            evenNode.next = oddHead.next;
            evenNode = evenNode.next;
        }

        oddHead.next = evenHead;
        return head;
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        ListNode reorderedList = reorderList(head);

        System.out.print("Reordered Linked List: ");
        printLinkedList(reorderedList);
    }
}
