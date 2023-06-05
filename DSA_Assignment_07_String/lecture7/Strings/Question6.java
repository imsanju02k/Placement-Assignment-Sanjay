package lecture7.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Given two strings s and goal, return true *if and only if* s *can become* goal *after some number of **shifts** on* s.

A **shift** on s consists of moving the leftmost character of s to the rightmost position.

- For example, if s = "abcde", then it will be "bcdea" after one shift.

**Example 1:**

**Input:** s = "abcde", goal = "cdeab"

**Output:**

true


*/

public class Question6 {
	public static boolean canTransform(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        String concatenated = s + s;
        return concatenated.contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        boolean canTransform = canTransform(s, goal);
        System.out.println(canTransform);
    }

    
}


