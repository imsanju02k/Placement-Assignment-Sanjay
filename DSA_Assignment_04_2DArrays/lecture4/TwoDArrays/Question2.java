package lecture4.TwoDArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given two **0-indexed** integer arrays nums1 and nums2, return *a list* answer *of size* 2 *where:*

- answer[0] *is a list of all **distinct** integers in* nums1 *which are **not** present in* nums2*.*
- answer[1] *is a list of all **distinct** integers in* nums2 *which are **not** present in* nums1.

**Note** that the integers in the lists may be returned in **any** order.

**Example 1:**

**Input:** nums1 = [1,2,3], nums2 = [2,4,6]

**Output:** [[1,3],[4,6]]

**Explanation:**

For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].

For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
*/

public class Question2 {

	public static List<List<Integer>> findDistinctElements(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Add elements from nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Add elements from nums2 to set2
        for (int num : nums2) {
            set2.add(num);
        }

        // Find distinct elements in nums1 that are not present in nums2
        Set<Integer> distinct1 = new HashSet<>(set1);
        distinct1.removeAll(set2);

        // Find distinct elements in nums2 that are not present in nums1
        Set<Integer> distinct2 = new HashSet<>(set2);
        distinct2.removeAll(set1);

        // Convert the sets to lists
        List<Integer> list1 = new ArrayList<>(distinct1);
        List<Integer> list2 = new ArrayList<>(distinct2);

        // Create the result list
        List<List<Integer>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> distinctElements = findDistinctElements(nums1, nums2);
        System.out.println("Distinct elements: " + distinctElements);
    }
	}


