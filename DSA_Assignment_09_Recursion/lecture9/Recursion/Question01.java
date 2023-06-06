package lecture9.Recursion;

/*

Given an integer `n`, return *`true` if it is a power of three. Otherwise, return `false`*.

An integer `n` is a power of three, if there exists an integer `x` such that `n == 3x`.

**Example 1:**

```
Input: n = 27
Output: true
Explanation: 27 = 33
```

**Example 2:**

```
Input: n = 0
Output: false
Explanation: There is no x where 3x = 0.

```

**Example 3:**
*Input: n = -1
Output: false
Explanation: There is no x where 3x = (-1).


*/

public class Question01 {

	public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        
        double logValue = Math.log(n) / Math.log(3);
        
        return Math.abs(logValue - Math.round(logValue)) < 1e-10;
    }

    public static void main(String[] args) {
        int n1 = 9;
        int n2 = 27;
        int n3 = 45;

        System.out.println(n1 + " is a power of three: " + isPowerOfThree(n1));
        System.out.println(n2 + " is a power of three: " + isPowerOfThree(n2));
        System.out.println(n3 + " is a power of three: " + isPowerOfThree(n3));
    }
	 
  }



