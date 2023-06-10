package lecture11.BinarySearch;

/*
 *

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
*/

public class Question3 {
	 public int missingNumber(int[] nums) {
	        int n = nums.length;
	        int missing = n;
	        
	        for (int i = 0; i < n; i++) {
	            missing ^= nums[i];
	            missing ^= i;
	        }
	        
	        return missing;
	    }
	 public static void main(String[] args) {
	        int[] nums = {9,6,4,2,3,5,7,0,1};
	        
	        Question3 solution = new Question3();
	        int missingNumber = solution.missingNumber(nums);
	        
	        System.out.println(missingNumber); // Output: 2
	    }
}


