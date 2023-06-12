package lecture14.LinkedList;

/*
A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.
Input:
LinkedList: 4->5->6
Output:457

*/

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Question2 {
    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static Node addOne(Node head) {
        if (head == null)
            return null;

        Node reversedHead = reverseLinkedList(head);
        Node current = reversedHead;
        Node prev = null;
        boolean carry = true;

        while (current != null && carry) {
            int sum = current.data + 1;
            carry = sum > 9;
            current.data = sum % 10;
            prev = current;
            current = current.next;
        }

        if (carry) {
            prev.next = new Node(1);
        }

        return reverseLinkedList(reversedHead);
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1: LinkedList: 4->5->6
        Node head1 = new Node(4);
        head1.next = new Node(5);
        head1.next.next = new Node(6);

        System.out.print("Input: ");
        printLinkedList(head1);

        Node result1 = addOne(head1);

        System.out.print("Output: ");
        printLinkedList(result1);

        // Example 2: LinkedList: 1->2->3
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        System.out.print("Input: ");
        printLinkedList(head2);

        Node result2 = addOne(head2);

        System.out.print("Output: ");
        printLinkedList(result2);
    }
}
