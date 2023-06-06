package lecture8.Strings;

import java.util.Stack;

/*
Given a string s containing only three types of characters: '(', ')' and '*', return true *if* s *is **valid***.

The following rules define a **valid** string:

- Any left parenthesis '(' must have a corresponding right parenthesis ')'.
- Any right parenthesis ')' must have a corresponding left parenthesis '('.
- Left parenthesis '(' must go before the corresponding right parenthesis ')'.
- '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

**Example 1:**

**Input:** s = "()"

**Output:**

true
*/

public class Question2 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '*') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else if (!stack.isEmpty() && stack.peek() == '*') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        int leftCount = 0;
        int starCount = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                leftCount++;
            } else if (stack.peek() == '*') {
                starCount++;
            }
            stack.pop();
        }

        return leftCount <= starCount;
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s)); // Output: true
    }
	 
}


