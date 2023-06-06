package lecture10.Recursion;

import java.util.ArrayList;
import java.util.List;

/*
Given a string **str**, the task is to print all the permutations of **str**. A **permutation** is an arrangement of all or part of a set of objects, with regard to the order of the arrangement. For instance, the words ‘bat’ and ‘tab’ represents two distinct permutation (or arrangements) of a similar three letter word.

**Examples:**

> Input: str = “cd”
> 
> 
> **Output:** cd dc
> 
> **Input:** str = “abb”
> 
> **Output:** abb abb bab bba bab bba
>
*/


public class Question7 {
	
    public static void printPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        backtrack(permutations, str.toCharArray(), 0);
        
        for (String permutation : permutations) {
            System.out.print(permutation + " ");
        }
    }
    
    private static void backtrack(List<String> permutations, char[] chars, int start) {
        if (start == chars.length - 1) {
            permutations.add(new String(chars));
            return;
        }
        
        for (int i = start; i < chars.length; i++) {
            swap(chars, start, i);
            backtrack(permutations, chars, start + 1);
            swap(chars, start, i);
        }
    }
    
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    
    public static void main(String[] args) {
        String str = "abb";
        printPermutations(str);
    }
	
	
	
	
} 
