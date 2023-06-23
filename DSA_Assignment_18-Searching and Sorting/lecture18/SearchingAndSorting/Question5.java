package lecture18.SearchingAndSorting;

import java.util.Arrays;

/*


💡 5. **Contains Duplicate**

Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

Input: nums = [1,2,3,1]
Output: true



*/

import java.util.HashSet;

public class Question5 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        Question5 containsDuplicate = new Question5();
        boolean result = containsDuplicate.containsDuplicate(nums);

        System.out.println("Contains duplicate elements: " + result);
    }
}
