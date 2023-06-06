package lecture9.Recursion;


/*
Given a number N and a power P, the task is to find the exponent of this number raised to the given power, i.e. N^P.

**Example 1 :** 

Input: N = 5, P = 2

Output: 25

**Example 2 :**
Input: N = 2, P = 5

Output: 32
*/



public class Question4 {


    public static int calculateExponent(int N, int P) {
        double result = Math.pow(N, P);
        return (int) Math.round(result);
    }

    public static void main(String[] args) {
        int N1 = 5;
        int P1 = 2;
        int N2 = 2;
        int P2 = 5;

        System.out.println(N1 + " raised to the power " + P1 + ": " + calculateExponent(N1, P1));
        System.out.println(N2 + " raised to the power " + P2 + ": " + calculateExponent(N2, P2));
    }
}
