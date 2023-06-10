package lecture11.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*


Given two integer arrays `nums1` and `nums2`, return *an array of their intersection*. Each element in the result must be **unique** and you may return the result in **any order**.

**Example 1:**
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
*/

public class Question5 {
	
	

	public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        
        Question5 solution = new Question5();
        int[] intersection = solution.intersection(nums1, nums2);
        
        System.out.println(Arrays.toString(intersection)); // Output: [2]
    }
	 public int[] intersection(int[] nums1, int[] nums2) {
	        Set<Integer> set = new HashSet<>();
	        
	        for (int num : nums1) {
	            set.add(num);
	        }
	        
	        List<Integer> intersection = new ArrayList<>();
	        
	        for (int num : nums2) {
	            if (set.contains(num)) {
	                intersection.add(num);
	                set.remove(num);
	            }
	        }
	        
	        int[] result = new int[intersection.size()];
	        
	        for (int i = 0; i < intersection.size(); i++) {
	            result[i] = intersection.get(i);
	        }
	        
	        return result;
	    }
}


