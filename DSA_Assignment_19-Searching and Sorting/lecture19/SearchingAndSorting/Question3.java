package lecture19.SearchingAndSorting;

import java.util.HashMap;

/*

Given an array of integers `nums`, sort the array in ascending order and return it.

You must solve the problem **without using any built-in** functions in `O(nlog(n))` time complexity and with the smallest space complexity possible.

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).





*/

public class Question3 {
    public void sortArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        mergeSort(nums, temp, 0, n - 1);
    }

    private void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid + 1, right);

        merge(nums, temp, left, mid, right);
    }

    private void merge(int[] nums, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            nums[k] = temp[i];
            i++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Question3 sorter = new Question3();
        sorter.sortArray(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
