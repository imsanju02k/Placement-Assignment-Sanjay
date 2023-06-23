package lecture19.SearchingAndSorting;

import java.util.HashSet;

/*

Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are2 smaller elements (2 and 1).
To the right of 2 there is only1 smaller element (1).
To the right of 6 there is1 smaller element (1).
To the right of 1 there is0 smaller element.




*/

import java.util.ArrayList;
import java.util.List;

public class Question2 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        // Create a sorted list to store the elements encountered so far
        List<Integer> sortedList = new ArrayList<>();

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];

            // Find the insertion position of the current element in the sorted list
            int insertionPos = findInsertionPosition(sortedList, num);

            // Add the insertion position to the result (number of smaller elements to the right)
            result.add(0, insertionPos);

            // Insert the current element at the correct position in the sorted list
            sortedList.add(insertionPos, num);
        }

        return result;
    }

    // Binary search to find the insertion position in the sorted list
    private int findInsertionPosition(List<Integer> sortedList, int target) {
        int left = 0;
        int right = sortedList.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            int midNum = sortedList.get(mid);

            if (midNum < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        Question2 counter = new Question2();
        List<Integer> result = counter.countSmaller(nums);
        System.out.println(result);
    }
}
