package lecture2.Arrays;

import java.util.Arrays;

/*

You are given an integer array nums and an integer k.

In one operation, you can choose any index i where 0 <= i < nums.length and change nums[i] to nums[i] + x where x is an integer from the range [-k, k]. You can apply this operation at most once for each index i.

The score of nums is the difference between the maximum and minimum elements in nums.

Return the minimum score of nums after applying the mentioned operation at most once for each index in it.

Example 1:
Input: nums = [1], k = 0
Output: 0

Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.





*/

public class Question8 {
	   public static int minimumScore(int[] nums, int k) {
	        int n = nums.length;
	        Arrays.sort(nums);
	        
	        int minScore = nums[n - 1] - nums[0];
	        
	        for (int i = 1; i < n; i++) {
	            int high = Math.max(nums[i - 1] + k, nums[n - 1] - k);
	            int low = Math.min(nums[0] + k, nums[i] - k);
	            
	            minScore = Math.min(minScore, high - low);
	        }
	        
	        return minScore;
	    }

	    public static void main(String[] args) {
	        int[] nums = {1};
	        int k = 0;
	        int result = minimumScore(nums, k);
	        System.out.println(result);
	    }
	

}
