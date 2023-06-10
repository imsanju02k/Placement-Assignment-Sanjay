package lecture11.BinarySearch;

/*

<aside>
💡 **Question 1**

Given a non-negative integer `x`, return *the square root of* `x` *rounded down to the nearest integer*. The returned integer should be **non-negative** as well.

You **must not use** any built-in exponent function or operator.

- For example, do not use `pow(x, 0.5)` in c++ or `x ** 0.5` in java.

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

</aside>


*/

public class Question01 {

	public static void main(String[] args) {
        int x = 4;

        int sqrt = mySqrt(x);

        System.out.println(sqrt); // Output: 2
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
	 
  }



