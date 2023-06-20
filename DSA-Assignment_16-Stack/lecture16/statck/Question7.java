package lecture15.statck;

/*
Given a sequence of n strings, the task is to check if any two similar words come together and then destroy each other then print the number of words left in the sequence after this pairwise destruction.

**Examples:**

Input : ab aa aa bcd ab

Output : 3

*As aa, aa destroys each other so,*

*ab bcd ab is the new sequence.*

Input :  tom jerry jerry tom

Output : 0

*As first both jerry will destroy each other.*

*Then sequence will be tom, tom they will also destroy*

*each other. So, the final sequence doesn’t contain any*

*word.*
*/



import java.util.Stack;

public class Question7 {
    public static int countRemainingWords(String[] words) {
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            if (!stack.isEmpty() && stack.peek().equals(word)) {
                stack.pop();
            } else {
                stack.push(word);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        String[] sequence1 = {"ab", "aa", "aa", "bcd", "ab"};
        int remainingWords1 = countRemainingWords(sequence1);
        System.out.println("Input sequence: ab aa aa bcd ab");
        System.out.println("Number of words left: " + remainingWords1);

        String[] sequence2 = {"tom", "jerry", "jerry", "tom"};
        int remainingWords2 = countRemainingWords(sequence2);
        System.out.println("Input sequence: tom jerry jerry tom");
        System.out.println("Number of words left: " + remainingWords2);
    }
}

