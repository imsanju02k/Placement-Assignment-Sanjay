class BinaryTree {
    boolean isLevelOrderBST(int[] arr, int n) {
        if (n == 0)
            return true;

        return isLevelOrderBSTUtil(arr, n, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isLevelOrderBSTUtil(int[] arr, int n, int index, int min, int max) {
        if (index >= n)
            return true;

        if (arr[index] < min || arr[index] > max)
            return false;

        int i;
        for (i = index + 1; i < n; i++) {
            if (arr[i] > arr[index])
                break;
        }

        return isLevelOrderBSTUtil(arr, n, index + 1, min, arr[index] - 1)
                && isLevelOrderBSTUtil(arr, n, i, arr[index] + 1, max);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] arr1 = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        int[] arr2 = {11, 6, 13, 5, 12, 10};

        if (tree.isLevelOrderBST(arr1, arr1.length))
            System.out.println("Output1: Yes");
        else
            System.out.println("Output1: No");

        if (tree.isLevelOrderBST(arr2, arr2.length))
            System.out.println("Output2: Yes");
        else
            System.out.println("Output2: No");
    }
}
