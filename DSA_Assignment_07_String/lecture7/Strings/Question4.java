package lecture7.Strings;

import java.util.HashMap;
import java.util.Map;

/*

Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

**Example 1:**

**Input:** s = "Let's take LeetCode contest"

**Output:** "s'teL ekat edoCteeL tsetnoc"



*/

public class Question4 {

	 public static String reverseWords(String s) {
	        String[] words = s.split(" ");
	        StringBuilder reversed = new StringBuilder();

	        for (String word : words) {
	            StringBuilder sb = new StringBuilder(word);
	            sb.reverse();
	            reversed.append(sb).append(" ");
	        }

	        return reversed.toString().trim();
	    }

	    public static void main(String[] args) {
	        String s = "Let's take LeetCode contest";
	        String reversed = reverseWords(s);
	        System.out.println(reversed);
	    }
	
}


