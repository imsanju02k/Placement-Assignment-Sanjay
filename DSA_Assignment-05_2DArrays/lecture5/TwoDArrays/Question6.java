package lecture5.TwoDArrays;

import java.util.ArrayList;
import java.util.List;

/*


Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears **once** or **twice**, return *an array of all the integers that appears **twice***.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

**Example 1:**

**Input:** nums = [4,3,2,7,8,2,3,1]

**Output:**

[2,3]

*/

public class Question6 {

	  public static List<Integer> findDuplicates(int[] nums) {
	        List<Integer> duplicates = new ArrayList<>();

	        for (int num : nums) {
	            int index = Math.abs(num) - 1;

	            if (nums[index] < 0) {
	                duplicates.add(Math.abs(num));
	            } else {
	                nums[index] = -nums[index];
	            }
	        }

	        return duplicates;
	    }

	    public static void main(String[] args) {
	        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

	        List<Integer> duplicates = findDuplicates(nums);

	        System.out.println(duplicates);
	    }
}


