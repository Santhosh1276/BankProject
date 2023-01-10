package BankProgram;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("---------Welcome To National Banking System--------");
		System.out.println("\n");
		System.out.println("Do you want to open an account yes/No");
		Scanner sc = new Scanner(System.in);
		String choice=sc.nextLine();
		
		if(choice.equals("yes")) {
			OpenAccount obj =new OpenAccount();
			obj.createAccount();
			
		}
		if(choice.equals("No")) {
			BankAccount obj1 =new BankAccount();
			obj1.showMenu();
			
		}

	}

}
