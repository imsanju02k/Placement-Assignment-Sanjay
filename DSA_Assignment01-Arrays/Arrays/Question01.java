package lecture1.Arrays;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

**Example:**
Input: nums = [2,7,11,15], target = 9
Output0 [0,1]*/

public class Question01 {
	
	public int[] twosum(int [] nums,int target) {
		Map<Integer,Integer> numMap=new HashMap<>();
		
		for(int i=0;i<nums.length;i++) {
			int complement=target-nums[i];
			
			if(numMap.containsKey(complement)) {
				return new int[] {numMap.get(complement),i};
			}
			numMap.put(nums[i], i);
		}
		
		
		return new int[0];
		
	}
	
	

	public static void main(String[] args) {
       int[] nums= {2,7,11,15};
       int target=18;
       
       Question01 twosum= new Question01();
       int[] result=twosum.twosum(nums, target);
       
       System.out.println("Indices : [ " +result[0] + ", " + result[1] + " ]");
	   System.out.println("The time complexity of this solution is O(n), where n is the length of the input array nums.");
	}
	
 

}
