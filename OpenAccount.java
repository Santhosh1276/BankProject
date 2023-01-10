package BankProgram;

import java.util.*;

public class OpenAccount {
	String name;
	String dob;
	int accountNumber;
	String accountType;
	
	
	
	void createAccount() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Name :");
		name=sc.nextLine();

		System.out.println("What Type of Account  you want to open: 1.Savings 2.Current");
		int choice=sc.nextInt();
		System.out.println("Enter your DOB: dd-mm-yyyy");
    	dob = sc.nextLine();
    	

		
		if(choice==1) {
			accountType="Savings Account";
		}

		if(choice==2) {
			accountType="Current Account";
		}
		
		System.out.println("---Your Account has been created--- ");

		System.out.println("Name:" + name);
		System.out.println("D.O.B:" + dob);
		System.out.println("Account Type:" + accountType);
		System.out.println("Account Number:" + Math.random());
		System.out.println("\n");
		
		BankAccount obj1=new BankAccount();
		obj1.showMenu();
		sc.close();
		
	}

}
