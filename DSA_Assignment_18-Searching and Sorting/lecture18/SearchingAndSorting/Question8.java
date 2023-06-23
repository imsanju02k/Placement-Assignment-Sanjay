package lecture18.SearchingAndSorting;

import java.util.Stack;

/*



Given an array of `n` integers `nums`, a **132 pattern** is a subsequence of three integers `nums[i]`, `nums[j]` and `nums[k]` such that `i < j < k` and `nums[i] < nums[k] < nums[j]`.

Return `true` *if there is a **132 pattern** in* `nums`*, otherwise, return* `false`*.*



Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.




*/


public class Question8 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] minArray = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Find the minimum element so far for each index
        minArray[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minArray[i] = Math.min(minArray[i - 1], nums[i]);
        }
        
        // Check for the 132 pattern
        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] > minArray[j]) {
                while (!stack.isEmpty() && stack.peek() <= minArray[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        
        return false;
    }
    public static void main(String[] args) {
    	int[] nums = {3,1,4,2};
    	Question8 pattern132 = new Question8();
    	boolean hasPattern = pattern132.find132pattern(nums);
    	System.out.println("Has 132 pattern: " + hasPattern);

	}
}

