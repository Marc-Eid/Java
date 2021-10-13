// -----------------------------------------------------------------------------------------------------------------------
// Assignment 1 Question 2
// Written by: Marc eid 40153034
// For COMP 248 Section A - Winter 2021
// -----------------------------------------------------------------------------------------------------------------------
import java.util.Scanner; // we need to import this class

public class SecondQuestion {

	public static void main(String[] args) {
		
		//declaring the Scanner
		Scanner words = new Scanner(System.in);
		
		//this is to print the welcome message
		System.out.println("***********************************************");
		System.out.printf( " %38s","Welcome to Letter Encryption Program");
		System.out.println("\n***********************************************");
		
		//prompt the user to enter the first word
		System.out.print("\nEnter the first word with 3 characters: ");
		//read the user input
		String word1 = words.next();
		//prompt the user to enter the second word
		System.out.print("\nEnter the second word with 3 characters: ");
		//read the user input
		String word2 = words.next();
		
		//display the length of the two words
		System.out.println("\nThe length of the word " + word1 + " is " + word1.length());
		System.out.println("The length of the word " + word2 + " is " + word2.length());
		
		//manipulate the words using substring method
		String newWord1 = word1.substring(2,3) + word2.substring(2,3) + word1.substring(0,1) + 
				word2.substring(0,1) + word1.substring(1,2) + word2.substring(1,2);
		
		//display the first encrypted word
		System.out.println("\nThe encrypted word is: " + newWord1 + ".");
		
		System.out.println("\nGenerating the encrypted word...");
		
		//manipulate to produce the second encrypted word
		String newWord2 = newWord1.substring(0,1) + newWord1.substring(5,6) + newWord1.substring(2,5) 
																							+ newWord1.substring(1,2);
		
		String newWord3 = newWord2.substring(4,5) + newWord2.substring(1,4) + newWord2.substring(0,1) +
																							newWord2.substring(5,6); 
		//print on the screen the new word
		System.out.println("\nThe encrypted word is: " + newWord3 + ".");
		//print the thank you message
		System.out.println("\nThank you for using Letter Encryption Program!");
		
		//close the Scanner
		words.close();
	}

}
