package lecture17.Queues;

/*
 * 
Given a **circular integer array** `nums` of length `n`, return *the maximum possible sum of a non-empty **subarray** of* `nums`.

A **circular array** means the end of the array connects to the beginning of the array. Formally, the next element of `nums[i]` is `nums[(i + 1) % n]` and the previous element of `nums[i]` is `nums[(i - 1 + n) % n]`.

A **subarray** may only include each element of the fixed buffer `nums` at most once. Formally, for a subarray `nums[i], nums[i + 1], ..., nums[j]`, there does not exist `i <= k1`, `k2 <= j` with `k1 % n == k2 % n`. 

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.

*/

public class Question2 {
    public static int maxSubarraySum(int[] nums) {
        int maxSum = nums[0];
        int currentMax = nums[0];
        int n = nums.length;

        // Find the maximum subarray sum without circular wrapping
        for (int i = 1; i < n; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);
        }

        int totalSum = 0;
        int minSum = nums[0];
        int currentMin = nums[0];

        // Find the total sum and the minimum subarray sum with circular wrapping
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);
        }

        // If the total sum is equal to the minimum subarray sum (all negative elements), return the maximum subarray sum without circular wrapping
        if (totalSum == minSum) {
            return maxSum;
        }

        // Otherwise, return the maximum of the maximum subarray sum without circular wrapping and the (total sum - minimum subarray sum) with circular wrapping
        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        int[] nums = {5,-3,5};
        int maxSum = maxSubarraySum(nums);
        System.out.println("Maximum circular subarray sum: " + maxSum);
    }
}


