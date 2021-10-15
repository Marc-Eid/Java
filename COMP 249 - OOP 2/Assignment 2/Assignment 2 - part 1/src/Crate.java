// ----------------------------------------------------------------------------------------
// Assignment #2 - COMP 249
// Part 1
// Written by: Marc Eid
// Due Date: Wednesday, August 04, 2021
//-----------------------------------------------------------------------------------------



/**
 * 
 * child class of Package Class.
 * Abstract Class
 *
 */
public abstract class Crate extends Package{

	/**
	  * Initializes a Crate object's attribute when called from a child class. since this class cant be instantiated.
	  * @param tracking tracking number of the package
	  * @param w weight of the package
	  * @param shippingCost shipping cost of the package
	  */
	
	public Crate(long tracking , double w, double shippingCost) {
		super(tracking, w, shippingCost);
	}
	

	
	public abstract int getMaxWeight();
	public abstract double shippingCost();
	public abstract String toString();
	
	
	

}
