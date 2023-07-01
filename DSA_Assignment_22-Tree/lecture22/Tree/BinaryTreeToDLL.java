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

public class BinaryTreeToDLL {
    private static TreeNode prevNode;

    private static void convertToDLL(TreeNode root) {
        if (root == null)
            return;

        convertToDLL(root.left);

        DoublyLinkedListNode curr = new DoublyLinkedListNode(root.val);

        if (prevNode != null) {
            prevNode.next = curr;
            curr.prev = prevNode;
        } else {
            prevNode = curr;
        }

        prevNode = curr;

        convertToDLL(root.right);
    }

    public static DoublyLinkedListNode convertBinaryTreeToDLL(TreeNode root) {
        if (root == null)
            return null;

        prevNode = null;

        convertToDLL(root);

        DoublyLinkedListNode head = prevNode;

        while (head != null && head.prev != null) {
            head = head.prev;
        }

        return head;
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
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);

        // Convert binary tree to DLL
        DoublyLinkedListNode head = convertBinaryTreeToDLL(root);

        // Print the doubly linked list
        printDLL(head);
    }
}
