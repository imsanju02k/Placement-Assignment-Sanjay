package corejava.question03;

import java.util.Scanner;

public class ExceptionHandling {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		 try {
			System.out.println("Enter an Integer: ");
			int number=scanner.nextInt();
			if(number<0) {
				throw new IllegalArgumentException("Number cannot be negative");
			}
			System.out.println("Number entered : " + number);
		} catch (IllegalArgumentException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}

	}
}