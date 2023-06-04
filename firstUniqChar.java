import java.util.HashMap;

public class Main {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Update the count of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println(firstUniqChar(s1)); // Output: 0

       
    }
}
