package lecture3.Arrays;
/*

You are given an inclusive range [lower, upper] and a sorted unique integer array
nums, where all elements are within the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in
nums.

Return the shortest sorted list of ranges that exactly covers all the missing
numbers. That is, no element of nums is included in any of the ranges, and each
missing number is covered by one of the ranges.

Example 1:
Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: [[2,2],[4,49],[51,74],[76,99]]

Explanation: The ranges are:
[2,2]
[4,49]
[51,74]
[76,99]

*/



import java.util.ArrayList;
import java.util.List;

public class Question7 {
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        long prev = (long) lower - 1; // Initialize the previous number as lower - 1

        for (int i = 0; i <= nums.length; i++) {
            long curr = (i == nums.length) ? (long) upper + 1 : nums[i]; // Set the current number as upper + 1 after the last element

            if (curr - prev >= 2) {
                result.add(formatRange(prev + 1, curr - 1)); // Add the missing range between prev and curr
            }

            prev = curr; // Update the previous number
        }

        return result;
    }
	
	 private static String formatRange(long lower, long upper) {
	        if (lower == upper) {
	            return String.valueOf(lower);
	        } else {
	            return lower + "->" + upper;
	        }
	    }

	 public static void main(String[] args) {
	        int[] nums = {0, 1, 3, 50, 75};
	        int lower = 0;
	        int upper = 99;
	        List<String> missingRanges = findMissingRanges(nums, lower, upper);
	        System.out.println("Missing ranges: " + missingRanges);
	    }
	}