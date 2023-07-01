import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeToBST {
    private static void storeNodeValues(TreeNode root, List<Integer> values) {
        if (root == null)
            return;

        storeNodeValues(root.left, values);
        values.add(root.val);
        storeNodeValues(root.right, values);
    }

    private static void convertToBST(TreeNode root, Iterator<Integer> iterator) {
        if (root == null)
            return;

        convertToBST(root.left, iterator);
        root.val = iterator.next();
        convertToBST(root.right, iterator);
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);

        // Step 1: Store node values
        List<Integer> values = new ArrayList<>();
        storeNodeValues(root, values);

        // Step 2: Sort the values
        Collections.sort(values);

        // Step 3: Convert the binary tree to a binary search tree
        Iterator<Integer> iterator = values.iterator();
        convertToBST(root, iterator);

        // Print the converted binary search tree
        printInorder(root);
    }

    private static void printInorder(TreeNode root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
