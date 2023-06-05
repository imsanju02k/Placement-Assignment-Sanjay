package lecture7.Strings;

/*


Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

**Example 1:**

**Input:** s = "abcdefg", k = 2

**Output:**

"bacdfeg"

*/

public class Question5 {

	public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int start = 0;

        while (start < chars.length) {
            int end = Math.min(start + k - 1, chars.length - 1);
            reverseSection(chars, start, end);
            start += 2 * k;
        }

        return new String(chars);
    }

    private static void reverseSection(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String reversed = reverseStr(s, k);
        System.out.println(reversed);
    }
	}


