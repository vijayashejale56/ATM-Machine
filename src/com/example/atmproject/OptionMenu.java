package com.example.atmproject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account{
	
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
	
	public void getLogin() throws IOException{
		int x = 1;
		do {
			try {
				data.put(54321, 9876);
				data.put(12345, 6789);
				
				System.out.println("Welcome to the ATM");
				
				System.out.println("Enter your customer number: ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter your PIN Number: ");
				setPinNumber(menuInput.nextInt());
				
			}
			catch(Exception e) {
				System.out.println("Invalid character");
				x = 2;
			}
			int cn = getCustomerNumber();
			int pn = getPinNumber();
			
			if(data.containsKey(cn) && data.get(cn) == pn) {
				getAccountType();
			}
			else {
				System.out.println("Wrong customer number or pin");
			}
			
		} while(x == 1);
	}
	
	public void getAccountType() {
		System.out.println("Select the account you want to access: ");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Saving Account");
		System.out.println("Type 3 - Exit");
		System.out.println("Choice: ");
		
		int selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			getChecking();
			break;
		case 2:
			getSaving();
			break;
		case 3:
			System.out.println("Thank you for using this ATM. Bye Visit Again!!");
			break;
		default:
			System.out.println("Invalid choice");
		}
	}
	
	public void getChecking() {
		System.out.println("Checking Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - deposite funds");
		System.out.println("Type 4 - Exit");
		
		int selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		case 4: 
			System.out.println("Thank you for using this ATM. bye visit again!!");
			break;
		default:
			System.out.println("Invalid choice");
		}
			
	}
	
	public void getSaving() {
		System.out.println("Checking Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - deposite funds");
		System.out.println("Type 4 - Exit");
		
		int selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Checking Account Balance: " + moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
		case 4: 
			System.out.println("Thank you for using this ATM. bye visit again!!");
			break;
		default:
			System.out.println("Invalid choice");
		}
	}
	
	
	
}
