package lecture8.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Given two strings s and p, return *an array of all the start indices of* p*'s anagrams in* s. You may return the answer in **any order**.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example 1:**

**Input:** s = "cbaebabacd", p = "abc"

**Output:** [0,6]

**Explanation:**

The substring with start index = 0 is "cba", which is an anagram of "abc".

The substring with start index = 6 is "bac", which is an anagram of "abc".


*/

public class Question6 {
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) {
            return result;
        }

        Map<Character, Integer> pFreq = new HashMap<>();
        Map<Character, Integer> sFreq = new HashMap<>();

        // Initialize pFreq with the frequencies of characters in p
        for (char c : p.toCharArray()) {
            pFreq.put(c, pFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;

        while (right < sLen) {
            char rightChar = s.charAt(right);
            sFreq.put(rightChar, sFreq.getOrDefault(rightChar, 0) + 1);

            if (right - left + 1 > pLen) {
                char leftChar = s.charAt(left);
                sFreq.put(leftChar, sFreq.get(leftChar) - 1);
                if (sFreq.get(leftChar) == 0) {
                    sFreq.remove(leftChar);
                }
                left++;
            }

            if (sFreq.equals(pFreq)) {
                result.add(left);
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagramIndices = findAnagrams(s, p);

        System.out.println("Anagram Indices: " + anagramIndices);
    }
	

    
}


