package lecture11.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

*/

public class Question8 {
	

	 public static void main(String[] args) {
	        int[] nums1 = {1, 2, 2, 1};
	        int[] nums2 = {2, 2};
	        
	        Question8 solution = new Question8();
	        int[] intersection = solution.intersect(nums1, nums2);
	        
	        System.out.println(Arrays.toString(intersection)); // Output: [2, 2]
	    }
	 public int[] intersect(int[] nums1, int[] nums2) {
	        Map<Integer, Integer> freqMap = new HashMap<>();
	        
	        for (int num : nums1) {
	            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
	        }
	        
	        List<Integer> intersection = new ArrayList<>();
	        
	        for (int num : nums2) {
	            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
	                intersection.add(num);
	                freqMap.put(num, freqMap.get(num) - 1);
	            }
	        }
	        
	        int[] result = new int[intersection.size()];
	        
	        for (int i = 0; i < intersection.size(); i++) {
	            result[i] = intersection.get(i);
	        }
	        
	        return result;
	    }
   
}


