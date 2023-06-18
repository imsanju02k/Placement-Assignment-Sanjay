package lecture15.statck;

/*


You are given a string S, the task is to reverse the string using stack.
Input: S="GeeksforGeeks"
Output: skeeGrofskeeG
*/

import java.util.*;

public class Question5 {
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        // Push each character of the string onto the stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        StringBuilder reversed = new StringBuilder();

        // Pop each character from the stack and append it to the reversed string
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String str = "GeeksforGeeks";
        String reversedString = reverseString(str);
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversedString);
    }
}
