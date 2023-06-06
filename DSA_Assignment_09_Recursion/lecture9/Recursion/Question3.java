package lecture9.Recursion;

/*
 *

Given a positive integer, N. Find the factorial of N. 

**Example 1:**

Input: N = 5 

Output: 120

**Example 2:**

Input: N = 4

Output: 24


*/

public class Question3 {
	public static int factorial(int N) {
        int factorial = 1;

        for (int i = 1; i <= N; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static void main(String[] args) {
        int N1 = 5;
        int N2 = 4;

        System.out.println("Factorial of " + N1 + ": " + factorial(N1));
        System.out.println("Factorial of " + N2 + ": " + factorial(N2));
    }
}


