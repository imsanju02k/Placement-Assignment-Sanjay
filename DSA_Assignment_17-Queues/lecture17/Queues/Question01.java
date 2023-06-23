package lecture17.Queues;

/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
Input: s = "leetcode"
Output: 0

*/

public class Question01 {
    public static int firstUniqChar(String s) {
        // Create an array to store the count of each character
        int[] count = new int[26];

        // Iterate through the string and count the occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }

        // Iterate through the string again to find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] == 1) {
                return i;
            }
        }

        // No non-repeating character found
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        int index = firstUniqChar(s);
        System.out.println("Index of the first non-repeating character: " + index);
    }
}
