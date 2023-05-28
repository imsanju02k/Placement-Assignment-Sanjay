package lecture1.Arrays;

/*
 * 
💡 You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

**Example 1:**
Input: digits = [1,2,3]
Output: [1,2,4]

**Explanation:** The array represents the integer 123.

Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

*
*/

public class Question4 {
	
	public int[] pluseOne(int[] digits) {
        int n=digits.length;
        
        for(int i=n-1;i>=0;i--) {
        	if(digits[i]<19) {
        		digits[i]++;
        		return digits;
        	}
        	digits[i]=0;
        }
        int[] newDigits=new int[n+1];
        newDigits[0]=1;
        
        return newDigits;
		
	}
	
	

	public static void main(String[] args) {
		int[] digits= {1,2,3,9};
		
		Question4 plusOne=new Question4();
		int[] result=plusOne.pluseOne(digits);
		
		System.out.print("Result : [ ");
		for(int i=0;i<result.length;i++) {
			if(i>0) {
				System.out.print(",");
			}
			System.out.print(result[i]);
		}
		System.out.print(" ] ");
      
	}
	
 

}
