package lecture15.statck;


/*
You are given a stack St. You have to reverse the stack using recursion.
Input:St = {3,2,1,7,6}
Output:{6,7,1,2,3}
*/



import java.util.*;

public class Question4 {
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int element = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, element);
    }

    public static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, element);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(7);
        stack.push(6);

        System.out.println("Original Stack: " + stack);
        reverseStack(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}

