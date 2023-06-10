package lecture11.BinarySearch;

import java.util.Stack;

/*
Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.

If `target` is not found in the array, return `[-1, -1]`.

You must write an algorithm with `O(log n)` runtime complexity.

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

*/


public class Question7 {
	 public int[] searchRange(int[] nums, int target) {
	        int[] result = {-1, -1};
	        
	        // Find the leftmost occurrence
	        int left = 0;
	        int right = nums.length - 1;
	        
	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            
	            if (nums[mid] == target) {
	                result[0] = mid;
	                right = mid - 1;
	            } else if (nums[mid] > target) {
	                right = mid - 1;
	            } else {
	                left = mid + 1;
	            }
	        }
	        
	        // Find the rightmost occurrence
	        left = 0;
	        right = nums.length - 1;
	        
	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            
	            if (nums[mid] == target) {
	                result[1] = mid;
	                left = mid + 1;
	            } else if (nums[mid] > target) {
	                right = mid - 1;
	            } else {
	                left = mid + 1;
	            }
	        }
	        
	        return result;
	    }
	 public static void main(String[] args) {
	        int[] nums = {5,7,7,8,8,10};
	        int target = 8;
	        
	        Question7 solution = new Question7();
	        int[] range = solution.searchRange(nums, target);
	        
	        System.out.println("Output: [" + range[0] + ", " + range[1] + "]"); // Output: [3, 4]
	    }
}