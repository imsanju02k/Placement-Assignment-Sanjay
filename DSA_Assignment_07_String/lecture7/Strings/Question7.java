package lecture7.Strings;

import java.util.Stack;

/*
Given two strings s and t, return true *if they are equal when both are typed into empty text editors*. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

**Example 1:**

**Input:** s = "ab#c", t = "ad#c"

**Output:** true

**Explanation:**

Both s and t become "ac".

*/


public class Question7 {
	 public static boolean backspaceCompare(String s, String t) {
	        String processedS = processString(s);
	        String processedT = processString(t);

	        return processedS.equals(processedT);
	    }

	    private static String processString(String str) {
	        Stack<Character> stack = new Stack<>();

	        for (char ch : str.toCharArray()) {
	            if (ch != '#') {
	                stack.push(ch);
	            } else if (!stack.isEmpty()) {
	                stack.pop();
	            }
	        }

	        StringBuilder sb = new StringBuilder();
	        while (!stack.isEmpty()) {
	            sb.append(stack.pop());
	        }

	        return sb.reverse().toString();
	    }

	    public static void main(String[] args) {
	        String s = "ab#c";
	        String t = "ad#c";
	        boolean isEqual = backspaceCompare(s, t);
	        System.out.println(isEqual);
	    }
	}