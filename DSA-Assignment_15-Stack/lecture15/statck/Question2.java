package lecture15.statck;

/*
Given an array a of integers of length n, find the nearest smaller number for every element such that the smaller element is on left side.If no small element present on the left print -1.
Input: n = 3
a = {1, 6, 2}
Output: -1 1 1

EXPLAINATION: There is no number at the
left of 1. Smaller number than 6 and 2 is 1.
*/

import java.util.*;

public class Question2 {
    public static int[] findNearestSmallerNumber(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate the array from left to right
        for (int i = 0; i < n; i++) {
            // Remove elements from stack that are greater than or equal to current element
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            // If stack is empty, there is no smaller element on the left
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            // Push the current element onto the stack
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 2};
        int[] nearestSmaller = findNearestSmallerNumber(arr);

        for (int i = 0; i < nearestSmaller.length; i++) {
            System.out.print(nearestSmaller[i] + " ");
        }
    }
}



