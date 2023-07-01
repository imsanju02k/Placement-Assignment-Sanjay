import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class RootToLeafPaths {
    public static void printRootToLeafPaths(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();

        nodeStack.push(root);
        pathStack.push(Integer.toString(root.val));

        while (!nodeStack.isEmpty()) {
            TreeNode currNode = nodeStack.pop();
            String currPath = pathStack.pop();

            if (currNode.left == null && currNode.right == null) {
                System.out.println(currPath);
            }

            if (currNode.right != null) {
                nodeStack.push(currNode.right);
                pathStack.push(currPath + "->" + currNode.right.val);
            }

            if (currNode.left != null) {
                nodeStack.push(currNode.left);
                pathStack.push(currPath + "->" + currNode.left.val);
            }
        }
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Print the root-to-leaf paths
        printRootToLeafPaths(root);
    }
}
