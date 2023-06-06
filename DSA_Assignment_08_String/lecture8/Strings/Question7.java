package lecture8.Strings;

import java.util.Stack;

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

**Example 1:**

**Input:** s = "3[a]2[bc]"

**Output:** "aaabcbc"
*/


public class Question7 {
	 public static String decodeString(String s) {
	        Stack<Integer> countStack = new Stack<>();
	        Stack<StringBuilder> strStack = new Stack<>();
	        StringBuilder currentString = new StringBuilder();
	        int count = 0;

	        for (char c : s.toCharArray()) {
	            if (Character.isDigit(c)) {
	                count = count * 10 + (c - '0');
	            } else if (c == '[') {
	                countStack.push(count);
	                strStack.push(currentString);
	                count = 0;
	                currentString = new StringBuilder();
	            } else if (c == ']') {
	                StringBuilder temp = currentString;
	                currentString = strStack.pop();
	                int repeatCount = countStack.pop();
	                for (int i = 0; i < repeatCount; i++) {
	                    currentString.append(temp);
	                }
	            } else {
	                currentString.append(c);
	            }
	        }

	        return currentString.toString();
	    }

	    public static void main(String[] args) {
	        String s = "3[a]2[bc]";
	        String decodedString = decodeString(s);

	        System.out.println("Decoded String: " + decodedString);
	    }
    
}