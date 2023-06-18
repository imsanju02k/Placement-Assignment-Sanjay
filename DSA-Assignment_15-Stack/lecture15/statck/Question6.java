package lecture15.statck;

/*

Given string S representing a postfix expression, the task is to evaluate the expression and find the final value. Operators will only include the basic arithmetic operators like *, /, + and -.
Input: S = "231*+9-"
Output: -4
Explanation:
After solving the given expression,
we have -4 as result.


*/

import java.util.*;

public class Question6 {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(ch, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static int performOperation(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String expression = "123+*8-";
        int result = evaluatePostfix(expression);
        System.out.println("Expression: " + expression);
        System.out.println("Result: " + result);
    }
}


