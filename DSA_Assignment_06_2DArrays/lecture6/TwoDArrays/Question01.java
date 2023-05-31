package lecture6.TwoDArrays;

/*

A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:

- s[i] == 'I' if perm[i] < perm[i + 1], and
- s[i] == 'D' if perm[i] > perm[i + 1].

Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return **any of them**.

**Example 1:**

**Input:** s = "IDID"

**Output:**

[0,4,1,3,2]


*/

public class Question01 {

   
	 public static int[] findPermutation(String s) {
	        int n = s.length();
	        int[] perm = new int[n + 1];

	        // Initialize the permutation with numbers from 0 to n
	        for (int i = 0; i <= n; i++) {
	            perm[i] = i;
	        }

	        // Process the string s to reconstruct the permutation
	        int left = 0;
	        int right = 0;

	        while (right < n) {
	            if (s.charAt(right) == 'I') {
	                // If 'I' is encountered, reverse the subarray from left to right
	                reverse(perm, left, right + 1);
	            } else {
	                // If 'D' is encountered, move the right pointer
	                right++;
	            }
	            // Move both pointers to the next position
	            left = right;
	            right++;
	        }

	        return perm;
	    }

	    private static void reverse(int[] perm, int left, int right) {
	        while (left < right) {
	            int temp = perm[left];
	            perm[left] = perm[right];
	            perm[right] = temp;
	            left++;
	            right--;
	        }
	    }

	    public static void main(String[] args) {
	        String s = "IDID";

	        int[] perm = findPermutation(s);

	        for (int num : perm) {
	            System.out.print(num + " ");
	        }
	    }
  }



