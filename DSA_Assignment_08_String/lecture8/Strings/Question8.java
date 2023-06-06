package lecture8.Strings;

import java.util.ArrayList;
import java.util.List;

/*

Given two strings s and goal, return true *if you can swap two letters in* s *so the result is equal to* goal*, otherwise, return* false*.*

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

- For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

**Example 1:**

**Input:** s = "ab", goal = "ba"

**Output:** true

**Explanation:** You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
*/

public class Question8 {
	
    public static boolean canSwapLetters(String s, String goal) {
        List<Integer> mismatchIndices = new ArrayList<>();
        List<Character> commonCharacters = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                mismatchIndices.add(i);
            } else {
                commonCharacters.add(s.charAt(i));
            }
        }

        if (mismatchIndices.isEmpty()) {
            return true;
        } else if (mismatchIndices.size() == 2 && s.charAt(mismatchIndices.get(0)) == goal.charAt(mismatchIndices.get(1))
                && s.charAt(mismatchIndices.get(1)) == goal.charAt(mismatchIndices.get(0))) {
            return true;
        } else if (mismatchIndices.size() == 1 && commonCharacters.size() == 1) {
            return false;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "ab";
        String goal = "ba";
        boolean canSwap = canSwapLetters(s, goal);

        System.out.println("Can swap letters: " + canSwap);
    }
	
}


