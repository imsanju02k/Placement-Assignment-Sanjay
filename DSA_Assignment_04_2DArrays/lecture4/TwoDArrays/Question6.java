package lecture4.TwoDArrays;

import java.util.Arrays;

/*


💡 Given an integer array nums sorted in **non-decreasing** order, return *an array of **the squares of each number** sorted in non-decreasing order*.

**Example 1:**

Input: nums = [-4,-1,0,3,10]

Output: [0,1,9,16,100]

**Explanation:** After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100]


*/

public class Question6 {

	 public static int[] sortedSquares(int[] nums) {
	        int n = nums.length;
	        int[] result = new int[n];
	        int left = 0;
	        int right = n - 1;

	        for (int i = n - 1; i >= 0; i--) {
	            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
	                result[i] = nums[left] * nums[left];
	                left++;
	            } else {
	                result[i] = nums[right] * nums[right];
	                right--;
	            }
	        }

	        return result;
	    }

	    public static void main(String[] args) {
	        int[] nums = {-4, -1, 0, 3, 10};
	        int[] squaredArray = sortedSquares(nums);
	        System.out.println("Sorted Squares: " + Arrays.toString(squaredArray));
	    }
}


