package lecture18.SearchingAndSorting;

/*

Given an integer array `nums`, return *the maximum difference between two successive elements in its sorted form*. If the array contains less than two elements, return `0`.

You must write an algorithm that runs in linear time and uses linear extra space.

Input: nums = [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.



*/

import java.util.Arrays;

public class Question4 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        
        if (n < 2) {
            return 0;
        }
        
        // Find the maximum and minimum values in the array
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int minVal = Arrays.stream(nums).min().getAsInt();
        
        // Calculate the bucket size and number of buckets
        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));
        int numBuckets = (maxVal - minVal) / bucketSize + 1;
        
        // Initialize the buckets
        int[][] buckets = new int[numBuckets][2];
        for (int i = 0; i < numBuckets; i++) {
            Arrays.fill(buckets[i], -1);
        }
        
        // Populate the buckets with values
        for (int num : nums) {
            int bucketIndex = (num - minVal) / bucketSize;
            
            if (buckets[bucketIndex][0] == -1) {
                buckets[bucketIndex][0] = num;
                buckets[bucketIndex][1] = num;
            } else {
                buckets[bucketIndex][0] = Math.min(buckets[bucketIndex][0], num);
                buckets[bucketIndex][1] = Math.max(buckets[bucketIndex][1], num);
            }
        }
        
        // Calculate the maximum gap
        int maxGap = 0;
        int prevMax = minVal;
        
        for (int[] bucket : buckets) {
            if (bucket[0] == -1) {
                continue;
            }
            
            maxGap = Math.max(maxGap, bucket[0] - prevMax);
            prevMax = bucket[1];
        }
        
        return maxGap;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};

        Question4 maximumGap = new Question4();
        int maxDifference = maximumGap.maximumGap(nums);

        System.out.println("The maximum difference is: " + maxDifference);
    }
}
