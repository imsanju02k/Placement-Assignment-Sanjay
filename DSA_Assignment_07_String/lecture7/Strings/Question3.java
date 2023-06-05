package lecture7.Strings;

/*
 *

Given two non-negative integers, num1 and num2 represented as string, return *the sum of* num1 *and* num2 *as a string*.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

**Example 1:**

**Input:** num1 = "11", num2 = "123"

**Output:**

"134"


*/

public class Question3 {
	public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;

        while (p1 >= 0 || p2 >= 0 || carry != 0) {
            int digit1 = (p1 >= 0) ? num1.charAt(p1) - '0' : 0;
            int digit2 = (p2 >= 0) ? num2.charAt(p2) - '0' : 0;
            int currentSum = digit1 + digit2 + carry;

            result.append(currentSum % 10);
            carry = currentSum / 10;

            p1--;
            p2--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";

        String sum = addStrings(num1, num2);
        System.out.println(sum);
    }
}


