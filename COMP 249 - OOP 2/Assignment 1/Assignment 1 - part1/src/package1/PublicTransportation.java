// ----------------------------------------------------------------------------------------
// Assignment #1 - COMP 249
// Part 1
// Written by: Marc Eid 40153034
// Due Date: Sunday, July 18, 2021
//-----------------------------------------------------------------------------------------

/**
 * this is the parent class of the other class in this Assignment.
 */

package package1;

/**
 * 
 * parent class
 *
 */
public class PublicTransportation {

	//setting the attributes to protected so that the subclasses can use their names directly. since the subclasses are in different packages we must use protected
	protected double ticketPrice;
	protected int nbOfStops;
	
	
	/**
	 * constructs and initializes a PublicTransportation object.
	 */
	public PublicTransportation()
	{
		ticketPrice = 0; //these two initializations could have been ommitted as they would be auto-initialized to the 0 of their type. this applies to all other default constructors
		nbOfStops = 0; 
	}
	
	
	/**
	 * constructs and initializes a PublicTransportation object.
	 * @param price price of the ticket
	 * @param stops number of stops of this mode of transportation
	 */
	public PublicTransportation(double price , int stops)
	{
		ticketPrice = price;
		nbOfStops = stops;
	}
	
	
	/**
	 * constructs and initializes a PublicTransportation object that is a copy of the passed object  
	 * @param other an object of type PublicTransportation, will be copied.
	 */
	public PublicTransportation(PublicTransportation other)
	{
		this.ticketPrice = other.ticketPrice;
		this.nbOfStops = other.nbOfStops;
	}
	
	
	
	/**
	 * 
	 * @return the price of the ticket
	 */
	public double getTicketPrice()
	{
		return ticketPrice;
	}
	
	
	/**
	 * 
	 * @return the number of stops
	 */
	public int getNbOfStops()
	{
		return nbOfStops;
	}
	
	
	/**
	 * changes the price of the ticket to the passed value
	 * @param price the new price
	 */
	public void setTicketPrice(double price)
	{
		ticketPrice = price;
	}
	
	
	/**
	 * changes the number of stops to the passed value
	 * @param stops the new number of stops
	 */
	public void setNbOfStops(int stops)
	{
		nbOfStops = stops;
	}
	
	
	/**
	 * displays the description of the object of class PublicTransportation
	 */
	public String toString()
	{
		
		return ("This public trasportation has " + getNbOfStops() + " stops, and costs " + getTicketPrice() +
	     "$.");		
	}
	
	
	/**
	 * tests whether the passed object is null, of a different class of the calling object, and finally if the two objects have the same content
	 * @param otherObject The object to compare the calling object against
	 * @return true if the given object represents an object equivalent to the calling object, false otherwise
	 */
	public boolean equals(Object otherObject)
	{
		if(otherObject == null) //this only checks if the objects is null. this happens if an object is initialized to null. otherwise it doesnt serve any purpose
			return false;       //in this program, objects like Strings and arrays are created in the default constructor. so Strings are not null.
								// although the arrays contain null Strings, the array itself is created and is not null. 
		else if(this.getClass() != otherObject.getClass()) //tests if they are of different classes
			return false;

		else //test content equality
		{
			PublicTransportation otherPublic = (PublicTransportation) otherObject;
			return (ticketPrice == otherPublic.ticketPrice && this.nbOfStops == otherPublic.nbOfStops);
		}
		
	}



}