package lecture10.Recursion;

/*

Given a string, count total number of consonants in it. A consonant is an English alphabet character that is not vowel (a, e, i, o and u). Examples of constants are b, c, d, f, and g.

**Examples :**
*Input : abc de
Output : 3
There are three consonants b, c and d.

Input : geeksforgeeks portal
Output : 12
*/

public class Question8 {
	 public static int countConsonants(String str) {
	        int count = 0;
	        str = str.toLowerCase();
	        
	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            if (ch >= 'a' && ch <= 'z' && !isVowel(ch)) {
	                count++;
	            }
	        }
	        
	        return count;
	    }
	    
	    private static boolean isVowel(char ch) {
	        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	    }
	    
	    public static void main(String[] args) {
	        String str = "geeksforgeeks portal";
	        int consonantCount = countConsonants(str);
	        System.out.println("Total number of consonants: " + consonantCount);
	    }
   
}


