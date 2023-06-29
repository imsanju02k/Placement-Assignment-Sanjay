1)
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

    int maxSumSubtree(Node node, Sum maxSum) {
        if (node == null)
            return 0;

        int currentSum = node.data + maxSumSubtree(node.left, maxSum) + maxSumSubtree(node.right, maxSum);

        if (currentSum > maxSum.max)
            maxSum.max = currentSum;

        return currentSum;
    }

    int findMaxSumSubtree(Node node) {
        if (node == null)
            return 0;

        Sum maxSum = new Sum();
        maxSum.max = Integer.MIN_VALUE;

        maxSumSubtree(node, maxSum);

        return maxSum.max;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        int maxSum = tree.findMaxSumSubtree(tree.root);
        System.out.println("Maximum sum of a subtree in the binary tree: " + maxSum);
    }
}

class Sum {
    int max;
}
