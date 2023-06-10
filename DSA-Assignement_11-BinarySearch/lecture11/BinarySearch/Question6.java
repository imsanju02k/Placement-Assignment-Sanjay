package lecture11.BinarySearch;

/*

Suppose an array of length `n` sorted in ascending order is **rotated** between `1` and `n` times. For example, the array `nums = [0,1,2,4,5,6,7]` might become:

- `[4,5,6,7,0,1,2]` if it was rotated `4` times.
- `[0,1,2,4,5,6,7]` if it was rotated `7` times.

Notice that **rotating** an array `[a[0], a[1], a[2], ..., a[n-1]]` 1 time results in the array `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.

Given the sorted rotated array `nums` of **unique** elements, return *the minimum element of this array*.

You must write an algorithm that runs in `O(log n) time.`
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

*/

public class Question6 {
	
	 public int findMin(int[] nums) {
	        int left = 0;
	        int right = nums.length - 1;
	        
	        while (left < right) {
	            int mid = left + (right - left) / 2;
	            
	            if (nums[mid] < nums[right]) {
	                right = mid;
	            } else {
	                left = mid + 1;
	            }
	        }
	        
	        return nums[left];
	    }
	 
	 public static void main(String[] args) {
	        int[] nums = {3, 4, 5, 1, 2};
	        
	        Question6 solution = new Question6();
	        int minElement = solution.findMin(nums);
	        
	        System.out.println(minElement); // Output: 1
	    }
    
}


