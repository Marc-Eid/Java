// ----------------------------------------------------------------------------------------
// Assignment #2 - COMP 249
// Part 1
// Written by: Marc Eid 40153034
// Due Date: Wednesday, August 04, 2021
//-----------------------------------------------------------------------------------------



import java.util.Scanner;

public class CargoTest {

	public static void main(String[] args) {
	
		
		Scanner key = new Scanner(System.in);
		int choice;
		
		Truck truck1 = null;
		
		do {
			
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("1. Start a cargo");
			System.out.println("      a. Driver name");
			System.out.println("      b. Unload Weight(kg; lb)");
			System.out.println("      c. Originating City");
			System.out.println("      d. Destination City");
			
			System.out.println("2. Load the truck with packages");
			System.out.println("      a. Package tracking number");
			System.out.println("      b. Package weight(oz; lb)");
			System.out.println("      c. Package shipping cost");
			
			
			System.out.println("3. Unload package");
			System.out.println("4. The number of packages loaded");
			System.out.println("5. The gross income earned by shipping of the cargo");
			System.out.println("6. Weight of the truck after loading");
			System.out.println("7. Drive the truck to destination");
			System.out.println("0. To quit");
			
			System.out.print("Please enter your choice and press <Enter>: ");
			choice = key.nextInt();
			System.out.println();
			
			
			if(choice == 1) {
				System.out.print("driver name: ");
				String name = key.next();
				
				System.out.print("\nUnload weigth in lbs: ");
				double netWeight = key.nextDouble();
				
				System.out.print("\nOriginating City: ");
				String fromCity = key.next();
				
				System.out.print("\nDestination City: ");
				String toCity = key.next();
				
				truck1 = new Truck(name, fromCity, toCity, netWeight);
			}
			else if(choice == 2) {
				System.out.print("\nTracking number: ");
				long num = key.nextLong();
				
				System.out.println("\nPackage Weight in lbs: ");
				double w = key.nextDouble();
				
				System.out.println("\nPackage shipping cost: ");
				double cost = key.nextDouble();
				
				int id =  (int)num % 10;
				
				switch (id) {
				case 0: 
					Letter letter1 = new Letter(num, w, cost); 
					truck1.load( letter1 );
					break;
				case 1:	
					Box box1 = new Box(num, w, cost);
					truck1.load( box1 );
					break;
				case 2: 
					WoodCrate wood1= new WoodCrate(num, w, cost);
					truck1.load( wood1 );
					break;
				case 3: 
					MetalCrate metal1 = new MetalCrate(num, w, cost); 
					truck1.load( metal1 );
					break;
				default:
					try {
					throw new PackageNotAuthorized();
					}
					catch (PackageNotAuthorized e) {
						System.err.println(e.getMessage());
						System.out.println("Package type: Unkown Package, " + "tracking number: " + num + ", weight: " + w +"lbs" );
					}
					
				}
				
				
				
			}
			else if(choice == 3) {
				System.out.println("which package do you want to unload?: ");
				int unloadPackageNum = key.nextInt();
				truck1.unload(unloadPackageNum);

			}
			else if(choice == 4) {
				System.out.println(truck1.numberOfPackages() + " packages.");
			}
			else if(choice == 5) {
				System.out.println("The gross income of this cargo is: $" + truck1.grossIncome());
			}
			else if(choice == 6) {
				truck1.grossWeight();
				System.out.println();
			}
			else if(choice == 7) {
				truck1.drive();
			}
			else if(choice == 0)
				break;
			
			
			
			
			
			
			
		}while(choice != 0);
		
		System.out.println("end of program");
		
		
		
		
		
		
	}
}
