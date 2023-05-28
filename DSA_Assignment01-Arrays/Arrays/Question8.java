package lecture1.Arrays;

import java.util.Arrays;
import java.util.HashSet;

/*
 * 
  You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.
 
       **Example 1:**
       Input: nums = [1,2,2,4]
       Output: [2,3]
*
*/

public class Question8 {
	
	public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int sum = (n * (n + 1)) / 2;
        int duplicate = 0;
        int actualSum = 0; 
        
      

        for (int num : nums) {
            if (set.contains(num)) {
                duplicate = num;
            } else {
                set.add(num);
                actualSum += num;
            }
        }

        int missingNum = sum - actualSum;
        result[0] = duplicate;
        result[1] = missingNum;

        return result;
    }
		
	

	public static void main(String[] args) {
      int[] nums = {1, 2, 2, 4};
        
        Question8 findErrorNums = new Question8();
        int[] result = findErrorNums.findErrorNums(nums);
        
        System.out.print("Result: [");
        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(result[i]);
        }
        System.out.println("]");
    }
      
	}
	
 


