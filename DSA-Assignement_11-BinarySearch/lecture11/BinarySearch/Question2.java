package lecture11.BinarySearch;

/*
 * 
 * 
A peak element is an element that is strictly greater than its neighbors.

Given a **0-indexed** integer array `nums`, find a peak element, and return its index. If the array contains multiple peaks, return the index to **any of the peaks**.

You may imagine that `nums[-1] = nums[n] = -∞`. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in `O(log n)` time.
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
*/

public class Question2 {
	 public int findPeakElement(int[] nums) {
	        int left = 0;
	        int right = nums.length - 1;
	        
	        while (left < right) {
	            int mid = left + (right - left) / 2;
	            
	            if (nums[mid] > nums[mid + 1]) {
	                right = mid;
	            } else {
	                left = mid + 1;
	            }
	        }
	        
	        return left;
	    }
	 
	 public static void main(String[] args) {
	        int[] nums = {1, 2, 3, 1};
	        
	        Question2 solution = new Question2();
	        int peakIndex = solution.findPeakElement(nums);
	        
	        System.out.println(peakIndex); // Output: 2
	    }
	 
}


