package lecture9.Recursion;

/*
Given a number n, find the sum of the first natural numbers.

**Example 1:**

Input: n = 3 

Output: 6

**Example 2:**

Input  : 5 

Output : 15
*/

public class Question2 {
	 public static int sumOfNaturals(int n) {
	        int sum = (n * (n + 1)) / 2;
	        return sum;
	    }

	    public static void main(String[] args) {
	        int n1 = 3;
	        int n2 = 5;

	        System.out.println("Sum of the first " + n1 + " natural numbers: " + sumOfNaturals(n1));
	        System.out.println("Sum of the first " + n2 + " natural numbers: " + sumOfNaturals(n2));
	    }
	 
}


