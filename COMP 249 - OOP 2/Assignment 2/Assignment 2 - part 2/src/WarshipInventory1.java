// ----------------------------------------------------------------------------------------
// Assignment #2 - COMP 249
// Part 2
// Written by: Marc Eid
// Due Date: Wednesday, August 04, 2021
//-----------------------------------------------------------------------------------------



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

/**
 * 
 * @author Marc Eid
 *
 */
public class WarshipInventory1 {


	private static Warships[] wsArr;
	
	/**
	 * this method fixes the duplicate serial numbers and then prints the corrected content to a new specified file. 
	 * @param inputFileName the name of the file to be corrected
	 * @param outputFileName the name of the file that will hold the corrected content
	 */
	public static void fixInventory(String inputFileName , String outputFileName) { //the outputfile should be a copy of the output file but corrected first. 
		
		Scanner keyIn = new Scanner(System.in); //this is to read the new serial number form the keyboard
		PrintWriter out = null; //creating the file
		Scanner inFile = null; //opening the file
		try { //checks if the files exist or cant be openned

			out = new PrintWriter(new FileOutputStream(outputFileName));
			inFile = new Scanner(new FileInputStream(inputFileName));
			 
		} catch (FileNotFoundException e) {
			System.out.println("Error Openning File.");
			System.exit(0);
		}

		wsArr = new Warships[records(inputFileName)]; //create an array that has the size of the lines in the file that is to be corrected
		
		System.out.println();
		System.out.println("Detecting number of records in file : " + inputFileName);
		System.out.println();
		System.out.println("the file has " + wsArr.length + " records.");
		
		if(wsArr.length == 0) //if the original file has 0 or 1 records the files will be closed. 
		{
			out.close();
			inFile.close();
			System.exit(0);
		}
		
		for(int i =0 ; i < wsArr.length ; i++) { //read the file and create the objects in the array
			long num = Long.parseLong(inFile.next());
			String name = inFile.next();
			int year = Integer.parseInt(inFile.next());
			String country = inFile.next();
			double price = Double.parseDouble(inFile.next());
			int speed = Integer.parseInt(inFile.next());
			
			wsArr[i] = new Warships(num, name, year, country, price, speed);
		}
		
		
		for(int i = 0; i < wsArr.length; i++) //go over the file to check if there are duplicates and then prompt the user for new number
			for(int j = i+1 ; j < wsArr.length; j++)
			{
				if(wsArr[i].getSerialNumber() == wsArr[j].getSerialNumber())
				{
					System.out.print("Duplicate serial number " + wsArr[i].getSerialNumber() + " detected in record # " + (j+1) 
							+ ". Please enter the correct serial number: ");
					long newNum = keyIn.nextLong();
					
					while(isDuplicate(newNum))
					{
						System.out.print("Duplicate serial number " + wsArr[i].getSerialNumber() + " detected in record # " + (j+1) 
								+ ". Please enter the correct serial number: ");
						//System.out.print("please enter another serial number: ");
						newNum = keyIn.nextLong();
					}
					
					
					wsArr[j].setSerialNumber(newNum);
				}
			}
		
		for(int i =0 ; i < wsArr.length ; i++) { // write the content to the file
			
			String toWrite = wsArr[i].getSerialNumber() + " " + wsArr[i].getName() + " " + wsArr[i].getCreationYear()
					+ " " + wsArr[i].getOwnerCountry() + " " + wsArr[i].getPrice() + " " + wsArr[i].getSpeed();
			out.println(toWrite);
			
			
		}
		

		out.close();
		inFile.close();
	}
	
	/**
	 * this method checks if the users enters an already existing serial number
	 * @param newNum the new serial number to be checked
	 * @return returns true if its a duplicate. else false
	 */
	private static boolean isDuplicate(long newNum) {

		boolean done = false;
		int k = 0;
		while(!done) {
			try {
				
				for( k = 0 ; k< wsArr.length ; k++)
				{
					if(newNum == wsArr[k].getSerialNumber())
						throw new DuplicateSerialNumberException();
				}
				done = true;
			}
			catch (DuplicateSerialNumberException e) {
				System.out.println("Attempt of duplicate entry to a previous record");
				System.out.println("Initial appearance of serial number " + newNum + " was found at record #: " + (k+1));
				System.out.println("Error.... Duplicate entery of serial number. the entered serial number exists for another record.");
				return true;
			}
		}

		return false;
	}

	
	
	
	/**
	 * this method checks how many records there are in the file
	 * @param inputFile the file name to check
	 * @return returns the number of records
	 */
	
	private static int records(String inputFile) {
		int count = 0;
		Scanner inFile = null;
		try {
			inFile = new Scanner(new FileInputStream(inputFile));
		} catch (FileNotFoundException e) {
			System.out.println("input File doesnt exist");
		}
		
		while(inFile.hasNextLine()) {
			count++;
			inFile.nextLine();
		}
		if(count == 0 || count ==1) {
			System.out.println("closing file, since there is nothing to fix");
			inFile.close();
			return 0;
		}
		return count;
		
	}
	
	/**
	 * this method prints out the content of files
	 * @param inputFileName the name of the file that will be displayed
	 */
	
	public static void displayFileContents(String inputFileName) {
		
		Scanner inFile = null;
		try {
	
		inFile = new Scanner(new FileInputStream(inputFileName));
		
		
		while(inFile.hasNextLine()) {
			String description = inFile.nextLine();
			System.out.println(description);
		}
		
	
		
		}
		catch(FileNotFoundException e) {
			System.out.println("file not found");
			System.exit(0);
		}
		inFile.close();
		
	}
	
	//======================================================================
	//the start of the main method
	
	public static void main(String[] args) {
		
		
		Scanner key = new Scanner(System.in);
		
		boolean done = false;
		String name = null;
		File outputFile= null;
		File inputFile = null;
		
		while(!done) { //keep asking for a new file name of it already exists. 

			
			try {
				System.out.print("Please enter the name of the output File, which will have the correct info: ");
				name = key.next();

				outputFile = new File(name);
				inputFile = new File("Initial_Cargoship_Info.txt");
		

				if(outputFile.exists())
					throw new FileAlreadyExistsException("Error: There is an existing file called: " + outputFile.getName());

				
				done = true;
				
			}
			catch(FileAlreadyExistsException e) {
				System.out.println(e.getMessage());
				System.out.println("That file already has a size of " + inputFile.length() + " bytes.");
			}
			
			
		}
		
			
		//display the content of both files
		fixInventory("Initial_Cargoship_Info.txt" , name);
		
		System.out.println();
		System.out.println("Here are the contents of file " + inputFile.getName() + "AFTER copying operation: ");
		System.out.println("========================================================================");
		displayFileContents(inputFile.getName());
		
		System.out.println();
		System.out.println("Here are the contents of file " + name + ":");
		System.out.println("========================================================================");
		displayFileContents(name);
		
		
		key.close();
	}
}
