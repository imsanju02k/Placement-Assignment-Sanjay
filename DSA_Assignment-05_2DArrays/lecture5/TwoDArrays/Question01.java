package lecture5.TwoDArrays;

import java.util.ArrayList;
import java.util.List;

/*

Convert 1D Array Into 2D Array

You are given a **0-indexed** 1-dimensional (1D) integer array original, and two integers, m and n. You are tasked with creating a 2-dimensional (2D) array with  m rows and n columns using **all** the elements from original.

The elements from indices 0 to n - 1 (**inclusive**) of original should form the first row of the constructed 2D array, the elements from indices n to 2 * n - 1 (**inclusive**) should form the second row of the constructed 2D array, and so on.

Return *an* m x n *2D array constructed according to the above procedure, or an empty 2D array if it is impossible*.

**Input:** original = [1,2,3,4], m = 2, n = 2

**Output:** [[1,2],[3,4]]

**Explanation:** The constructed 2D array should contain 2 rows and 2 columns.

The first group of n=2 elements in original, [1,2], becomes the first row in the constructed 2D array.

The second group of n=2 elements in original, [3,4], becomes the second row in the constructed 2D array.


*/

public class Question01 {

   
    	 public static int[][] construct2DArray(int[] original, int m, int n) {
    	        if (original.length != m * n) {
    	            return new int[0][0];
    	        }

    	        int[][] result = new int[m][n];

    	        for (int i = 0; i < m * n; i += n) {
    	            int[] row = new int[n];
    	            System.arraycopy(original, i, row, 0, n);
    	            result[i / n] = row;
    	        }

    	        return result;
      }
  
    public static void main(String[] args) {
    	int[] original = {1, 2, 3, 4};
        int m = 2;
        int n = 2;

        int[][] result = construct2DArray(original, m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
  }
  }



