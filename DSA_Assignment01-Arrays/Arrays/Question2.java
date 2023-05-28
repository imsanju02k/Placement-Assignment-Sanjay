package lecture1.Arrays;

/*
<aside>
💡 Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

- Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
- Return k.

**Example :**
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_*,_*]

</aside>*/

public class Question2 {
	
	public int removeElement(int [] nums,int val) {
		
		int k=0;
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=val) {
				nums[k]=nums[i];
				k++;
			}
		}
		
		return k;
		
	}
	
	

	public static void main(String[] args) {
       int[] nums= {3, 2, 2, 3};
       int val=3;
       
       Question2 removeElement= new Question2();
       int k=removeElement.removeElement(nums, val);
       System.out.println("k : " +k);
       System.out.print("Nums : [ ");
       for(int i=0;i<k;i++) {
    	   if(i>0) {
    		   System.out.print(",");
    	   }
    	   System.out.print(nums[i]);
       }
       System.out.print(" ] ");
       
	   System.out.println("The time complexity of this solution is O(n), where n is the length of the input array nums.");
	}
	
 

}
