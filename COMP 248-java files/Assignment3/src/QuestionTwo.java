// -----------------------------------------------------------------------------------------------------------------------
// Assignment #3 Question 2
// Written by: Marc Eid 40153034
// For COMP 248 section A - Winter 2021
// -----------------------------------------------------------------------------------------------------------------------
/* 
The purpose of this program is to write a java code that assigns a new value for pixels in a specific range. 
The goal of this is to perform basic compression on an image.
*/
import java.util.Scanner;

public class QuestionTwo {

	public static void main(String[] args) {
		
		//this is to print the welcome message
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.printf( " %34s","Welcome to the Image Quantization Program!");
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
		
		//declare the scanner object to read user input.
		Scanner key = new Scanner(System.in);
		
		//declaring the array that will hold the user inputs
		int[] values = new int[10];
		
		//prompt the user to input values
		System.out.println("\nPlease input pixel values : ");
		
		//the for loop will prompt the user to enter the 10 different values and will store each value in its respective place in the array
		for(int i = 0 ; i < values.length ; i++)
		{	
			System.out.print("pixel " + (i+1) + " : ");
			values[i] = key.nextInt();
		}
		
		
		//assign new values to numbers in the specific ranges and then store them in the same place in the array
		for(int i = 0 ; i < values.length ; i++)
		{
			if(values[i] > 180)
				values[i] = 190;
			else if(values[i] > 160)
				values[i] = 170;
			else if(values[i] > 140)
				values[i] = 150;
			else if(values[i] > 120)
				values[i] = 130;
			else if(values[i] > 100)
				values[i] = 110;
			else if(values[i] > 80)
				values[i] = 90;
			else if(values[i] > 60)
				values[i] = 70;
			else if(values[i] > 40)
				values[i] = 50;
			else if(values[i] > 20)
				values[i] = 30;
			else 
				values[i] = 10;
			
		}
		
		//display the new quantized values
		System.out.println("Quantized pixel values : ");
		
		for(int i = 0 ; i < values.length ; i++)
		System.out.print(values[i] + "  ");
		
		//white space
		System.out.println();
		
		//print out the closing message
		System.out.print("\nThank you for using the Image Quantization Program!");
		
		
		key.close();

	}

}
