class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class FlipBinaryTree {
    public static TreeNode flipBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;

        TreeNode flippedRoot = flipBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;

        return flippedRoot;
    }

    public static void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Flip the binary tree
        TreeNode flippedRoot = flipBinaryTree(root);

        // Print the inorder traversal of the flipped tree
        printInorder(flippedRoot);
    }
}
