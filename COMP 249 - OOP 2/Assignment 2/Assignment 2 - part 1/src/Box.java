// ----------------------------------------------------------------------------------------
// Assignment #2 - COMP 249
// Part 1
// Written by: Marc Eid
// Due Date: Wednesday, August 04, 2021
//-----------------------------------------------------------------------------------------



/**
 * 
 * child class of Package Class
 *
 */

public class Box extends Package{

	public final double COST = 2;
	public final String TYPE = "Box";
	public final static int MAXWEIGHT = 40;
	
	/**
	  * constructs and initializes a Box object.
	  * @param tracking tracking number of the package
	  * @param w weight of the package
	  * @param shippingCost shipping cost of the package
	  */
	
	public Box(long tracking , double w, double shippingCost) {
		super(tracking, w, shippingCost);
	}
	
	/**
	 * calculates the shipping cost of the packages based on its type and weight
	 */
	public double shippingCost() {

		setShippingCost(COST * getWeight());

		return getShippingCost();
	}
	
	/**
	 * returns the specified max weight according to the type
	 */
	
	public int getMaxWeight() {
		return MAXWEIGHT;
	}
	
	/**
	 * displays the description of the object of class Box
	 */
	public String toString() {

		return ("Package type: " + TYPE + ", tracking number : " + this.getTrackingNumber() + ", weight: " + this.getWeight());
	}
	
	
	
	
	
	
	
	
}
