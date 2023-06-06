package lecture9.Recursion;

import java.util.Stack;

/*
Given a string S, the task is to write a program to print all permutations of a given string.

**Example 1:**

***Input:***

*S = “ABC”*

***Output:***

*“ABC”, “ACB”, “BAC”, “BCA”, “CBA”, “CAB”*

**Example 2:**

***Input:***

*S = “XY”*

***Output:***

*“XY”, “YX”*
*/


public class Question7 {
    public static void permute(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
        } else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i);
                permute(str, start + 1, end);
                str = swap(str, start, i);
            }
        }
    }

    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String S1 = "ABC";
        String S2 = "XY";

        System.out.println("Permutations of " + S1 + ":");
        permute(S1, 0, S1.length() - 1);

        System.out.println("Permutations of " + S2 + ":");
        permute(S2, 0, S2.length() - 1);
    }
}