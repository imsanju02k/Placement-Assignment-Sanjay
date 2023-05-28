package lecture2.Arrays;

import java.util.Arrays;

/*

Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:
Input: nums = [1,2,3]
Output: 6



*/

public class Question5 {
	 public static int maximumProduct(int[] nums) {
	        Arrays.sort(nums);
	        
	        // The maximum product can be obtained by multiplying the three largest numbers or the two smallest numbers and the largest number
	        int n = nums.length;
	        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
	        int option2 = nums[0] * nums[1] * nums[n - 1];
	        
	        return Math.max(option1, option2);
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
        int result = maximumProduct(nums);
        System.out.println(result);
		
	}
	

}
