package lecture9.Recursion;

/*


Given an array of integers **arr**, the task is to find maximum element of that array using recursion.

**Example 1:**

Input: arr = {1, 4, 3, -5, -4, 8, 6};
Output: 8

**Example 2:**

Input: arr = {1, 4, 45, 6, 10, -8};
Output: 45

*/

public class Question5 {
	
	

    public static int findMax(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftMax = findMax(arr, start, mid);
            int rightMax = findMax(arr, mid + 1, end);
            return Math.max(leftMax, rightMax);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 3, -5, -4, 8, 6};
        int[] arr2 = {1, 4, 45, 6, 10, -8};

        int max1 = findMax(arr1, 0, arr1.length - 1);
        int max2 = findMax(arr2, 0, arr2.length - 1);

        System.out.println("Maximum element in arr1: " + max1);
        System.out.println("Maximum element in arr2: " + max2);
    }

	
}


