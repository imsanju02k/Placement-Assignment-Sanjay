package lecture19.SearchingAndSorting;

import java.util.Arrays;

/*

Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by a negative and vice-versa maintaining the order of appearance. The number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear at the end of the array.

Input:  arr[] = {1, 2, 3, -4, -1, 4}
Output: arr[] = {-4, 1, -1, 2, 3, 4}

Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
Output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}

*/

public class Question5 {
    public static void alternateArrange(int[] arr) {
        int n = arr.length;
        int positive = 0; // Pointer for positive numbers

        // Find the index of the first negative number
        while (positive < n && arr[positive] >= 0) {
            positive++;
        }

        // Rearrange the array in an alternate fashion
        int negative = 1; // Pointer for negative numbers

        while (positive < n && negative < n) {
            // Swap the positive and negative numbers
            int temp = arr[positive];
            arr[positive] = arr[negative];
            arr[negative] = temp;

            positive += 2;
            negative += 2;

            // Find the next positive number
            while (positive < n && arr[positive] >= 0) {
                positive += 2;
            }

            // Find the next negative number
            while (negative < n && arr[negative] < 0) {
                negative += 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -1, 4};
        alternateArrange(arr);

        // Print the modified array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
