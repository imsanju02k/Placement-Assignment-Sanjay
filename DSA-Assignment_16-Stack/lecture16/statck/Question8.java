package lecture15.statck;

/*

Given an array of integers, the task is to find the maximum absolute difference between the nearest left and the right smaller element of every element in the array.

**Note:** If there is no smaller element on right side or left side of any element then we take zero as the smaller element. For example for the leftmost element, the nearest smaller element on the left side is considered as 0. Similarly, for rightmost elements, the smaller element on the right side is considered as 0.
Input : arr[] = {2, 1, 8}
Output : 1
Left smaller  LS[] {0, 0, 1}
Right smaller RS[] {1, 0, 0}
Maximum Diff of abs(LS[i] - RS[i]) = 1

Input  : arr[] = {2, 4, 8, 7, 7, 9, 3}
Output : 4
Left smaller   LS[] = {0, 2, 4, 4, 4, 7, 2}
Right smaller  RS[] = {0, 3, 7, 3, 3, 3, 0}
Maximum Diff of abs(LS[i] - RS[i]) = 7 - 3 = 4

Input : arr[] = {5, 1, 9, 2, 5, 1, 7}
Output : 1
*/


import java.util.Stack;

public class Question8 {
    public static int findMaxDifference(int[] arr) {
        int n = arr.length;

        int[] LS = new int[n]; // Nearest smaller element on the left
        int[] RS = new int[n]; // Nearest smaller element on the right

        Stack<Integer> stack = new Stack<>();

        // Calculate LS array
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                LS[i] = 0;
            } else {
                LS[i] = arr[stack.peek()];
            }

            stack.push(i);
        }

        stack.clear();

        // Calculate RS array
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                RS[i] = 0;
            } else {
                RS[i] = arr[stack.peek()];
            }

            stack.push(i);
        }

        int maxDiff = Integer.MIN_VALUE;

        // Calculate the maximum absolute difference
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(LS[i] - RS[i]);
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 8};
        int maxDiff1 = findMaxDifference(arr1);
        System.out.println("Input array: [2, 1, 8]");
        System.out.println("Maximum absolute difference: " + maxDiff1);

        int[] arr2 = {2, 4, 8, 7, 7, 9, 3};
        int maxDiff2 = findMaxDifference(arr2);
        System.out.println("Input array: [2, 4, 8, 7, 7, 9, 3]");
        System.out.println("Maximum absolute difference: " + maxDiff2);

        int[] arr3 = {5, 1, 9, 2, 5, 1, 7};
        int maxDiff3 = findMaxDifference(arr3);
        System.out.println("Input array: [5, 1, 9, 2, 5, 1, 7]");
        System.out.println("Maximum absolute difference: " + maxDiff3);
    }
}


