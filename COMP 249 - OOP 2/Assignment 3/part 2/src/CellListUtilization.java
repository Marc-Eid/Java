// ----------------------------------------------------------------------------------------
// Assignment #3 - COMP 249
// Part 2
// Written by: Marc Eid
// Due Date: Thursday 19 August
//-----------------------------------------------------------------------------------------


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CellListUtilization {

	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner key = new Scanner(System.in);
		
		//welcome message.
		System.out.println("Welcome to the phone list program, written by Marc.\n");
		
		//create at least 2 empty lists 
		CellList list1 = new CellList();
		CellList list2 = new CellList();

		//open the file to be read. 
		Scanner inFile = new Scanner(new FileInputStream("Cell_Info.txt"));
	
		//read the file and instantiate new phone with the read desription. then add the new phones to the beginning of the list.
		while(inFile.hasNext()) {
			long num = inFile.nextLong();
			String name = inFile.next();
			double price = inFile.nextDouble();
			int year = inFile.nextInt();
			if(list1.getSize() !=0 && list1.contains(num))
				continue;
			list1.addToStart(new CellPhone(num, name, year, price));
		}
	
		//print the size and the content of the list. 
		System.out.println("The current size of the list is " + list1.getSize() + ". Here are the contents of the list: ");
		System.out.println("======================================================================");
		list1.showContents();
		
		System.out.println();
		
		
		
		//prompt the user for a few serial numbers to check if they exist or not. 
		System.out.print("Enter a few serial numbers: ");
		String num = key.nextLine();
		
		// put the serial numbers in the array numbers. 
		StringTokenizer numbers = new StringTokenizer(num, " ");

		while(numbers.hasMoreTokens()) {
			long SerialNumber = Long.parseLong( numbers.nextToken()) ;
			
			if(list1.contains(SerialNumber   ) )
				System.out.println("The serial number " + SerialNumber + " already exists in this list. It was found in "
						+ CellList.specialCount + " iterations.");
			else
				System.out.println("The serial number " + SerialNumber + " does not exist in this list.");

		}
		System.out.println();
		
		
		//Some method testing........................................
		
		//instantiate a new list. which is a copy of the first list. we want to see if it truly generates a deep copy. we will modify list 3 and then print list3
		// and print list1.
		CellList list3 = new CellList(list1);
		
		//add new phone to the list.
		list3.addToStart(new CellPhone(5909883, "Iphone", 2000, 700) );
		
		//delete the second phone in the list.
		list3.deleteAtIndex(1);
		
		//add a new phone to the list at the second postion. 
		list3.insertAtIndex(new CellPhone(1119000, "SonyEricsson" ,2009, 347.94), 1);
		
		//delete the first phone object.
		list3.deleteFromStart();
		
		//replace 
		System.out.println("replacing the 3 item...");
		list3.replaceAtIndex(new CellPhone(1119000, "SonyEricsson" ,2009, 347.94), 2);

		
		
		
		
		//printing list 3.
		System.out.println();
		System.out.println("The current size of list 3 is " + list3.getSize() + ". Here are the contents of the list: ");
		System.out.println("======================================================================");
		list1.showContents();

		//printing list 1
		System.out.println();
		System.out.println("The current size of list 1 is " + list1.getSize() + ". Here are the contents of the list: ");
		System.out.println("======================================================================");
		list1.showContents();
		
		//although we played a bit with list 3. when the contents of the list were equal to the list1. the answer came back as true. which shows that the
		//content is being tested and not the references. 
		System.out.println();
		System.out.println("The two Lists are equal: " + list1.equals(list3));

	
	System.out.println("\nEnd of Program");
	}

}
