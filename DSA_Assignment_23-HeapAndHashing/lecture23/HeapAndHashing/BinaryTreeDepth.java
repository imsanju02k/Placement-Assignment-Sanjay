public class BinaryTreeDepth {
    public static int calculateDepth(String preorder) {
        int depth = 0;
        int maxDepth = 0;

        for (char c : preorder.toCharArray()) {
            if (c == 'n') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (c == 'l') {
                depth--;
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        String preorder = "nlnll";
        int depth = calculateDepth(preorder);
        System.out.println("Depth: " + depth);
    }
}
