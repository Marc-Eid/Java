// -----------------------------------------------------------------------------------------------------------------------
// Assignment #1 Question 1
// Written by: Marc Eid 40153034
// For COMP 248 section A - Winter 2021
// -----------------------------------------------------------------------------------------------------------------------

import java.util.Scanner; // we need to import this class

public class FirstAssignment {

	
	public static void main(String[] args) {
		
		//declaring the Scanner
		Scanner password = new Scanner(System.in);
		
		//this is to print the welcome message
		System.out.println("********************************************");
		System.out.printf( " %42s","Welcome to Password Encryption Program");
		System.out.println("\n********************************************");
		
		
		//this is to prompt the user to enter the password, and read the input
		System.out.print("\nPlease enter a 6-digits number: ");
		//read the user input
		final String PASSCODE = password.next();
		
		//transform string entries to single integer entries
		int firstDigit = Integer.parseInt(PASSCODE.substring(0,1));
		int secondDigit = Integer.parseInt(PASSCODE.substring(1,2));
		int thirdDigit = Integer.parseInt(PASSCODE.substring(2,3));
		int fourthDigit = Integer.parseInt(PASSCODE.substring(3,4));
		int fifthDigit = Integer.parseInt(PASSCODE.substring(4,5));
		int sixthDigit = Integer.parseInt(PASSCODE.substring(5,6));
		
		//swap 1st and 6th digits, using the swap1And6 variable to store the initial value of the first digit
		int swap1And6 = firstDigit;
		firstDigit = sixthDigit;
		sixthDigit = swap1And6;
		
		//replace the second digit with the remainder of the second digit divided by 2
		secondDigit = secondDigit % 2;
		
		//Add 1 to the third digit and check that it is not 10
		int thirdDigitManipulated = (thirdDigit + 1) % 10;
		
		//replace the fourth digit with the remainder of the third digit divided by 3
		fourthDigit = thirdDigit % 3;
		
		//swap the 4th and 5th digits using swap4And5 to store the initial value of the fourth digit
		int swap4And5 = fourthDigit;
		fourthDigit = fifthDigit;
		fifthDigit = swap4And5;
		//print the encrypted message
		System.out.println("\nGeneraing the encrypted number...");
		System.out.println("\nThe encrypted 6-digits number is: " + firstDigit +"" +secondDigit + 
													thirdDigitManipulated + fourthDigit + fifthDigit + sixthDigit);
		
		//display a farewell message
		System.out.println("\nThank you for using the Password Encryption Program!");
		
		//close the Scanner
		password.close();
	}

}
