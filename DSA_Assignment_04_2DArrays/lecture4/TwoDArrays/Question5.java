package lecture4.TwoDArrays;

/*


💡 You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase **may be** incomplete.

Given the integer n, return *the number of **complete rows** of the staircase you will build*.



**Input:** n = 5

**Output:** 2

**Explanation:** Because the 3rd row is incomplete, we return 2.
*
*time complexity : O(log n)
*space complexity : O(1)

*/

public class Question5 {

	 public static int arrangeCoins(int n) {
	        long left = 0;
	        long right = n;
	        long k;

	        while (left <= right) {
	            k = left + (right - left) / 2;
	            long curr = (k * (k + 1)) / 2;

	            if (curr == n)
	                return (int) k;

	            if (curr < n)
	                left = k + 1;
	            else
	                right = k - 1;
	        }

	        return (int) right;
	    }

	    public static void main(String[] args) {
	        int n = 5;
	        int completeRows = arrangeCoins(n);
	        System.out.println("Number of complete rows: " + completeRows);
	    }
	}


