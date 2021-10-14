// -----------------------------------------------------------------------------------------------------------------------
// Assignment #2 Question 1
// Written by: Marc Eid 40153034
// For COMP 248 section A - Winter 2021
// -----------------------------------------------------------------------------------------------------------------------
// The purpose of this program is to estimate the letter grade based on Concordia undergraduate grading system.

import java.util.Scanner;
public class GradingSystem {

	public static void main(String[] args) {
		
		//declaring the scanner
		Scanner keyIn = new Scanner(System.in);
		
		
		//this is to print the welcome message
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.printf( " %36s","Welcome to Grading System Program!");
		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++");
		
		//declare name, id, score, and seven_digit_id, and junk
		String name;
		int id;
		double score;
		String seven_digit_id;
		String exit;
		String junk;
		
		
		//this do-while loop is to execute the whole program and then ask the user if they want to repeat it again
		do
		{
		
			
		//do-while statement to verify user input and store in name
		do
		{
		System.out.print("\nPlease enter your name (Lastname, Firstname seperated by comma): ");
		name = keyIn.nextLine();
		}
		
		while ( name.indexOf(" ") == -1   ||  name.substring( name.indexOf(" ") - 1 , name.indexOf(' ') ).compareTo("," ) != 0);
		
		 
		
		
		//do-while loop to verify id is 7 digits and store value in id. the seven_digit_id is to transform the id into a string so we can measure the length
		do
		{
			System.out.print("\nPlease enter your ID without any spaces (7 digits): ");
			id= keyIn.nextInt();
			seven_digit_id = "" + id;
			
		}
		while(seven_digit_id.length() != 7);
		
		
		
		//do-while loop to prompt the user for score, verify that score is between 0 and 100, and if so, store the value in score
		do
		{
			System.out.print("\nPlease enter your score (0-100): ");
			score = keyIn.nextDouble();
			
		}
		while(score<0 || score>100);
		
		
		
		//make the name appear as first and then last name
		String firstName = name.substring(name.indexOf(" ") + 1 );
		String lastName = name.substring(0, name.indexOf(","));
		String firstAndLastName = name.substring(name.indexOf(" ") + 1 ) + " " + name.substring(0, name.indexOf(","));
		
		
		//print out firstAndLastName and their score.
		System.out.println("\n" +firstAndLastName + " got " + score + ".");
		
		
		//declare letterGrade and gradeMessage
		String letterGrade;
		String gradeMessage;
		
		//if-else to determine letterGrade and gradeMessage
		if (score >=80)
		{
			letterGrade = "A";
			gradeMessage = "Congratulations!";
		}else if (score >=70)
		{
			letterGrade = "B";
			gradeMessage = "You are so close to A!";
			
		}else if(score >=60)
		{
			letterGrade = "C";
			gradeMessage = "You can do better by more practice!";
		}else 
		{
			letterGrade = "FNS";
			gradeMessage = "Please work harder to pass the course!";
		}
			
		//to print out the letterGrade and gradeMessage
		System.out.println("\nBased on the grading system, " + firstName + " (" + id + ") will probably get " + letterGrade + "! " + gradeMessage );
		
		//ask user if they want to exit the program
		System.out.print("\nExit the program?(enter yes to exit): ");
		exit = keyIn.next();
		
		//this is to get rid of the enter after the exit is entered, so the next time the loop is repeated the name wont read the enter
		junk = keyIn.nextLine();
		
		}
		while (!exit.equalsIgnoreCase("yes"));
		
		//print out closing message
		System.out.println("\nThank you for using Grading System Program!");
		
		keyIn.close();
	}

}
