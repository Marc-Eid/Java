// ----------------------------------------------------------------------------------------
// Assignment #2 - COMP 249
// Part 1
// Written by: Marc Eid
// Due Date: Wednesday, August 04, 2021
//-----------------------------------------------------------------------------------------



import java.util.Arrays;


/**
 * 
 * @author Marc Eid
 *
 */
public class Truck {

	private String driverName;
	private String originCity;
	private String destinationCity;
	private double grossWeight;
	private double unloadedWeight;
	private int numberOfPackages = 0;
	private Package[] packageDescription = new Package[200];
	private double grossIncome;
	public static final int MAXPACKAGES = 200;
	
	
	/**
	 * 
	 * constructs and initializes a Truck object.
	 *
	 * @param name driver name
	 * @param from origin city
	 * @param to destination city
	 * @param beforeLoading weight of the truck before loading
	 */
	public Truck(String name, String from, String to, double beforeLoading) {
		driverName = name;
		originCity = from;
		destinationCity = to;
		unloadedWeight = beforeLoading;
	}

	
	
	int i = 0;
	/**
	 * 
	 * @param pack an object of type Package will be loaded to the truck. it will be added to the array 
	 */
	
	public void load(Package pack) { //do the instantiation in the driver
		try {
			
			if(pack.getWeight() > pack.getMaxWeight())
				throw new PackageTooHeavy();
			
			if(!(pack instanceof Letter) && !(pack instanceof Box) && !(pack instanceof Crate) )
				throw new PackageNotAuthorized();
			if(i == 200)
				throw new PackageException("Truck is full");
				
			//Package[] copy = Arrays.copyOf(packageDescription, packageDescription.length + 1); //increment the size of the array
			//packageDescription = copy;
			
			
			packageDescription[i] = pack; //add the new package to the array. 
			i++;
			System.out.println("\n------package loaded------");
			
			
			
		}
		catch(PackageTooHeavy e){
			System.err.println(e.getMessage());
			System.out.println(pack);
			
		}
		catch (PackageNotAuthorized e) {
			System.err.println(e.getMessage());
			System.out.println("Package type: Unkown Package, " + "tracking number: " + pack.getTrackingNumber() + ", weight: " + pack.getWeight() +"lbs" );
		}
		catch (PackageException e) {
			System.err.println(e.getMessage());
			System.err.println("cant load this package: ");
			System.out.println(pack);
		}
		
		
	}
	
	/**
	 * 
	 * @param packageNumber number of package to be removed from the truck. 
	 */

	public void unload(int packageNumber) {
		
		try {
			int count = 0;
			for(int i = 0; i<200 ; i++) {
				
				if(packageDescription[i] != null)
					count++;
				if(count == 0)
					throw new PackageException("there are no packages in this truck");
				
				if(packageDescription[packageNumber-1] == null)
					throw new PackageException("this slot is alredy empty");
			}
			
			int removePackage = packageNumber - 1;

			System.out.println("Unloading package...");
			System.out.println("Package information: ");
			System.out.println(packageDescription[removePackage]);

			packageDescription[removePackage] = null;

//			for(int i = removePackage ; i < packageDescription.length - 1 ; i++) { //remove element
//				packageDescription[i] = packageDescription[i+1];
//			}
//
//			Package[] copy = Arrays.copyOf(packageDescription, packageDescription.length -1 ); //decrement the size of the array
//			packageDescription = copy;



			System.out.println("Package unloaded.");
		}
		catch(PackageException e) {
			System.err.println(e.getMessage());
		}
		
		
		
	}

	/**
	 * 
	 * @return returns the number of packages in the truck
	 */
	public int numberOfPackages() {
		
		int count = 0;
		for(int i = 0 ; i < 200 ; i++)
			if(packageDescription[i] != null)
				count++;
		
		
		return count;
	}
	
	/**
	 * 
	 * @return returns the amount of money that will be generated from the shipment
	 */
	public double grossIncome() {
		
		grossIncome = 0;
		
		for( int i = 0 ; i < packageDescription.length ; i++) {
		
			if(packageDescription[i] == null)
				continue;
			else
				grossIncome += packageDescription[i].getShippingCost(); 
		}
		
		return grossIncome;
	}
	/**
	 * prints the gross weight of the truck after being loaded. in pounds and in kilograms
	 */
	public void grossWeight() { //print in both lbs and kgs
		
		grossWeight = 0;
		for(int i = 0 ; i < packageDescription.length; i++) {
			
			if(packageDescription[i] == null)
				continue;
			else
				grossWeight += packageDescription[i].getWeight();
		}
		
		grossWeight += unloadedWeight;
		
		
	//	System.out.println("The gross weight of the truck is: " + grossWeight + "lbs or " + Truck.tokg(grossWeight) + "kgs.");
		System.out.printf("The gross weight of the truck is: %.2flbs or %.2fkgs", grossWeight, Truck.tokg(grossWeight));
	}
	
	/**
	 * prints that the truck is on its way to deliver
	 */
	public void drive() {
		System.out.println("Truck on route... Driving from " + originCity + " to " + destinationCity);
	}


	/**
	 * exits the program when called
	 */
	public void quit() {
		System.exit(0);
	}

/**
 * 
 * @param lbs the weight in pounds to be converted to kgs
 * @return the weight in kilograms
 */
	public static double tokg(double lbs) {

		
		return (lbs / 2.205);
	}
/**
 * 
 * @param kg the weight in kilograms to be converted to pounds
 * @return the weight in pounds
 */
	
	public static double toLb(double kg) {

		return (kg * 2.205);
	}


/**
 * prints the truck driver's name
 */
	public String toString() {
		return (driverName);
	}


}
