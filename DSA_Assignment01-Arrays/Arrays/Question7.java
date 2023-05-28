package lecture1.Arrays;

import java.util.Arrays;

/*
 * 
  Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the nonzero elements.

Note that you must do this in-place without making a copy of the array.

**Example 1:**
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

*
*/

public class Question7 {
	
	public void moveZeroes(int[] nums) {
	      int i=0;
	      
	      //move non-zero to the front
	      for(int j=0;j<nums.length;j++) {
	    	  if(nums[j]!=0) {
	    		  nums[i]=nums[j];
	    		  i++;
	    	  }
	      }
	      //fill the remaining position with zeros
	      while(i<nums.length) {
	    	  nums[i]=0;
	    	  i++;
	      }
	    }
		
	
	
	

	public static void main(String[] args) {
		 int[] nums = {0, 1, 0, 3, 12,0,2};
		 Arrays.sort(nums);
	        
		 Question7 moveZeros = new Question7();
	        moveZeros.moveZeroes(nums);
	        
	        System.out.print("Result: [");
	        for (int i = 0; i < nums.length; i++) {
	            if (i > 0) {
	                System.out.print(", ");
	            }
	            System.out.print(nums[i]);
	        }
	        System.out.println("]");
      
	}
	
 

}
