package lecture15.statck;

/*
 *

Implement a Stack using two queues q1 and q2.
Input:
push(2)
push(3)
pop()
push(4)
pop()
Output:3 4
Explanation:
push(2) the stack will be {2}
push(3) the stack will be {2 3}
pop()   poped element will be 3 the
        stack will be {2}
push(4) the stack will be {2 4}
pop()   poped element will be 4

*/

import java.util.*;

public class Question3 {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public Question3() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int value) {
        // Add the new element to the empty queue
        q2.add(value);

        // Move all elements from the main queue (q1) to the temporary queue (q2)
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        // Swap the references of q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // Remove and return the top element from the main queue (q1)
        return q1.poll();
    }

    public static void main(String[] args) {
        Question3 stack = new Question3();

        stack.push(2);
        stack.push(3);
        System.out.print(stack.pop() + " ");
        stack.push(4);
        System.out.print(stack.pop());
    }
}



