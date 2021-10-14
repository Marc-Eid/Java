// ----------------------------------------------------------------------------------------
// Assignment #2 - COMP 249
// Part 1
// Written by: Marc Eid 40153034
// Due Date: Wednesday, August 04, 2021
//-----------------------------------------------------------------------------------------



/**
 * 
 * @author Marc Eid
 * Abstract Class and parent class
 */
public abstract class Package {
	
	private long trackingNumber; //0 for letter. 1 for box. 2 for wooden crate. 3 for metal crate. 
	private double weight;
	private double shippingCost; //based on weight
	
 /**
  * Initializes a Packages object's attribute when called from a child class. since this class cant be instantiated.
  * @param tracking tracking number of the package
  * @param w weight of the package
  * @param shippingCost shipping cost of the package
  */
	public Package(long tracking , double w, double shippingCost) {
		trackingNumber = tracking;
		weight = w;
		this.shippingCost = shippingCost;
	}
	
	/**
	 * abstract classes to be implemented in the child classes
	 */
	abstract public String toString();
	abstract public double shippingCost();
	abstract public int getMaxWeight();

	/**
	 * changes the cost of shipping to the passed value
	 * @param cost cost of the shipping
	 */
	public void setShippingCost(double cost) {
	
		shippingCost = cost;
	
	}

	/**
	 * 
	 * @return returns the shipping cost of the package
	 */
	public double getShippingCost() {
		return shippingCost;
	}

	/**
	 * sets the weight of the package to the passed value
	 * @param w weight of the package
	 */
	public void setWeight(double w) {
		weight = w;
	}
	
	/**
	 * 
	 * @return returns the weight of the package
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * changes the tracking number of a package to the passed value
	 * @param tn tracking number of the package
	 */
	public void setTrackingNUmber(long tn) {
		trackingNumber = tn;
	}

	/**
	 * 
	 * @return returns the tracking number of the package
	 */
	public long getTrackingNumber() {
		return trackingNumber;
	}

/**
 * converts from ounces to pounds.
 * @param ounce the weight of the package in ounces
 * @return return the weight in pounds
 */
	public static double toPounds(double ounce) {
		
		return (ounce * (1/16.0) );
	}

/**
 * converts from pounds to ounces
 * @param lbs the weight of the package in pounds
 * @return returns the weight in ounces
 */
	public static double toOunces(double lbs) {
		
		return (lbs * 16.0);
	}








}



