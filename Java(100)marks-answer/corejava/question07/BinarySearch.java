package corejava.question07;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	
	
		public static int binarySearch(int [] array,int target) {
			int left=0;
			int right=array.length-1;
			
			while (left<=right) {
				int mid=left+(right-left)/2;
				
				if(array[mid]==target) {
					return mid;
				}else if(array[mid]<target) {
					left=mid+1;
				}else {
					right=mid-1;
				}
			}
			return -1;
		}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the size of the array : ");
		int size=sc.nextInt();
		
		int [] array=new int[size];
		
		System.out.println("Enter the element of the array :");
		for(int i=0;i<size;i++) {
			array[i]=sc.nextInt();
		}
		System.out.println("Enter the target value : ");
		int target=sc.nextInt();
		
		sc.close();
		
		Arrays.sort(array);
		
        
		int index=binarySearch(array,target);
		
		if(index!=-1) {
			System.out.println("Target value found at index : " + index);
		}
		else {
			System.out.println("Target value not found in the array..");
		}
		
	}
	
	
}


