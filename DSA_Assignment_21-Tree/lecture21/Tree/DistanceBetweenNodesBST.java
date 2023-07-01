class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class DistanceBetweenNodesBST {
    private static TreeNode findLCA(TreeNode root, int node1, int node2) {
        if (root == null)
            return null;

        if (root.val > node1 && root.val > node2)
            return findLCA(root.left, node1, node2);

        if (root.val < node1 && root.val < node2)
            return findLCA(root.right, node1, node2);

        return root;
    }

    private static int findDistance(TreeNode root, int node, int distance) {
        if (root == null)
            return -1;

        if (root.val == node)
            return distance;

        if (root.val > node)
            return findDistance(root.left, node, distance + 1);

        return findDistance(root.right, node, distance + 1);
    }

    public static int findDistanceBetweenNodes(TreeNode root, int node1, int node2) {
        TreeNode lca = findLCA(root, node1, node2);

        int distance1 = findDistance(lca, node1, 0);
        int distance2 = findDistance(lca, node2, 0);

        return distance1 + distance2;
    }

    public static void main(String[] args) {
        // Construct the binary search tree
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        int node1 = 6;
        int node2 = 14;

        int distance = findDistanceBetweenNodes(root, node1, node2);

        System.out.println("The distance between the two keys = " + distance);
    }
}
