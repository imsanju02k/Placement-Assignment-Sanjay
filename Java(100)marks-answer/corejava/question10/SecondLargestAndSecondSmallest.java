package corejava.question10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SecondLargestAndSecondSmallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int count = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter the elements:");
        for (int i = 0; i < count; i++) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        if (numbers.size() < 2) {
            System.out.println("At least 2 elements are required.");
            return;
        }

        // Find the second largest element
        int secondLargest = findSecondLargest(numbers);

        // Find the second smallest element
        int secondSmallest = findSecondSmallest(numbers);

        System.out.println("Second Largest: " + secondLargest);
        System.out.println("Second Smallest: " + secondSmallest);
    }

    public static int findSecondLargest(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers.get(numbers.size() - 2);
    }

    public static int findSecondSmallest(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers.get(1);
    }
}
