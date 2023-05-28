package corejava.question04;

import java.util.Scanner;

class bankAccount{
	private double balance;
	
	public bankAccount() {
      balance=0.0;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		if(amount>0) {
			balance+=amount;
			System.out.println("DEPOSITE SUCCESSFULLY. CURRENT BALANCE : " + balance);
		}
		else {
			System.out.println("INVALID AMOUNT.DEPOSIT FAILED TRY AGAIN...");
		}
	}
	
	public void withdraw(double amount) {
		if(amount>0 && amount <= balance) {
			balance -=amount;
			System.out.println("WITHDRAWAL SUCCESSFULLY. CURRENT BALANCE : " +balance);
		}
		else {
			System.out.println("INVALID AMOUT OR INSUFFICIENT BALANCE . WITHDRWAL FAILED.. ");
		}
	}
}


public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		bankAccount account=new bankAccount();
		while(true) {
			System.out.println("1. DEPOSIT");
			System.out.println("2. WITHDRAW");
			System.out.println("3. CHECK BALANCE");
			System.out.println("4. EXIT");
			System.out.println("ENTER YOUR CHOICE :: ");
			
		    int choice=sc.nextInt();
		    
		    switch (choice) {
			case 1:
				System.out.println("Enter the amount to deposit : ");
				double depositeAmount=sc.nextDouble();
				account.deposit(depositeAmount);
				break;
			case 2:
				System.out.println("Enter the amount to withdraw : ");
				double withdrawAmount=sc.nextDouble();
				account.withdraw(withdrawAmount);
				break;
			case 3:
				System.out.println("Current balance: " + account.getBalance());
				break;
			case 4:
				System.out.println("Exiting the program..");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		    System.out.println();
		}
		
	}

}
