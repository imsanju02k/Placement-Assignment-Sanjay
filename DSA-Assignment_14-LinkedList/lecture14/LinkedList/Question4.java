package lecture14.LinkedList;

import java.util.HashMap;
import java.util.Map;

/*
You are given a special linked list with **N** nodes where each node has a next pointer pointing to its next node. You are also given **M** random pointers, where you will be given **M** number of pairs denoting two nodes **a** and **b**  **i.e. a->arb = b** (arb is pointer to random node)**.**

Construct a copy of the given list. The copy should consist of exactly **N** new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes **X** and **Y** in the original list, where **X.arb** **-->** **Y**, then for the corresponding two nodes **x** and **y** in the copied list, **x.arb --> y.**

Return the head of the copied linked list.

Input:
N = 4, M = 2
value = {1,2,3,4}
pairs = {{1,2},{2,4}}
Output:1
Explanation:In this test case, there
are 4 nodes in linked list.  Among these
4 nodes,  2 nodes have arbitrary pointer
set, rest two nodes have arbitrary pointer
as NULL. Second line tells us the value
of four nodes. The third line gives the
information about arbitrary pointers.
The first node arbitrary pointer is set to
node 2.  The second node arbitrary pointer
is set to node 4.

>
*/


class Node {
    int data;
    Node next;
    Node random;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

public class Question4 {
    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // HashMap to store the mapping between original and copied nodes
        Map<Node, Node> nodeMap = new HashMap<>();

        // Create a new node for each original node and store the mapping
        Node current = head;
        while (current != null) {
            nodeMap.put(current, new Node(current.data));
            current = current.next;
        }

        // Update the next and random pointers of the copied nodes
        current = head;
        while (current != null) {
            Node copiedNode = nodeMap.get(current);
            copiedNode.next = nodeMap.get(current.next);
            copiedNode.random = nodeMap.get(current.random);
            current = current.next;
        }

        // Return the head of the copied linked list
        return nodeMap.get(head);
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.data + ", " +
                    (current.random != null ? current.random.data : "null") + "] ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head.random = head.next;
        head.next.random = head.next.next.next;

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        Node copiedHead = copyRandomList(head);

        System.out.print("Copied Linked List: ");
        printLinkedList(copiedHead);
    }
}

