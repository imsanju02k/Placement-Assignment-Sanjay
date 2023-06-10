package lecture11.BinarySearch;


/*
Given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive.

There is only **one repeated number** in `nums`, return *this repeated number*.

You must solve the problem **without** modifying the array `nums` and uses only constant extra space.

Input: nums = [1,3,4,2,2]
Output: 2

*/



public class Question4 {

	public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        
        Question4 solution = new Question4();
        int repeatedNumber = solution.findDuplicate(nums);
        
        System.out.println(repeatedNumber); // Output: 2
    }
	  public int findDuplicate(int[] nums) {
	        int slow = nums[0];
	        int fast = nums[0];
	        
	        // Find the meeting point inside the cycle
	        do {
	            slow = nums[slow];
	            fast = nums[nums[fast]];
	        } while (slow != fast);
	        
	        fast = nums[0];
	        
	        // Find the start of the cycle
	        while (slow != fast) {
	            slow = nums[slow];
	            fast = nums[fast];
	        }
	        
	        return slow;
	    }
   
}
