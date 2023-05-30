package lecture3.Arrays;

import java.util.Arrays;

/*
Given an integer array nums of length n and an integer target, find three integers
in nums such that the sum is closest to the target.
Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2

Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 the time complexity is O(n^2) and the space complexity is O(1)

*/

public class Question01 {



	
	    public static int threeSumClosest(int[] nums, int target) {
	        Arrays.sort(nums);
	        int closestSum = nums[0] + nums[1] + nums[2];

	        for (int i = 0; i < nums.length - 2; i++) {
	            int left = i + 1;
	            int right = nums.length - 1;

	            while (left < right) {
	                int currentSum = nums[i] + nums[left] + nums[right];

	                if (currentSum == target) {
	                    return currentSum; // Exact match found, return the sum
	                }

	                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
	                    closestSum = currentSum; // Update the closest sum
	                }

	                if (currentSum < target) {
	                    left++; // Move left pointer to increase the sum
	                } else {
	                    right--; // Move right pointer to decrease the sum
	                }
	            }
	        }

	        return closestSum;
	    }

	    public static void main(String[] args) {
	        int[] nums = {-1, 2, 1, -4};
	        int target = 1;
	        int closestSum = threeSumClosest(nums, target);
	        System.out.println("Closest sum to the target: " + closestSum);
	    }
	}


