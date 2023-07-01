import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right, next;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}

public class ConnectNodesAtSameLevel {
    public static void connect(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode prev = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                if (prev != null)
                    prev.next = curr;

                prev = curr;

                if (curr.left != null)
                    queue.offer(curr.left);

                if (curr.right != null)
                    queue.offer(curr.right);
            }

            prev.next = null; // Set the next pointer of the last node to null
        }
    }

    public static void printLevelOrderTraversal(TreeNode root) {
        TreeNode currLevel = root;

        while (currLevel != null) {
            TreeNode currNode = currLevel;

            while (currNode != null) {
                System.out.print(currNode.val + " → ");
                currNode = currNode.next;
            }

            System.out.println("-1");
            currLevel = currLevel.left;
        }
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Connect nodes at the same level
        connect(root);

        // Print the level order traversal with next pointers
        printLevelOrderTraversal(root);
    }
}
