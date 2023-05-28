package lecture2.Arrays;

import java.util.HashMap;
import java.util.HashSet;

/*

We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

A subsequence of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

Example 1:
Input: nums = [1,3,2,2,5,2,3,7]
Output: 5

Explanation: The longest harmonious subsequence is [3,2,2,2,3].





*/

public class Question3 {
	
	public static int findLHS(int[] nums) {
		HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int maxLength = 0;

       
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Check each number and its neighboring number
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.containsKey(num + 1)) {
                int currentLength = frequencyMap.get(num) + frequencyMap.get(num + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        int result = findLHS(nums);
        //System.out.println(result);
        System.out.println("The MaxLengthOfHarmonicSequence is : " + result);
    }
		
			
}
	


