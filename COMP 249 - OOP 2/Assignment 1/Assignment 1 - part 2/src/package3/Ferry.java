// ----------------------------------------------------------------------------------------
// Assignment #1 - COMP 249
// Part 2
// Written by: Marc Eid 40153034
// Due Date: Sunday, July 18, 2021
//-----------------------------------------------------------------------------------------


package package3;
import package1.PublicTransportation;

/**
 * 
 * sub-class of PublicTransportation
 *
 */
public class Ferry extends PublicTransportation{
	
	private int buildYear;
	private String shipName;
	
	
	/**
	 * constructs and initializes a Ferry object. initializes all primitive data types to 0.
	 */
	public Ferry()
	{
		super();
		buildYear = 0;
		shipName = "N/A";
	}
	
	
	/**
	 * constructs and initializes a Ferry object.
	 * @param price ferry ticket price
	 * @param stops number of stops of the ferry
	 * @param buildYear year the ferry was built
	 * @param name ship name
	 */
	public Ferry(double price , int stops, int buildYear, String name)
	{
		super(price, stops);
		this.buildYear = buildYear;
		shipName = name;
	}
	
	
	/**
	 * constructs and initializes a Ferry object that is a copy of the passed object  
	 * @param other an object of type Ferry, will be copied.
	 */
	public Ferry(Ferry other)
	{
		super(other.getTicketPrice(), other.getNbOfStops());
		this.buildYear = other.buildYear;
		this.shipName = other.shipName;
	}

	
	/**
	 * @return year ferry was built
	 */
	public int getBuildYear()
	{
		return buildYear;
	}
	
	
	/**
	 * 
	 * @return ship name
	 */
	public String getName() 
	{
		return shipName;
	}
	
	
	/**
	 * 
	 * @param year build year to set
	 */
	public void setBuildYear(int year)
	{
		buildYear = year;
	}
	
	
	/**
	 * 
	 * @param name ship name to set
	 */
	public void setShipName(String name)
	{
		shipName = name;
	}
	
	
	/**
	 * displays the description of the object of class Ferry
	 */
	public String toString()
	{	
		return ("This ferry is called \"" + getName() + "\". It has " + getNbOfStops() + " stops and costs " + getTicketPrice() +
	     "$." + " It was built in year " + getBuildYear() + ".");		
	}
	
	
	/**
	 * tests whether the passed object is null, of a different class of the calling object, and finally if the two objects have the same content
	 * @param otherObject The object to compare the calling object against
	 * @return true if the given object represents an object equivalent to the calling object, false otherwise
	 */
	public boolean equals(Object otherObject)
	{
		if(otherObject == null) //this only checks if the objects is null. this happens if an object is initialized to null. otherwise it doesnt serve any purpose
			return false;
		else if(this.getClass() != otherObject.getClass())
			return false;

		else
		{
			Ferry otherFerry = (Ferry) otherObject;
			return (getTicketPrice() == otherFerry.getTicketPrice() && this.getNbOfStops() == otherFerry.getNbOfStops() 
					&& this.buildYear == otherFerry.buildYear && shipName.equals(otherFerry.shipName));
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}