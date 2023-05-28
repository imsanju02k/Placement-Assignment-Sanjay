package lecture2.Arrays;

import java.util.Arrays;

/*<aside>

💡 Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2),..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

**Example 1:**
Input: nums = [1,4,3,2]
Output: 4

**Explanation:** All possible pairings (ignoring the ordering of elements) are:

1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
So the maximum possible sum is 4

</aside>*/

public class Question1 {
	public static int arraysPariSume(int[] nums) {
		Arrays.sort(nums);
		
		int sum=0;
		for(int i=0;i<nums.length;i+=2) {
			sum+=nums[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] nums= {1,4,3,2};
		int result=arraysPariSume(nums);
		System.out.println("the maximum possible sum of the minimum values in each pair is " +result);
		System.out.println();
		System.out.println("time complexity of O(n log n), where n is the length of the nums array.");
		System.out.println("the overall time complexity is O(n log n + n), which simplifies to O(n log n)");
	}
	

}
