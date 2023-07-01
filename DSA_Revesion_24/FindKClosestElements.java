import java.util.*;

public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (right - left >= k) {
            int diffLeft = Math.abs(arr[left] - x);
            int diffRight = Math.abs(arr[right] - x);

            if (diffLeft <= diffRight) {
                right--;
            } else {
                left++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;

        List<Integer> closestElements = findClosestElements(arr, k, x);
        System.out.println("Closest elements: " + closestElements);
    }
}
