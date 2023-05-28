package lecture1.Arrays;

import java.util.HashSet;

/*
 * 
 Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

**Example 1:**
Input: nums = [1,2,3,1]

Output: true

*
*/

public class Question6 {
	
	public boolean containsDuplicate(int[] nums) {
	       HashSet<Integer> set=new HashSet<>();
	       for(int num:nums) {
	    	   if(set.contains(num)) {
	    		   return true;
	    	   }
	    	   set.add(num);
	       }
	       return false;
	    }
		
	
	
	

	public static void main(String[] args) {
		 int[] nums = {1, 2, 3, 2};
	        
		 Question6 containsDuplicate = new Question6();
	        boolean result = containsDuplicate.containsDuplicate(nums);
	        
	        System.out.println("Result: " + result);
	        System.out.println(" time complexity of O(n) and a space complexity of O(1) ");
      
	}
	
 

}
