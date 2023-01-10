package BankProgram;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BankAccount {
	String customerName;
	String customerId;
	String accountType;
	int balance=10000;
	int previousTransaction;
	double totalInterest;
	 
	
	void calculateInterest(int balance) {
		System.out.println("What Type of Account do you have 1.Savings 2.Current");
		Scanner sc = new Scanner(System.in);
		int choice=sc.nextInt();
		 
		if(choice==1) {
			accountType="Savings";
			int r = 5;      //rate of interest %
			int t;          //year
			System.out.println("Enter Year to calculate Interest");
			t=sc.nextInt();
			
			double finalAmount= balance*(1+r*t)/100;
			totalInterest = finalAmount - balance;
			System.out.println("Total Interest earned is: " + totalInterest);
		}
		 
		if(choice==2) {
			accountType="Current";
			int r = 8;
			int t,n;
			System.out.println("Enter Year to calculate Interest");
			t=sc.nextInt();
			System.out.println("Enter the Frequency that Interest has been compound in a year");
			n=sc.nextInt();
			
			double finalAmount= balance*(Math.pow((1+r/n), n*t));
			totalInterest= finalAmount - balance;
			System.out.println("Total Interest Earned is :" + totalInterest);
			sc.close();
			
		
		
		
	}
}
	void deposit(int amount) {
		if(amount!=0) {
			balance = balance + amount;
			System.out.println("Balance After Deposit:" + balance);
			previousTransaction = amount;
		}
	}
	void withDraw(int amount) {
		if(amount!=0) {
			balance = balance - amount;
			System.out.println("Balance After Withdraw:" + balance);
			previousTransaction = -amount;
		}
	}
	void getpreviousTransaction() {
		FileOutputStream out;
		 PrintStream p;
		 
		 try {
			 out = new FileOutputStream("c:\\User");
			 p= new PrintStream(out);
			 
			 if(previousTransaction > 0) {
				 p.append("Deposited" + previousTransaction );
				 System.out.println("Deposited\" + previousTransaction");
				 
			 }
			 else if(previousTransaction < 0) {
				 p.append("Withdraw" + previousTransaction );
				 System.out.println("Withdraw" + Math.abs(previousTransaction));
				 
				 
			 }else {
				 System.out.println("No Transaction Occured.");
			 }
			 p.close();
				 
				 
			 
			 
		 }catch(Exception e) {
			 System.out.println("Error in Printing the Data:" + e);
		 }
	}
void showMenu() {
	char option='\0';
	Scanner sc = new Scanner(System.in);
	System.out.println("Welcome to the Menu");
	System.out.println("\n");
	System.out.println("A. Check Balance");
	System.out.println("B. Deposite Amount");
	System.out.println("C. Withdraw Amount");
	System.out.println("D. See Previous Transcation");
	System.out.println("E. Calculate Interest");
	System.out.println("F. Exit");
	
	do {
		System.out.println("-------------------------------");
		System.out.println("Enter an Option:");
		System.out.println("-------------------------------");
		option= sc.next().charAt(0);
		System.out.println("\n");
		
		switch (option) {
		case 'A' :
			System.out.println("-----------------------------");
			System.out.println("Balance is " + balance);
			System.out.println("\n");
			break;
		case 'B':
			System.out.println("------------------------------");
			System.out.println("Enter an Amount to Deposit:");
			int amount = sc.nextInt();
			deposit(amount);
			System.out.println("\n");
			break;
		case 'C':
			System.out.println("--------------------------------");
			System.out.println("Enter an Amount to Withdraw:");
			int amount2 = sc.nextInt();
			withDraw(amount2);
			System.out.println("\n");
			break;
		case 'D':
			System.out.println("----------------------------------");
			getpreviousTransaction();
			System.out.println("\n");
			break;
		case 'E':
			System.out.println("------------------------------------");
			calculateInterest(balance);
			System.out.println("\n");
			break;
		case'F':
			System.out.println("-------------------------------------");
			break;
		default :
			System.out.println("Entered Invalid Option, Try between A to F.");
			break;
		}
	}while(option !='F');
	System.out.println("Thank you For using our service.");
	sc.close();












}

}
