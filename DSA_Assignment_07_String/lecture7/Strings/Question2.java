package lecture7.Strings;

/*
Given a string num which represents an integer, return true *if* num *is a **strobogrammatic number***.

A **strobogrammatic number** is a number that looks the same when rotated 180 degrees (looked at upside down).

**Example 1:**

**Input:** num = "69"

**Output:**

true
*/

public class Question2 {
	 public static boolean isStrobogrammatic(String num) {
	        int start = 0;
	        int end = num.length() - 1;

	        while (start <= end) {
	            char startChar = num.charAt(start);
	            char endChar = num.charAt(end);

	            if (!isValidStrobogrammaticPair(startChar, endChar)) {
	                return false;
	            }

	            start++;
	            end--;
	        }

	        return true;
	    }

	    private static boolean isValidStrobogrammaticPair(char startChar, char endChar) {
	        return (startChar == '0' && endChar == '0') ||
	                (startChar == '1' && endChar == '1') ||
	                (startChar == '6' && endChar == '9') ||
	                (startChar == '8' && endChar == '8') ||
	                (startChar == '9' && endChar == '6');
	    }

	    public static void main(String[] args) {
	        String num = "69";
	        boolean isStrobogrammatic = isStrobogrammatic(num);
	        System.out.println(isStrobogrammatic);
	    }
}


