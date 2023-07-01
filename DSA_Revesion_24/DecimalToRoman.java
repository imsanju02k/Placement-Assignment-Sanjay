import java.util.*;

public class DecimalToRoman {
    public static String intToRoman(int num) {
        int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        int index = 0;

        while (num > 0) {
            while (num >= decimalValues[index]) {
                result.append(romanSymbols[index]);
                num -= decimalValues[index];
            }
            index++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int num = 27;
        String romanNumeral = intToRoman(num);
        System.out.println("Roman numeral representation of " + num + " is: " + romanNumeral);
    }
}
