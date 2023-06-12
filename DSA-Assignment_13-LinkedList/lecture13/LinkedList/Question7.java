package lecture13.LinkedList;

/*
 * 
Given a Doubly Linked List, the task is to reverse the given Doubly Linked List.
Original Linked list 10 8 4 2
Reversed Linked list 2 4 8 10
*/


class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class Question7 {
    public static Node reverseDoublyLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node previous = null;

        while (current != null) {
            // Swap previous and next pointers
            Node temp = current.next;
            current.next = previous;
            current.prev = temp;

            // Move to the next nodes
            previous = current;
            current = temp;
        }

        // Update the head to the last node
        head = previous;

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
        // Create the original doubly linked list
        Node head = new Node(10);
        Node node1 = new Node(8);
        Node node2 = new Node(4);
        Node node3 = new Node(2);

        head.next = node1;
        node1.prev = head;
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;

        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the doubly linked list
        head = reverseDoublyLinkedList(head);

        System.out.println("Reversed Linked List:");
        printList(head);
    }
}
