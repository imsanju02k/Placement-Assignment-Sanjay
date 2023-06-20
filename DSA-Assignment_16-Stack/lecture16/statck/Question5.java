package lecture15.statck;

/*


Given a number , write a program to reverse this number using stack.
Input : 365
Output : 563

Input : 6899
Output : 9986
*/

import java.util.Stack;

public class Question5 {
    public static int reverseNumber(int number) {
        String numberString = Integer.toString(number);
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < numberString.length(); i++) {
            stack.push(numberString.charAt(i));
        }

        StringBuilder reversedNumberBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedNumberBuilder.append(stack.pop());
        }

        String reversedNumberString = reversedNumberBuilder.toString();
        int reversedNumber = Integer.parseInt(reversedNumberString);

        return reversedNumber;
    }

    public static void main(String[] args) {
        int number1 = 365;
        int reversedNumber1 = reverseNumber(number1);
        System.out.println("Input: " + number1);
        System.out.println("Reversed number: " + reversedNumber1);

        int number2 = 6899;
        int reversedNumber2 = reverseNumber(number2);
        System.out.println("Input: " + number2);
        System.out.println("Reversed number: " + reversedNumber2);
    }
}
