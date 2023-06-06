package lecture10.Recursion;

/*


We are given a string S, we need to find count of all contiguous substrings starting and ending with same character.
Input  : S = "abcab"
Output : 7
There are 15 substrings of "abcab"
a, ab, abc, abca, abcab, b, bc, bca
bcab, c, ca, cab, a, ab, b
Out of the above substrings, there
are 7 substrings : a, abca, b, bcab,
c, a and b.

Input  : S = "aba"
Output : 4
The substrings are a, b, a and aba
*/

public class Question5 {
	 public static int countSubstringsWithSameEnds(String s) {
	        int n = s.length();
	        int count = 0;

	        for (int i = 0; i < n; i++) {
	            char c = s.charAt(i);
	            int j = i;
	            while (j < n && s.charAt(j) == c) {
	                j++;
	            }
	            count += j - i;
	        }

	        return count;
	    }

	    public static void main(String[] args) {
	        String s = "abcab";
	        System.out.println(countSubstringsWithSameEnds(s)); // Output: 7

	        s = "aba";
	        System.out.println(countSubstringsWithSameEnds(s)); // Output: 4
	    }
}



