package lecture6.TwoDArrays;

/*

Given two [sparse matrices](https://en.wikipedia.org/wiki/Sparse_matrix) mat1 of size m x k and mat2 of size k x n, return the result of mat1 x mat2. You may assume that multiplication is always possible.

**Example 1:**

**Input:** mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]

**Output:**

[[7,0,0],[-7,0,3]]

*/

public class Question8 {

	public static int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int x = 0; x < k; x++) {
                    sum += mat1[i][x] * mat2[x][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat1 = {{1, 0, 0}, {-1, 0, 3}};
        int[][] mat2 = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};

        int[][] result = multiply(mat1, mat2);

        // Print the result
        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}


