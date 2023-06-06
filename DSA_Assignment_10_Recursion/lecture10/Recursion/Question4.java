package lecture10.Recursion;


/*
Given a string calculate length of the string using recursion.

**Examples:**
*Input : str = "abcd"
Output :4

Input : str = "GEEKSFORGEEKS"
Output :13
*/



public class Question4 {

	public static int calculateLength(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        return 1 + calculateLength(str.substring(1));
    }

    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        int length = calculateLength(str);
        System.out.println("Length of the string: " + length);
    }
   
}
