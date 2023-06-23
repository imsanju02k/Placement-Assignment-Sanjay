package lecture17.Queues;

/*
Design a queue that supports `push` and `pop` operations in the front, middle, and back.

Implement the `FrontMiddleBack` class:

- `FrontMiddleBack()` Initializes the queue.
- `void pushFront(int val)` Adds `val` to the **front** of the queue.
- `void pushMiddle(int val)` Adds `val` to the **middle** of the queue.
- `void pushBack(int val)` Adds `val` to the **back** of the queue.
- `int popFront()` Removes the **front** element of the queue and returns it. If the queue is empty, return `1`.
- `int popMiddle()` Removes the **middle** element of the queue and returns it. If the queue is empty, return `1`.
- `int popBack()` Removes the **back** element of the queue and returns it. If the queue is empty, return `1`.

**Notice** that when there are **two** middle position choices, the operation is performed on the **frontmost** middle position choice. For example:

- Pushing `6` into the middle of `[1, 2, 3, 4, 5]` results in `[1, 2, 6, 3, 4, 5]`.
- Popping the middle from `[1, 2, 3, 4, 5, 6]` returns `3` and results in `[1, 2, 4, 5, 6]`.

*/
import java.util.ArrayDeque;
import java.util.Deque;

public class Question7 {
    private Deque<Integer> frontDeque;
    private Deque<Integer> backDeque;

    public Question7() {
        frontDeque = new ArrayDeque<>();
        backDeque = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        frontDeque.offerFirst(val);
        balanceQueues();
    }

    public void pushMiddle(int val) {
        if (frontDeque.size() > backDeque.size()) {
            backDeque.offerFirst(frontDeque.pollLast());
        }
        frontDeque.offerLast(val);
    }

    public void pushBack(int val) {
        backDeque.offerLast(val);
        balanceQueues();
    }

    public int popFront() {
        if (isEmpty()) {
            return -1;
        }
        int val = frontDeque.isEmpty() ? backDeque.pollFirst() : frontDeque.pollFirst();
        balanceQueues();
        return val;
    }

    public int popMiddle() {
        if (isEmpty()) {
            return -1;
        }
        int val;
        if (frontDeque.size() >= backDeque.size()) {
            val = frontDeque.pollLast();
        } else {
            val = backDeque.pollFirst();
        }
        balanceQueues();
        return val;
    }

    public int popBack() {
        if (isEmpty()) {
            return -1;
        }
        int val = backDeque.isEmpty() ? frontDeque.pollLast() : backDeque.pollLast();
        balanceQueues();
        return val;
    }

    private boolean isEmpty() {
        return frontDeque.isEmpty() && backDeque.isEmpty();
    }

    private void balanceQueues() {
        if (frontDeque.size() > backDeque.size() + 1) {
            backDeque.offerFirst(frontDeque.pollLast());
        } else if (backDeque.size() > frontDeque.size()) {
            frontDeque.offerLast(backDeque.pollFirst());
        }
    }

    public static void main(String[] args) {
        Question7 queue = new Question7();
        queue.pushFront(1);
        queue.pushBack(2);
        queue.pushMiddle(3);
        System.out.println(queue.popFront()); // Output: 1
        System.out.println(queue.popMiddle()); // Output: 3
        System.out.println(queue.popBack()); // Output: 2
    }
}


