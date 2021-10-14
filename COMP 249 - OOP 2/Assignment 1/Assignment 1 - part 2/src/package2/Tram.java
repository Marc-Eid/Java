// ----------------------------------------------------------------------------------------
// Assignment #1 - COMP 249
// Part 2
// Written by: Marc Eid 40153034
// Due Date: Sunday, July 18, 2021
//-----------------------------------------------------------------------------------------


package package2;

import java.util.Arrays;

/**
 * sub-class of the CityBus class.
 *
 */
public class Tram extends CityBus {

	private int maxSpeed;
	
	
	/**
	 * constructs and initializes a Tram object. initializes all primitive data types to 0.
	 */
	public Tram()
	{
		super();
		maxSpeed = 0;
	}
	
	
	/**
	 * constructs and initializes a Tram object.
	 * @param price tram ticket price
	 * @param stops number of stops
	 * @param route route name
	 * @param year year the tram started operating
	 * @param line line name
	 * @param speed maximum speed of the tram
	 * @param names driver name(s)
	 */
	public Tram(double price , int stops, long route, int year, String line, int speed, String... names)
	{
		super(price, stops, route, year, line, names); //parent constructor
		maxSpeed = speed;
	}
	
	
	/**
	 * constructs and initializes a Tram object that is a copy of the passed object  
	 * @param other an object of type Tram, will be copied.
	 */
	public Tram(Tram other)
	{
		super(other.getTicketPrice(), other.getNbOfStops(), other.getRouteNumber(), other.getBeginOperationYear(), other.getLineName(), other.getName());
		maxSpeed = other.maxSpeed;
	}
	
	
	/**
	 * 
	 * @return the maximum speed of the tram
	 */
	public int getMaxSpeed()
	{
		return maxSpeed;
	}
	
	
	/**
	 * 
	 * @param speed set the maximum speed of the tram
	 */
	public void setMaxSpeed(int speed)
	{
		maxSpeed = speed;
	}
	
	
	/**
	 * displays the description of the object of class Tram
	 */
	public String toString()
	{
		String result = "";
		String[] copy1 = getName();
		for(int i = 0; i < copy1.length; i++)
		{
			if(copy1.length > 1)
			{
				if(i == copy1.length - 2  )
					result += copy1[i] + ", and ";
				
				else if(i == copy1.length-1)
					result += copy1[i] + ".";
					else
						result += " " + copy1[i] + ", ";
			}	
			
			else
				result =copy1[i] + ".";
		}
		
		
		return ("This tram has " + getNbOfStops() + " stops, and costs " + getTicketPrice() + "$. Its maximum speed is " + getMaxSpeed() + "km/h." +
	     " Its route number is " + getRouteNumber() + ". It began operating in year " + getBeginOperationYear() + ", having the line name " + getLineName() + 
	      ". Finally, its driver(s) is/are: " + result);
				
	}
	
	
	/**
	 * tests whether the passed object is null, of a different class of the calling object, and finally if the two objects have the same content
	 * @param otherObject The object to compare the calling object against
	 * @return true if the given object represents an object equivalent to the calling object, false otherwise
	 */
	public boolean equals(Object otherObject)
	{
		if(otherObject == null || this == null) //this only checks if the objects is null. this happens if an object is initialized to null. otherwise it doesnt serve any purpose
			return false;
		else if(this.getClass() != otherObject.getClass())
			return false;

		else
		{
			Tram otherTram = (Tram) otherObject;
			return (getTicketPrice() == otherTram.getTicketPrice() && this.getNbOfStops() == otherTram.getNbOfStops() && getRouteNumber() == otherTram.getRouteNumber()
					&& getBeginOperationYear() == otherTram.getBeginOperationYear() && getLineName().equals( otherTram.getLineName() ) 
					&& Arrays.equals(getName(), otherTram.getName()) && maxSpeed == otherTram.maxSpeed);
		}
		
	}
	
	
	
	
}
