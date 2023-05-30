package lecture3.Arrays;

import java.util.Arrays;

/*
Given a non-empty array of integers nums, every element appears twice except
for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only
constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

time complexity : O(n)
space complexity: O(1)
*/

public class Question6 {

	public static int singleNumber(int[] nums) {
        int result = 0;

        // Perform XOR of all elements in the array
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        int single = singleNumber(nums);
        System.out.println("Single number: " + single);
    }
}


