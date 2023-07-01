import java.util.*;

public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;

        while (right < n) {
            char currentChar = s.charAt(right);
            if (!set.contains(currentChar)) {
                set.add(currentChar);
                maxLength = Math.max(maxLength, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring without repeating characters: " + length);
    }
}
