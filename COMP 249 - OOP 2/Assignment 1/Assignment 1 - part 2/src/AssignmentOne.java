// ----------------------------------------------------------------------------------------
// Assignment #1 - COMP 249
// Part 2
// Written by: Marc Eid
// Due Date: Sunday, July 18, 2021
//-----------------------------------------------------------------------------------------

import java.util.Arrays;



import package1.PublicTransportation;
import package2.CityBus;
import package2.Metro;
import package2.Tram;
import package3.Ferry;
import package4.AirCraft;

/**
 * 
 * driver class containing the main method
 *
 */
public class AssignmentOne {

	//the copying of the array is correct. This can be seen when each element of both arrays are printed out they are exactly the same.
	//a new array for the same type was created. for each element of the array it was tested for which class it belonged to.
	//then the copy constructor of that class was used. the elements of the array to be coppied were cast to that class. since they will by default have the class of the array
	/**
	 * 
	 * @param toCopy array of type PublicTransportation to copy
	 * @return a copy of the array that was passed
	 */
	public static PublicTransportation[] copyCityBuss(PublicTransportation[] toCopy)
	{
		PublicTransportation[] copy = new PublicTransportation[toCopy.length];	
	
		for(int i = 0; i < toCopy.length; i++)
		{
			if(toCopy[i] instanceof Tram)
				copy[i] = new Tram((Tram)toCopy[i]);
			else if(toCopy[i] instanceof Metro)
				copy[i] = new Metro((Metro)toCopy[i]);
			else if(toCopy[i] instanceof Ferry)
				copy[i] = new Ferry((Ferry)toCopy[i]);
			else if(toCopy[i] instanceof AirCraft)
				copy[i] = new AirCraft((AirCraft)toCopy[i]);
			else if(toCopy[i] instanceof CityBus)
				copy[i] = new CityBus((CityBus)toCopy[i]);
			else if(toCopy[i] instanceof PublicTransportation)
				copy[i] = new PublicTransportation(toCopy[i]);
		}
		
		return copy;
	}
	
	
	public static void main(String[] args) {
	
		//creating objects of the different classes
		
		PublicTransportation trans1 = new PublicTransportation();
		PublicTransportation trans2 = new PublicTransportation(3.50, 10);
		
		CityBus bus1 = new CityBus();
		CityBus bus2 = new CityBus(3.50, 10, 12562, 2018, "West", "Josh", "George", "Dan");
		
		
		Tram firstTram = new Tram();
		Tram secondTram = new Tram(4.25, 3, 668, 1995, "east", 38, "Jennifer");
		Tram thirdTram = new Tram();
		
		Metro metro1 = new Metro();
		Metro metro2 = new Metro( 5, 25, 985, 2010, "Cote-Vertu", 5, "Montreal", "Marc", "Fadi");
		
		Ferry ferry1 = new Ferry();
		Ferry ferry2 = new Ferry(10, 0, 2002, "Ferry Canada");
		
		AirCraft plane1 = new AirCraft();
		AirCraft plane2 = new AirCraft(2100, 1, "AIRLINE", "MONTHLY");
		
		
		
		
		//displaying the contents of each of the created objects
		System.out.println("The first bus: " + bus1);
		System.out.println("\nThe second bus: " + bus2);
		
		System.out.println("\nThe first tram: " + firstTram);
		System.out.println("\nThe second tram: " + secondTram);
		
		System.out.println("\nThe first metro: " + metro1);
		System.out.println("\nThe second metro: " + metro2);
		
		System.out.println("\nThe first ferry: " + ferry1);
		System.out.println("\nThe second ferry: " + ferry2);
		
		System.out.println("\nThe first plane: " + plane1);
		System.out.println("\nThe second plane: " + plane2);
		System.out.println();
		
		//testing whether the objects have equal content or not
		System.out.println("testing whether the 2 CityBus objects are equal: " + bus1.equals(bus2));
		System.out.println("testing whether the ferry1 and plane1 are equal, since both are auto-initialized: " + ferry1.equals(plane1));
		System.out.println("testing whether firstTram and thirdTram are equal, since both must have the same content: " + firstTram.equals(thirdTram) );
		
		
		//creating an array of 15 objects
		PublicTransportation[] arr1 = new PublicTransportation[15];
		
		arr1[0] = new PublicTransportation(3.50, 10);
		arr1[1] = new CityBus(3.50, 10, 12562, 2018, "West", "Josh", "George", "Dan");
		arr1[2] = new Tram(4.25, 3, 668, 1995, "east", 38, "Jennifer");
		arr1[3] = new Metro(5, 25, 985, 2010, "Cote-Vertu", 5, "Montreal", "Marc", "Fadi");
		arr1[4] = new Ferry(10, 0, 2002, "Ferry Canada");
		arr1[5] = new AirCraft(2200, 1, "GLIDER", "WEEKLY");
		arr1[6] = new PublicTransportation(3.00, 7);
		arr1[7] = new CityBus(4.25, 9, 9124, 2013, "East", "Johhny");
		arr1[8] = new Tram(5.13, 1, 1232, 2003, "fifty-nine", 52, "Laura");
		arr1[9] = new Metro(3.25, 12, 999, 2015, "Montmorency", 7, "Laval", "Bob");
		arr1[10] = new Ferry(12, 1, 2008, "St-lawrence Ferry");
		arr1[11] = new AirCraft(1000, 1, "BALLOON", "WEEKLY");
		arr1[12] = new PublicTransportation(4.00, 15);
		arr1[13] = new CityBus(3.75, 4, 12531, 2014, "North", "Mathew");
		arr1[14] = new Tram(4.25, 5, 773, 2007, "South-East", 43, "Hans");
		
	
		//the code below attempts to trace the objects that are the least and most expensive then displaying their content along with their index in that array
		//the minIndex and maxIndex store the indexes of the least and most expensive ones. the min and max variables store the ticket price of the leasnt and most expensive ones
		int minIndex = 0;
		int maxIndex = 0;
		double min = arr1[0].getTicketPrice();
		double max = arr1[0].getTicketPrice();
		
		for(int i = 0; i < arr1.length; i++ )
		{
			if(arr1[i].getTicketPrice() < min)
			{
				minIndex = i;
				min = arr1[minIndex].getTicketPrice();
			}
			if(arr1[i].getTicketPrice() > max)
			{
				maxIndex = i;
				max = arr1[i].getTicketPrice();
			}
		
		}
	
		System.out.println();
		System.out.println("the least expensive one has the index " + minIndex + " : " + arr1[minIndex]);
		System.out.println();
		System.out.println("the most expensive one has the index " + maxIndex + " : " + arr1[maxIndex]);

		
		
		//creating an array of 12 objects to test the copyCityBuss static method
		PublicTransportation[] arr2 = new PublicTransportation[12];
			
		arr2[0] = new PublicTransportation(3.50, 10);
		arr2[1] = new CityBus(3.50, 10, 12562, 2018, "North-West", "Manny", "David");
		arr2[2] = new Tram(4.25, 3, 668, 1995, "South", 34, "Jacky");
		arr2[3] = new Metro(5, 25, 985, 2010, "Cote-Vertu", 5, "Vaudreuil", "Marco", "Fadi");
		arr2[4] = new Ferry(13, 0, 2002, "Ferry Quebec");
		arr2[5] = new AirCraft(1800, 0, "HELICOPTER", "YEARLY");
		arr2[6] = new PublicTransportation(3.00, 6);
		arr2[7] = new CityBus(4.25, 9, 9124, 2013, "North-East", "Jaden");
		arr2[8] = new Tram(5.13, 1, 1232, 2003, "Thrity-four", 22, "Isabelle");
		arr2[9] = new Metro(3.25, 12, 999, 2015, "Montmorency", 7, "Laval", "Jacob");
		arr2[10] = new Ferry(12, 1, 2008, "St-lawrence Ferry");
		arr2[11] = new AirCraft(500, 1, "AIRLINE", "WEEKLY");
		
		//creating an array and storing in it the reference of the copy of arr2
		PublicTransportation[] arr3 = copyCityBuss(arr2);
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("printing the copied array and the array to copy to make sure the copying was correct");		
		System.out.println();
		
		//displaying the 12 objects of the two arrays arr2 and arr3, one elements a t a time to see whether their objects are equal
		for(int i = 0; i< arr2.length; i++)
		{
			System.out.println(arr2[i]); //polymorphism happening, since the toString of each subclass is being called automatically
			System.out.println(arr3[i]); //polymorphism happening
			System.out.println();
			
		}
		
		//end of program message
		System.out.println("-----------------------");
		System.out.println("   End Of Program");
		System.out.println("-----------------------");
		
		
		
		
	}

}
