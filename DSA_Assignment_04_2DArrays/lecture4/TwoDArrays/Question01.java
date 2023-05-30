package lecture4.TwoDArrays;

import java.util.ArrayList;
import java.util.List;

/*

💡 Given three integer arrays arr1, arr2 and arr3 **sorted** in **strictly increasing** order, return a sorted array of **only** the integers that appeared in **all** three arrays.

**Example 1:**

Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]

Output: [1,5]

**Explanation:** Only 1 and 5 appeared in the three arrays.

tc:O(n)
sc:O(1)


*/

public class Question01 {

    public static List<Integer> findCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0; // Pointers for the three arrays

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                // Common element found, add it to the result
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else {
                // Increment the pointer of the array with the smallest element
                int min = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
                if (arr1[i] == min) {
                    i++;
                }
                if (arr2[j] == min) {
                    j++;
                }
                if (arr3[k] == min) {
                    k++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 5, 7, 9};
        int[] arr3 = {1, 3, 4, 5, 8};
        List<Integer> commonElements = findCommonElements(arr1, arr2, arr3);
        System.out.println("Common elements: " + commonElements);
    }
	}


