package lecture15.statck;

/*

Given an integer k and a **[queue](https://www.geeksforgeeks.org/queue-data-structure/)** of integers, The task is to reverse the order of the first **k** elements of the queue, leaving the other elements in the same relative order.

Only following standard operations are allowed on queue.

- **enqueue(x) :** Add an item x to rear of queue
- **dequeue() :** Remove an item from front of queue
- **size() :** Returns number of elements in queue.
- **front() :** Finds front item.


*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Question6 {
    public static Queue<Integer> reverseFirstKElements(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k <= 0 || k > queue.size()) {
            return queue;
        }

        Stack<Integer> stack = new Stack<>();

        // Dequeue the first k elements and push them onto the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.remove());
        }

        // Enqueue the elements from the stack back into the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Dequeue the remaining elements and enqueue them back into the queue
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.remove());
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        queue1.add(4);
        queue1.add(5);
        int k1 = 3;
        System.out.println("Input queue: " + queue1);
        System.out.println("k: " + k1);
        Queue<Integer> modifiedQueue1 = reverseFirstKElements(queue1, k1);
        System.out.println("Modified queue: " + modifiedQueue1);

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(10);
        queue2.add(20);
        queue2.add(30);
        queue2.add(40);
        queue2.add(50);
        queue2.add(60);
        int k2 = 5;
        System.out.println("Input queue: " + queue2);
        System.out.println("k: " + k2);
        Queue<Integer> modifiedQueue2 = reverseFirstKElements(queue2, k2);
        System.out.println("Modified queue: " + modifiedQueue2);
    }
}
