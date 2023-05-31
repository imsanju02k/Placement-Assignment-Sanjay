package lecture6.TwoDArrays;

/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

**Example 1:**
***Input:** n = 3

**Output:** [[1,2,3],[8,9,4],[7,6,5]]

*/


public class Question7 {
	 public static int[][] generateMatrix(int n) {
	        int[][] matrix = new int[n][n];
	        int num = 1; // Current number to fill
	        
	        int rowStart = 0;
	        int rowEnd = n - 1;
	        int colStart = 0;
	        int colEnd = n - 1;
	        
	        while (rowStart <= rowEnd && colStart <= colEnd) {
	            // Fill top row from left to right
	            for (int col = colStart; col <= colEnd; col++) {
	                matrix[rowStart][col] = num++;
	            }
	            rowStart++;
	            
	            // Fill right column from top to bottom
	            for (int row = rowStart; row <= rowEnd; row++) {
	                matrix[row][colEnd] = num++;
	            }
	            colEnd--;
	            
	            if (rowStart <= rowEnd) {
	                // Fill bottom row from right to left
	                for (int col = colEnd; col >= colStart; col--) {
	                    matrix[rowEnd][col] = num++;
	                }
	                rowEnd--;
	            }
	            
	            if (colStart <= colEnd) {
	                // Fill left column from bottom to top
	                for (int row = rowEnd; row >= rowStart; row--) {
	                    matrix[row][colStart] = num++;
	                }
	                colStart++;
	            }
	        }
	        
	        return matrix;
	    }

	    public static void main(String[] args) {
	        int n = 3;
	        int[][] matrix = generateMatrix(n);
	        
	        for (int[] row : matrix) {
	            for (int num : row) {
	                System.out.print(num + " ");
	            }
	            System.out.println();
	        }
	    }
	}