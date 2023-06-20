package lecture15.statck;

/*
Given a stack of integers, sort it in ascending order using another temporary stack.

Input : [34, 3, 31, 98, 92, 23]
Output : [3, 23, 31, 34, 92, 98]

Input : [3, 5, 1, 4, 2, 8]
Output : [1, 2, 3, 4, 5, 8]

*/



import java.util.Stack;

public class Question2 {
	public static Stack<Integer> sortStack(Stack<Integer> inputStack) {
	    Stack<Integer> tempStack = new Stack<>();

	    while (!inputStack.isEmpty()) {
	        int temp = inputStack.pop();

	        while (!tempStack.isEmpty() && tempStack.peek() < temp) {
	            inputStack.push(tempStack.pop());
	        }

	        tempStack.push(temp);
	    }

	    return tempStack;
	}


    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(34);
        stack1.push(3);
        stack1.push(31);
        stack1.push(98);
        stack1.push(92);
        stack1.push(23);
        System.out.println("Input stack: " + stack1);
        Stack<Integer> sortedStack1 = sortStack(stack1);
        System.out.println("Sorted stack: " + sortedStack1);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(3);
        stack2.push(5);
        stack2.push(1);
        stack2.push(4);
        stack2.push(2);
        stack2.push(8);
        System.out.println("Input stack: " + stack2);
        Stack<Integer> sortedStack2 = sortStack(stack2);
        System.out.println("Sorted stack: " + sortedStack2);
    }
}
