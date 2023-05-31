package lecture6.TwoDArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

public class Question6 {

	public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        
        // Check if the number of elements is odd
        if (n % 2 != 0) {
            return new int[0]; // Empty array
        }
        
        // Build frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : changed) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> originalList = new ArrayList<>();
        
        // Process the elements in ascending order
        for (int num : changed) {
            // Skip if the element has already been used
            if (frequencyMap.get(num) == 0) {
                continue;
            }
            
            // Check if the doubled value exists in the frequency map
            int doubledNum = num * 2;
            if (!frequencyMap.containsKey(doubledNum) || frequencyMap.get(doubledNum) == 0) {
                return new int[0]; // Empty array
            }
            
            // Add the original element to the result
            originalList.add(num);
            
            // Update the frequency map
            frequencyMap.put(num, frequencyMap.get(num) - 1);
            frequencyMap.put(doubledNum, frequencyMap.get(doubledNum) - 1);
        }
        
        int[] originalArray = new int[originalList.size()];
        for (int i = 0; i < originalList.size(); i++) {
            originalArray[i] = originalList.get(i);
        }
        
        return originalArray;
    }

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] original = findOriginalArray(changed);
        for (int num : original) {
            System.out.print(num + " "); // Output: 1 3 4
        }
    }
}


