package lecture18.SearchingAndSorting;

import java.util.Arrays;

/*

Given an integer array nums, return the length of the longest strictly increasing

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.




*/

public class Question7 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxLen = 0;
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen;
    }
    public static void main(String[] args) {
    	int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    	Question7 lis = new Question7();
    	int maxLength = lis.lengthOfLIS(nums);
    	System.out.println("Length of the longest increasing subsequence: " + maxLength);

	}
}
