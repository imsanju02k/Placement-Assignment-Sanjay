package lecture12.LinkedList;

/*
Given two linked lists, insert nodes of second list into first list at alternate positions of first list.
For example, if first list is 5->7->17->13->11 and second is 12->10->2->4->6, the first list should become 5->12->7->10->17->2->13->4->11->6 and second list should become empty. The nodes of second list should only be inserted when there are positions available. For example, if the first list is 1->2->3 and second list is 4->5->6->7->8, then first list should become 1->4->2->5->3->6 and second list to 7->8.

Use of extra space is not allowed (Not allowed to create additional nodes), i.e., insertion must be done in-place. Expected time complexity is O(n) where n is number of nodes in first list.
*/


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Question7 {
    public static void mergeLists(Node first, Node second) {
        if (first == null || second == null) {
            return;
        }

        Node firstCurrent = first;
        Node secondCurrent = second;

        while (firstCurrent != null && secondCurrent != null) {
            Node firstNext = firstCurrent.next;
            Node secondNext = secondCurrent.next;

            firstCurrent.next = secondCurrent;
            secondCurrent.next = firstNext;

            firstCurrent = firstNext;
            secondCurrent = secondNext;
        }

        second = secondCurrent;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node first = new Node(5);
        first.next = new Node(7);
        first.next.next = new Node(17);
        first.next.next.next = new Node(13);
        first.next.next.next.next = new Node(11);

        Node second = new Node(12);
        second.next = new Node(10);
        second.next.next = new Node(2);
        second.next.next.next = new Node(4);
        second.next.next.next.next = new Node(6);

        System.out.println("Before merging:");
        System.out.print("First list: ");
        printList(first);
        System.out.print("Second list: ");
        printList(second);

        mergeLists(first, second);

        System.out.println("After merging:");
        System.out.print("First list: ");
        printList(first);
        System.out.print("Second list: ");
        printList(second);
    }
}
