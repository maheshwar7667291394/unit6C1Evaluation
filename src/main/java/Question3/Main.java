package Question3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		AccountDao acdo=new DaoImplement();
		
		Scanner input=new Scanner(System.in);
		System.out.println("Want to perfor findById(int id) method Enter 1");
		System.out.println("want to perform  save(Account account) method Enter 2");
		System.out.println("want to perform deleteAccountById(int id) method enter 3");
		System.out.println("want to perform withdraw(double amount,int accountId) Enter 4");
		System.out.println("want to perform  deposit(double amount,int accountId) enter 5");
		
		
		
		int sc=input.nextInt();
		switch(sc) {
		case 1:
			System.out.println("enter id");
			int id=input.nextInt();
			Account ac=acdo.findById(id);
			System.out.println(ac);
			break;
			
		case 2:
			System.out.println("Enter Id");
			int id1=input.nextInt();
			
			System.out.println("enter Email");
			String email=input.next();
			
			System.out.println("Enter address");
			String address=input.next();
			
			System.out.println("enter balance:");
			double balance=input.nextDouble();
			
			Account acount=new Account(id1, email, address, balance);
			
			String result=acdo.save(acount);
			System.out.println(result);
			break;
			
		case 3:
			System.out.println("Enter id");
			int id2=input.nextInt();
			String result1=acdo.deleteAccountById(id2);
			System.out.println(result1);
			break;
		case 4:
			System.out.println("Enter amount");
			double amt1=input.nextDouble();
			
			System.out.println("enter accountid");
			int id3=input.nextInt();
			String result3=acdo.withdraw(amt1, id3);
			System.out.println(result3);
			break;
			
		case 5:
			System.out.println("Enter amount");
			double amt2=input.nextDouble();
			
			System.out.println("enter accountid");
			int id4=input.nextInt();
			String result4=acdo.deposit(amt2, id4);
			System.out.println(result4);
			break;
			
			
			
			
			default:
				System.out.println("no operation performed");
			
		}
		
		
		

	}

}
