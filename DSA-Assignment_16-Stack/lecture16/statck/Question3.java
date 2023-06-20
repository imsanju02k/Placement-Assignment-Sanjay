package lecture15.statck;
/*
 *
Given a stack with **push()**, **pop()**, and **empty()** operations, The task is to delete the **middle** element ****of it without using any additional data structure.

Input  : Stack[] = [1, 2, 3, 4, 5]

Output : Stack[] = [1, 2, 4, 5]

Input  : Stack[] = [1, 2, 3, 4, 5, 6]

Output : Stack[] = [1, 2, 4, 5, 6]
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

import java.util.Stack;

public class Question3 {
    private static int count = 0;

    public static Stack<Integer> deleteMiddle(Stack<Integer> stack) {
        if (stack.isEmpty() || stack.size() == 1) {
            return stack;
        }

        int mid = stack.pop();
        stack = deleteMiddle(stack);

        if (count != stack.size()) {
            stack.push(mid);
        }

        count++;
        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        System.out.println("Input stack: " + stack1);
        Stack<Integer> modifiedStack1 = deleteMiddle(stack1);
        System.out.println("Modified stack: " + modifiedStack1);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        stack2.push(6);
        System.out.println("Input stack: " + stack2);
        Stack<Integer> modifiedStack2 = deleteMiddle(stack2);
        System.out.println("Modified stack: " + modifiedStack2);
    }
}
