import java.util.*;

class TreeNode {
    int val;
    int hd; // horizontal distance
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.hd = Integer.MAX_VALUE;
        this.left = null;
        this.right = null;
    }
}

public class BottomViewBinaryTree {
    public static void printBottomView(TreeNode root) {
        if (root == null)
            return;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        root.hd = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int hd = current.hd;

            // Update the value for the current horizontal distance
            map.put(hd, current.val);

            if (current.left != null) {
                current.left.hd = hd - 1;
                queue.add(current.left);
            }

            if (current.right != null) {
                current.right.hd = hd + 1;
                queue.add(current.right);
            }
        }

        // Print the nodes from left to right
        for (int value : map.values()) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        printBottomView(root);
    }
}
