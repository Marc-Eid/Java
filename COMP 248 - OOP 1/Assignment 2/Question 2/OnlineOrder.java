// -----------------------------------------------------------------------------------------------------------------------
// Assignment #2 Question 1
// Written by: Marc Eid
// For COMP 248 section A - Winter 2021
// -----------------------------------------------------------------------------------------------------------------------
// The purpose of this program is to help the customer order food online and calculate the total price.

import java.util.Scanner;
public class OnlineOrder {

	public static void main(String[] args) {
		
		//declaring the scanner
		Scanner keyIn = new Scanner(System.in);
				
				
		//this is to print the welcome message
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.printf( " %34s","Welcome to Online Order Program!");
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//this is to print out the menu, formatted
		System.out.printf("%16s", "1. Hamburger");
		System.out.printf("%n%12s", "2. Pizza");
		System.out.printf("%n%13s", "3. Noodle");
		System.out.printf("%n%12s", "4. Salad");
		System.out.printf("%n%15s", "5. Sandwich");
		System.out.printf("%n%11s", "6. Exit");
		
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		
		//delaring variables. price is the price of the food without any topping. asnwer2 is to see if they want to order again
		int choice;
		double price = 0;
		String answer2;
		String food = "";
		double toppingPrice = 0.0;
		double totalPrice = 0.0;
		String topping = "";
		double deliveryFee;
		
		//this do-while loop serves to execute the loop body and then repeat the question again if the client wants to order more food
		do
		{
			
		//this do-while loop is to verify user input
		do
		{
			System.out.print("\nPlease enter you choice (1-6): ");
			choice = keyIn.nextInt();	
			
			switch (choice)
			{
				case 1: 
					food = "Hamburger";
					price = 7.5;
					break;
		
				case 2:
					food = "Pizza";
					price = 7.5;
					break;
				case 3: 
					food = "Noodle";
					price = 7.5;
					break;
				case 4:
					food = "Salad";
					price = 7.5;
					break;
				case 5: 
					food = "Sandwich";
					price = 7.5;
					break;
				case 6:
					food = "Finish the Order!";
					price = 0.0;
					break;
				
			}
			if (choice < 1 || choice > 6)
				System.out.print("\nThat is a wrong input. Please try again!");
		
			
		}
		while(choice < 1 || choice > 6);
		
		
		//print out the food that was picked
		System.out.println("\nYour choice is: " + food + ".");
		
		//if the user enters 6, the do-while loop terminates, to not ask for topping and to not ask if they need more food
		if(choice == 6 )
			break;
		
		//ask user and store their answer for the topping
		String answer1;
		System.out.print("would you like to have some meat on your " + food + "?(yes/no) ");
		answer1 = keyIn.next();
		
		
		
		//ask the user if they want beef or pork as topping if they said yes for the previous question 	
		switch(answer1.toLowerCase())
		{
		case "no": 
			break;
		
		case "yes":
		    System.out.print("\nBeef or Pork? ");
			topping = keyIn.next();
			break;
		
		}
		
		//this switch statement is to determine the price of the topping
		switch (topping.toLowerCase())
		{
		
		case "beef":
			toppingPrice = 18;
			break;
		case "pork":
			toppingPrice = 10;
			break;
		
		}
		
		//ask the user if they want more food, store the result in asnwer2 is the asnwer is yes then the loop body will repeat again
		System.out.print("\nWould you like to have more food? ");
		answer2 = keyIn.next();
		
		//calculate the total price by adding the price of the food and the topping price. each time the loop is repeated, the new price is added to the old price
		totalPrice = totalPrice + price + toppingPrice;
		
		}
		while(answer2.equalsIgnoreCase("yes"));	
		
		
		
		
		
		
		
	
		//determine the delivery fee
		if ( totalPrice > 50 || totalPrice == 0)
		{
			System.out.println("\nNo need to pay the delivery fee.");
			deliveryFee = 0.0;
		}
		else
		{
			deliveryFee = 5.0;
			System.out.println("\nThe total price is less than $50. You need to pay the delivery fee $5.");
		}
		
		
		//ask if they would like to add tips
		double tips = 0.0;
		//if the price is 0 then we dont ask for tips because the user didnt order anything
		if(price != 0)
		{
			System.out.print("\nWould you like to enter some tips? Please enter amount: ");
			tips = keyIn.nextDouble();		
		}
		
		//calculate total price adding the delivery and the tips
		totalPrice = totalPrice  + deliveryFee + tips;
		
		//print out the total price 
		System.out.println("\nThe total price is $" + totalPrice + ".");
		//print out the closing message
		System.out.print("\nThank you for using Online Order Program!");
		
		keyIn.close();
	}
}
