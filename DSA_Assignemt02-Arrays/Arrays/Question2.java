package lecture2.Arrays;

import java.util.HashSet;

/*

Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight, so she visited a doctor. 

The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice. 

Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.

Example 1:
Input: candyType = [1,1,2,2,3,3]
Output: 3

Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type





*/

public class Question2 {
	public static int maxCandies(int[] candyType) {
		int maxTypes=candyType.length/2;
		HashSet<Integer> uniqueType=new HashSet<>();
		
		for(int candy:candyType) {
			uniqueType.add(candy);
			
			if(uniqueType.size()==maxTypes) {
				break;
			}
		}
		return uniqueType.size();
	}
	public static void main(String[] args) {
		int[] candyType = {1, 1, 2, 2, 3, 3};
        int result = maxCandies(candyType);
        System.out.println();
		System.out.println("Alice can eat a maximum of " + result + " different types of candies");
		System.out.println();
		
	}
	

}
