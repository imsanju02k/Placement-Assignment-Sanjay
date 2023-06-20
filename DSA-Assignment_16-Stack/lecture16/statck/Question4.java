package lecture15.statck;


/*
Given a Queue consisting of first **n** natural numbers (in random order). The task is to check whether the given Queue elements can be arranged in increasing order in another Queue using a stack. The operation allowed are:

1. Push and pop elements from the stack
2. Pop (Or Dequeue) from the given Queue.
3. Push (Or Enqueue) in the another Queue.

**Examples :**

Input : Queue[] = { 5, 1, 2, 3, 4 } 

Output : Yes 

Pop the first element of the given Queue 

i.e 5. Push 5 into the stack. 

Now, pop all the elements of the given Queue and push them to second Queue. 

Now, pop element 5 in the stack and push it to the second Queue.   

Input : Queue[] = { 5, 1, 2, 6, 3, 4 } 

Output : No 

Push 5 to stack. 

Pop 1, 2 from given Queue and push it to another Queue. 

Pop 6 from given Queue and push to stack. 

Pop 3, 4 from given Queue and push to second Queue. 

Now, from using any of above operation, we cannot push 5 into the second Queue because it is below the 6 in the stack.
*/



import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Question4 {
    public static String checkQueueArrangement(Queue<Integer> givenQueue) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> secondQueue = new LinkedList<>();
        int expectedElement = 1;

        while (!givenQueue.isEmpty()) {
            if (givenQueue.peek() == expectedElement) {
                secondQueue.add(givenQueue.remove());
                expectedElement++;
            } else if (!stack.isEmpty() && stack.peek() == expectedElement) {
                secondQueue.add(stack.pop());
                expectedElement++;
            } else {
                stack.push(givenQueue.remove());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == expectedElement) {
                secondQueue.add(stack.pop());
                expectedElement++;
            } else {
                return "No";
            }
        }

        if (secondQueue.isEmpty()) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(5);
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        queue1.add(4);
        System.out.println("Input queue: " + queue1);
        String result1 = checkQueueArrangement(queue1);
        System.out.println("Result: " + result1);

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(5);
        queue2.add(1);
        queue2.add(2);
        queue2.add(6);
        queue2.add(3);
        queue2.add(4);
        System.out.println("Input queue: " + queue2);
        String result2 = checkQueueArrangement(queue2);
        System.out.println("Result: " + result2);
    }
}
