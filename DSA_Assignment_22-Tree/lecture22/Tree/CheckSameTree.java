import java.util.Arrays;

public class CheckSameTree {
    public static boolean isSameTree(int[] inorder, int[] preorder, int[] postorder) {
        if (inorder.length == 0)
            return true;

        if (inorder.length == 1)
            return (preorder[0] == inorder[0] && postorder[0] == inorder[0]);

        int root = preorder[0];
        int rootIndex = -1;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                rootIndex = i;
                break;
            }
        }

        if (rootIndex == -1)
            return false;

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);

        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, rootIndex);
        int[] rightPostorder = Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1);

        boolean isLeftSame = isSameTree(leftInorder, leftPreorder, leftPostorder);
        boolean isRightSame = isSameTree(rightInorder, rightPreorder, rightPostorder);

        return isLeftSame && isRightSame;
    }

    public static void main(String[] args) {
        int[] inorder = { 4, 2, 5, 1, 3 };
        int[] preorder = { 1, 2, 4, 5, 3 };
        int[] postorder = { 4, 5, 2, 3, 1 };

        boolean result = isSameTree(inorder, preorder, postorder);

        System.out.println(result ? "Yes" : "No");
    }
}
