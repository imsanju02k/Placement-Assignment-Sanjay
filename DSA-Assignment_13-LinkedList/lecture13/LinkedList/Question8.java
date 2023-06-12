package lecture13.LinkedList;

/*

Given a doubly linked list and a position. The task is to delete a node from given position in a doubly linked list.
Input:
LinkedList = 1 <--> 3 <--> 4
x = 3
Output:1 3
Explanation:After deleting the node at
position 3 (position starts from 1),
the linked list will be now as 1->3.


*/

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class Question8 {
    public static Node deleteNode(Node head, int position) {
        if (head == null)
            return null;

        // Case 1: Deleting the head node
        if (position == 1) {
            Node newHead = head.next;
            if (newHead != null)
                newHead.prev = null;
            head.next = null;
            return newHead;
        }

        Node current = head;
        int count = 1;

        // Traverse to the position to be deleted
        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        // Case 2: Deleting a node
        if (current != null) {
            // Update the previous node's next pointer
            if (current.prev != null)
                current.prev.next = current.next;

            // Update the next node's previous pointer
            if (current.next != null)
                current.next.prev = current.prev;

            // Disconnect the current node
            current.prev = null;
            current.next = null;
        }

        return head;
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
        // Create the doubly linked list
        Node head = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(4);

        head.next = node1;
        node1.prev = head;
        node1.next = node2;
        node2.prev = node1;

        System.out.println("Original Doubly Linked List:");
        printList(head);

        int positionToDelete = 3;
        head = deleteNode(head, positionToDelete);

        System.out.println("Doubly Linked List after deleting node at position " + positionToDelete + ":");
        printList(head);
    }
}
