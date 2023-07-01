class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class DoublyLinkedListNode {
    int val;
    DoublyLinkedListNode prev, next;

    public DoublyLinkedListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class BinaryTreeToDoublyLinkedList {
    private static TreeNode prevNode;

    private static void convertToDLL(TreeNode root, DoublyLinkedListNode prev) {
        if (root == null)
            return;

        convertToDLL(root.left, prev);

        DoublyLinkedListNode curr = new DoublyLinkedListNode(root.val);

        if (prev != null) {
            prev.next = curr;
            curr.prev = prev;
        } else {
            prevNode = curr;
        }

        prevNode = curr;

        convertToDLL(root.right, prevNode);
    }

    public static DoublyLinkedListNode convertBinaryTreeToDLL(TreeNode root) {
        if (root == null)
            return null;

        convertToDLL(root, null);

        return prevNode;
    }

    public static void printDLL(DoublyLinkedListNode head) {
        DoublyLinkedListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);

        // Convert binary tree to doubly linked list
        DoublyLinkedListNode head = convertBinaryTreeToDLL(root);

        // Print the doubly linked list
        printDLL(head);
    }
}
