package lecture5.TwoDArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

An integer array original is transformed into a **doubled** array changed by appending **twice the value** of every element in original, and then randomly **shuffling** the resulting array.

Given an array changed, return original *if* changed *is a **doubled** array. If* changed *is not a **doubled** array, return an empty array. The elements in* original *may be returned in **any** order*.

**Example 1:**

**Input:** changed = [1,3,4,2,6,8]

**Output:** [1,3,4]

**Explanation:** One possible original array could be [1,3,4]:

- Twice the value of 1 is 1 * 2 = 2.
- Twice the value of 3 is 3 * 2 = 6.
- Twice the value of 4 is 4 * 2 = 8.

Other original arrays could be [4,3,1] or [3,1,4].

*/

public class Question8 {

	 public static int[] findOriginalArray(int[] changed) {
	        if (changed.length % 2 != 0) {
	            return new int[0]; // If the length is odd, return an empty array
	        }

	        int[] original = new int[changed.length / 2];
	        Map<Integer, Integer> countMap = new HashMap<>();

	        // Count the occurrences of each element in the changed array
	        for (int num : changed) {
	            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
	        }

	        // Iterate through the changed array to construct the original array
	        int index = 0;
	        for (int num : changed) {
	            if (countMap.containsKey(num) && countMap.containsKey(num * 2)) {
	                original[index] = num;
	                countMap.put(num, countMap.get(num) - 1);
	                countMap.put(num * 2, countMap.get(num * 2) - 1);
	                index++;

	                if (countMap.get(num) == 0) {
	                    countMap.remove(num);
	                }
	                if (countMap.get(num * 2) == 0) {
	                    countMap.remove(num * 2);
	                }
	            }
	        }

	        if (index == original.length) {
	            return original; // If original array is fully constructed, return it
	        } else {
	            return new int[0]; // If original array is not fully constructed, return an empty array
	        }
	    }

	    public static void main(String[] args) {
	        int[] changed = {1, 3, 4, 2, 6, 8};

	        int[] original = findOriginalArray(changed);

	        System.out.println(Arrays.toString(original));
	    }
}


