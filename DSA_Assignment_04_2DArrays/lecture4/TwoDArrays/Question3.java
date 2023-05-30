package lecture4.TwoDArrays;

import java.util.Arrays;

/*
 *

💡 Given a 2D integer array matrix, return *the **transpose** of* matrix.

The **transpose** of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

**Example 1:**

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]

Output: [[1,4,7],[2,5,8],[3,6,9]]



*/

public class Question3 {
	 public static int[][] transpose(int[][] matrix) {
	        int rows = matrix.length;
	        int columns = matrix[0].length;

	        int[][] transposeMatrix = new int[columns][rows];

	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < columns; j++) {
	                transposeMatrix[j][i] = matrix[i][j];
	            }
	        }

	        return transposeMatrix;
	    }

	    public static void main(String[] args) {
	        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	        int[][] transposeMatrix = transpose(matrix);

	        System.out.println("Transpose of the matrix:");
	        for (int[] row : transposeMatrix) {
	            for (int element : row) {
	                System.out.print(element + " ");
	            }
	            System.out.println();
	        }
	    }
	}


