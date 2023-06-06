package lecture9.Recursion;

/*

Given first term (a), common difference (d) and a integer N of the Arithmetic Progression series, the task is to find Nth term of the series.

**Example 1:**

Input : a = 2 d = 1 N = 5
Output : 6
The 5th term of the series is : 6

**Example 2:**

Input : a = 5 d = 2 N = 10
Output : 23
The 10th term of the series is : 23


*/

public class Question6 {
	
	public static int findNthTerm(int a, int d, int N) {
        return a + (N - 1) * d;
    }

    public static void main(String[] args) {
        int a1 = 2;
        int d1 = 1;
        int N1 = 5;
        int a2 = 5;
        int d2 = 2;
        int N2 = 10;

        int nthTerm1 = findNthTerm(a1, d1, N1);
        int nthTerm2 = findNthTerm(a2, d2, N2);

        System.out.println("The " + N1 + "th term of the series is: " + nthTerm1);
        System.out.println("The " + N2 + "th term of the series is: " + nthTerm2);
    }
    
}


