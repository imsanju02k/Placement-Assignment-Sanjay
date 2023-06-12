package lecture13.LinkedList;

/*

Given two linked list of the same size, the task is to create a new linked list using those linked lists. The condition is that the greater node among both linked list will be added to the new linked list.
Input: list1 = 5->2->3->8
list2 = 1->7->4->5
Output: New list = 5->7->4->8

Input:list1 = 2->8->9->3
list2 = 5->3->6->4
Output: New list = 5->8->9->4
*/

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question01 {
    public static ListNode createNewList(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;

        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;

            int greaterVal = Math.max(val1, val2);
            ListNode newNode = new ListNode(greaterVal);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }

            list1 = list1.next;
            list2 = list2.next;
        }

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
        // Example 1
        ListNode list1 = new ListNode(5);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(8);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(7);
        list2.next.next = new ListNode(4);
        list2.next.next.next = new ListNode(5);

        ListNode newList = createNewList(list1, list2);
        System.out.print("New list: ");
        printList(newList);

        // Example 2
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(8);
        list3.next.next = new ListNode(9);
        list3.next.next.next = new ListNode(3);

        ListNode list4 = new ListNode(5);
        list4.next = new ListNode(3);
        list4.next.next = new ListNode(6);
        list4.next.next.next = new ListNode(4);

        ListNode newList2 = createNewList(list3, list4);
        System.out.print("New list: ");
        printList(newList2);
    }
}
