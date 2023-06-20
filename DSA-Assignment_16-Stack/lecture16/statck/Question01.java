package lecture15.statck;

/*
Given an array,for each element find the value of the nearest element to the right which is having a frequency greater than that of the current element.If there does not exist an answer for a position,then make the value‘-1’.
Input: a[] = [1, 1, 2, 3, 4, 2, 1]
Output : [-1, -1, 1, 2, 2, 1, -1]

*/

import java.util.*;



public class Question01 {
    public static int[] findNearestGreaterFrequency(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);

            while (!stack.isEmpty() && frequencyMap.get(arr[stack.peek()]) <= frequencyMap.get(arr[i])) {
                int index = stack.pop();
                if (frequencyMap.get(arr[i]) > frequencyMap.get(arr[index])) {
                    result[index] = arr[i];
                }
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 11, 3, 3};
        int[] output = findNearestGreaterFrequency(arr);

        System.out.print("Output: [");
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]);
            if (i < output.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
