class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    void insertLevelOrder(int[] arr) {
        root = insertLevelOrder(arr, root, 0);
    }

    Node insertLevelOrder(int[] arr, Node root, int index) {
        if (index < arr.length) {
            Node newNode = new Node(arr[index]);
            root = newNode;

            root.left = insertLevelOrder(arr, root.left, 2 * index + 1);
            root.right = insertLevelOrder(arr, root.right, 2 * index + 2);
        }
        return root;
    }

    void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};

        tree.insertLevelOrder(arr);

        System.out.println("BST:");
        tree.inOrderTraversal(tree.root);
    }
}
